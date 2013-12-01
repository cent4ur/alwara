// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.web;

import hu.cent4ur.alwara.model.Timetable;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Managing timetables.
 * 
 * @author Sandor Balazs
 */
@Named
@SessionScoped
public class TimetableBean implements Serializable {

    private static final long serialVersionUID = -6383854588346288332L;
    private static final Logger logger = Logger.getLogger(StationBean.class
            .getName());
    private final EntityManager entityManager;

    public TimetableBean() {
        logger.info("TimetableBean() - Initialization.");
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AlwaraPersistenceUnit");
        entityManager = emf.createEntityManager();
    }

    public List<Timetable> getTimetables() {
        logger.info("getTimetables() - Query all timetables.");
        TypedQuery<Timetable> query = entityManager.createNamedQuery(
                "Timetable.findAll", Timetable.class);
        return query.getResultList();
    }
}
