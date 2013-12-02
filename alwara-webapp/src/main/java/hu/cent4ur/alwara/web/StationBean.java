// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.web;

import hu.cent4ur.alwara.model.Station;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Managing stations.
 * 
 * @author Sandor Balazs
 */
@Named
@SessionScoped
public class StationBean implements Serializable {

    private static final long serialVersionUID = -2009535155796549852L;
    private static final Logger logger = Logger.getLogger(StationBean.class.getName());
    private final EntityManager entityManager;
    private String stationName;
    private Boolean busStation = true;
    private Boolean trainStation = true;

    StationBean() {
        logger.info("StationBean() - Initialization.");
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AlwaraPersistenceUnit");
        entityManager = emf.createEntityManager();
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String name) {
        stationName = name;
    }

    public Boolean getBusStation() {
        return busStation;
    }

    public void setBusStation(Boolean busStation) {
        this.busStation = busStation;
    }

    public Boolean getTrainStation() {
        return trainStation;
    }

    public void setTrainStation(Boolean trainStation) {
        this.trainStation = trainStation;
    }

    public void saveStation(ActionEvent evt) {
        logger.info("saveStation() - Save station information.");
        entityManager.getTransaction().begin();
        Station station = new Station(stationName, busStation, trainStation);
        entityManager.persist(station);
        entityManager.getTransaction().commit();
    }

    public List<Station> getStations() {
        logger.info("getStations() - Query all stations.");
        TypedQuery<Station> query = entityManager.createNamedQuery(
                "Station.findAll", Station.class);
        return query.getResultList();
    }
}
