// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.web;

import hu.cent4ur.alwara.model.Line;
import hu.cent4ur.alwara.model.Link;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.primefaces.event.SelectEvent;

/**
 * Managing lines.
 * 
 * @author Sandor Balazs
 */
@Named
@SessionScoped
public class LineBean implements Serializable {

    private static final long serialVersionUID = -422117264281622377L;
    private static final Logger logger = Logger.getLogger(LineBean.class.getName());
    private final EntityManager entityManager;
    private String lineName;
    private Line selectedLine;
    private LineDataModel lineDataModel;

    public LineBean() {
        logger.info("LineBean() - Initialization.");
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AlwaraPersistenceUnit");
        entityManager = emf.createEntityManager();
        updateLineDataModel();
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public Line getSelectedLine() {
        return selectedLine;
    }

    public void setSelectedLine(Line selectedLine) {
        this.selectedLine = selectedLine;
    }

    public LineDataModel getLineDataModel() {
        return lineDataModel;
    }

    public void updateLineDataModel() {
        logger.info("updateLineDataModel() - Updating lines.");
        lineDataModel = new LineDataModel(getLines());
    }

    public List<Line> getLines() {
        logger.info("getLines() - Query all lines.");
        TypedQuery<Line> query = entityManager.createNamedQuery("Line.findAll",
                Line.class);
        return query.getResultList();
    }

    public void saveLine(ActionEvent event) {
        logger.info("saveLine() - Save line information.");
        entityManager.getTransaction().begin();
        Line line = new Line(lineName);
        entityManager.persist(line);
        entityManager.getTransaction().commit();
        updateLineDataModel();
    }

    public List<Link> getLinks() {
        logger.info("getLinks() - Query all links.");
        TypedQuery<Link> query = entityManager.createNamedQuery("Link.findAll",
                Link.class);
        return query.getResultList();
    }

    public void onRowSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(
                context, "bundle");
        FacesMessage msg = new FacesMessage(
                bundle.getString("Admin.LineTab.LineListPanel.Table.LineSelected"),
                ((Line) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
