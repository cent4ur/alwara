// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.web;

import hu.cent4ur.alwara.model.Line;
import hu.cent4ur.alwara.model.Station;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/**
 * Managing searches.
 * 
 * @author Sandor Balazs
 */
@Named
@SessionScoped
public class SearchBean implements Serializable {

    private static final long serialVersionUID = 7119305520329822712L;
    private static final Logger logger = Logger.getLogger(SearchBean.class
            .getName());
    private Date startDate;
    private Station startStation;
    private Station endStation;
    private OptimizationType optimizationType;
    private OptimizationType[] optimizationTypes = OptimizationType.values();
    private Boolean resultsDisplayed = true;
    private List<Line> results;

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
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Station getStartStation() {
        return startStation;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public void setEndStation(Station endStation) {
        this.endStation = endStation;
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
        resultsDisplayed = true;
    }
}