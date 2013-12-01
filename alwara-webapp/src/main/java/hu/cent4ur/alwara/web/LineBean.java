// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.web;

import hu.cent4ur.alwara.model.Line;
import hu.cent4ur.alwara.model.Route;

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
 * Managing lines.
 * 
 * @author Sandor Balazs
 */
@Named
@SessionScoped
public class LineBean implements Serializable {

    private static final long serialVersionUID = -422117264281622377L;
    private static final Logger logger = Logger.getLogger(LineBean.class
            .getName());
    private final EntityManager entityManager;
    private String lineName;
    private Route selectedLine;
    private LineDataModel lineDataModel;

    public LineBean() {
        logger.info("LineBean() - Initialization.");
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AlwaraPersistenceUnit");
        entityManager = emf.createEntityManager();
    }

    public List<Line> getLines() {
        logger.info("getLines() - Query all links.");
        TypedQuery<Line> query = entityManager.createNamedQuery("Line.findAll",
                Line.class);
        return query.getResultList();
    }
}
