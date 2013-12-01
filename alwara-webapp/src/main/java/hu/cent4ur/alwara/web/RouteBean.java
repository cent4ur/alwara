// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.web;

import hu.cent4ur.alwara.model.Route;

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
 * Managing routes.
 * 
 * @author Sandor Balazs
 */
@Named
@SessionScoped
public class RouteBean implements Serializable {

    private static final long serialVersionUID = -422117264281622377L;
    private static final Logger logger = Logger.getLogger(RouteBean.class
            .getName());
    private final EntityManager entityManager;
    private String routeName;
    private Route selectedRoute;
    private RouteDataModel routeDataModel;

    public RouteBean() {
        logger.info("RouteBean() - Initialization.");
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AlwaraPersistenceUnit");
        entityManager = emf.createEntityManager();
        updateRouteDataModel();
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Route getSelectedRoute() {
        return selectedRoute;
    }

    public void setSelectedRoute(Route selectedRoute) {
        this.selectedRoute = selectedRoute;
    }

    public RouteDataModel getRouteDataModel() {
        return routeDataModel;
    }

    public void updateRouteDataModel() {
        logger.info("updateRouteDataModel() - Updating routes.");
        routeDataModel = new RouteDataModel(getRoutes());
    }

    public List<Route> getRoutes() {
        logger.info("getRoutes() - Query all routes.");
        TypedQuery<Route> query = entityManager.createNamedQuery(
                "Route.findAll",
                Route.class);
        return query.getResultList();
    }

    public void saveRoute(ActionEvent event) {
        logger.info("saveRoute() - Save route information.");
        entityManager.getTransaction().begin();
        Route route = new Route(routeName);
        entityManager.persist(route);
        entityManager.getTransaction().commit();
        updateRouteDataModel();
    }

    public void onRowSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(
                context, "bundle");
        FacesMessage msg = new FacesMessage(
                bundle.getString("Admin.RouteTab.RouteListPanel.Table.RouteSelected"),
                ((Route) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
