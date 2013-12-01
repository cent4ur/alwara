// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.web;

import hu.cent4ur.alwara.model.Person;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

/**
 * Managing login.
 * 
 * @author Sandor Balazs
 */
@Named
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 8688525412794257032L;
    private static final Logger logger = Logger.getLogger(LoginBean.class
            .getName());
    private final EntityManager entityManager;
    private String username;
    private String password;
    private Boolean loggedIn;

    public LoginBean() {
        logger.info("LoginBean() - Initialization");
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AlwaraPersistenceUnit");
        entityManager = emf.createEntityManager();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    private byte[] getHash(String password)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        return digest.digest(password.getBytes("UTF-8"));
    }

    public void login(ActionEvent event) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        logger.info("login() - Authenticating " + username);
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        loggedIn = false;

        logger.info("login() - Query user data.");
        String hash = new BigInteger(1, getHash(password)).toString(16);
        TypedQuery<Person> query = entityManager.createNamedQuery(
                "Person.find", Person.class).setParameter("name", username)
                .setParameter("password", hash);

        Boolean registered = false;
        try {
            query.getSingleResult();
            registered = true;
        } catch (NoResultException e) {
            logger.info("login() - User is not authenticated");
        } catch (NonUniqueResultException e) {
            logger.log(Level.SEVERE, "login() - More than one result.", e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "login() - Exception.", e);
        }

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ResourceBundle bundle = FacesContext.getCurrentInstance()
                .getApplication().getResourceBundle(facesContext, "bundle");

        if (registered == true) {
            loggedIn = true;
            ((HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false))
                    .setAttribute("username", username);
            try {
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("admin.xhtml");
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        bundle.getString("Main.Login.Welcome"), username);
                logger.info("login() - Redirecting to admin site.");
            } catch (IOException e) {
                logger.log(Level.SEVERE, "login() - Redirection failed.", e);
            }
        } else {
            loggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    bundle.getString("Main.Login.Error"),
                    bundle.getString("Main.Login.Invalid"));
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
    }
}
