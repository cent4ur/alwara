// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.web;

import hu.cent4ur.alwara.model.Line;
import hu.cent4ur.alwara.model.Station;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Dijkstra.Edge;
import Dijkstra.Vertex;

/**
 * Managing searches.
 * 
 * @author Sandor Balazs
 */
@Named
@SessionScoped
public class SearchBean implements Serializable {

    private static final long serialVersionUID = 7119305520329822712L;
    private static final Logger logger = Logger.getLogger(SearchBean.class.getName());
    private Date startDate;
    private Integer startStationId;
    private Integer endStationId;
    private OptimizationType optimizationType;
    private OptimizationType[] optimizationTypes = OptimizationType.values();
    private Boolean resultsDisplayed;
    private List<Line> results;
    private final EntityManager entityManager;

    public enum OptimizationType {
        TIME("OptimizationType.Time"),
        COST("OptimizationType.Cost"),
        LENGTH("OptimizationType.Length");

        // Key in resource bundle.
        private String key;

        OptimizationType(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

    public SearchBean() {
        logger.info("SearchBean() - Initialization.");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlwaraPersistenceUnit");
        entityManager = emf.createEntityManager();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getStartStationId() {
        return startStationId;
    }

    public void setStartStationId(Integer startStation) {
        this.startStationId = startStation;
    }

    public Integer getEndStationId() {
        return endStationId;
    }

    public void setEndStationId(Integer endStation) {
        this.endStationId = endStation;
    }

    public OptimizationType getOptimizationType() {
        return optimizationType;
    }

    public void setOptimizationType(OptimizationType optimizationType) {
        this.optimizationType = optimizationType;
    }

    public OptimizationType[] getOptimizationTypes() {
        return optimizationTypes;
    }

    public void setOptimizationTypes(OptimizationType[] optimizationTypes) {
        this.optimizationTypes = optimizationTypes;
    }

    public Boolean getResultsDisplayed() {
        return resultsDisplayed;
    }

    public void setResultsDisplayed(Boolean resultsDisplayed) {
        this.resultsDisplayed = resultsDisplayed;
    }

    public List<Line> getResults() {
        return results;
    }

    public void setResults(List<Line> results) {
        this.results = results;
    }

    public void search(ActionEvent event) {
        logger.info("search() - Searching lines.");

        logger.info("search() - Start station id: " + startStationId);
        logger.info("search() - End station id: " + endStationId);

        TypedQuery<Line> query1 = entityManager.createNamedQuery("Line.findAll",Line.class);
        List<Line> lines = query1.getResultList();
        
        TypedQuery<Station> query2 = entityManager.createNamedQuery("Station.findAll", Station.class);
        List<Station> stations = query2.getResultList();
        
        List<Vertex> vertices = new ArrayList<Vertex>();
        Vertex startVertex = null;
        Vertex endVertex = null;
        for (Station station : stations) {
        	Vertex addition = new Vertex(station.getName());
        	vertices.add(addition);
            if (station.getId().equals(startStationId)) {
        		startVertex = addition;
        	}
            if (station.getId().equals(endStationId)) {
        		endVertex = addition;
        	}
        }

        for (Line line : lines) {
        	Vertex from = null, to = null;
        	for (Vertex vertex : vertices) {
        		if (vertex.getName().equals(line.getStartStation().getName())) {
        			from = vertex;
        		} else if (vertex.getName().equals(line.getStopStation().getName())) {
        			to = vertex;
        		}
        	}
        	if ((from != null) && (to != null)) {
        		from.adjacencies.add(new Edge(to, line.getTime()));
        	}
        }

        Dijkstra.Dijkstra.computePaths(startVertex);

        List<Line> resultLines = new ArrayList<Line>();
        List<Vertex> resultVertices = Dijkstra.Dijkstra.getShortestPathTo(endVertex);
        
        for (int i = 0; i < resultVertices.size(); i++) {
        	if ((i+1)!=resultVertices.size()) {
        		for (Line line : lines) {
        			if (resultVertices.get(i).getName().equals(line.getStartStation().getName()) &&
        					resultVertices.get(i+1).getName().equals(line.getStopStation().getName())) {
        				logger.info(resultVertices.get(i).getName());
        				resultLines.add(line);
        			}
        		}
        	}
    	}

        setResults(resultLines);

        resultsDisplayed = true;
    }
}
