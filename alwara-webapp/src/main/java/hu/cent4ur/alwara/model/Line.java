// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * Connects stations in a pre-defined order.
 * 
 * @author Sandor Balazs
 */
@Entity
@NamedQueries({
        @NamedQuery(
            name = "Line.findAll",
            query = "SELECT l FROM Line l") })
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "ROUTE_FK",
        "ORDINAL" }))
public class Line extends EntityBase implements Serializable {

    private static final long serialVersionUID = 3041916241054853666L;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ROUTE_FK")
    private Route route;

    // The n-th place in the line of stations.
    @NotNull
    private Integer ordinal;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "START_STATION_FK")
    private Station startStation;

    @ManyToOne
    @JoinColumn(name = "STOP_STATION_FK")
    private Station stopStation;

    // Bus or train line.
    private Boolean bus;
    private Boolean train;

    // The cost of traveling the line.
    private Integer cost;

    // The length of the line.
    private Integer length;

    // The time (in minutes) taken to travel the line.
    private Integer time;

    public Line() {
    }

    public Line(Route route, Integer ordinal, Station startStation,
            Station stopStation, Boolean bus, Boolean train, Integer cost,
            Integer length, Integer time) {
        this.route = route;
        this.ordinal = ordinal;
        this.startStation = startStation;
        this.stopStation = stopStation;
        this.bus = bus;
        this.train = train;
        this.cost = cost;
        this.length = length;
        this.time = time;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public Station getStartStation() {
        return startStation;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }

    public Station getStopStation() {
        return stopStation;
    }

    public void setStopStation(Station stopStation) {
        this.stopStation = stopStation;
    }

    public Boolean getBus() {
        return bus;
    }

    public void setBus(Boolean bus) {
        this.bus = bus;
    }

    public Boolean getTrain() {
        return train;
    }

    public void setTrain(Boolean train) {
        this.train = train;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
