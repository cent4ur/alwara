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
            name = "Link.findAll",
            query = "SELECT l FROM Link l") })
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "LINE_FK",
        "ORDINAL" }))
public class Link extends EntityBase implements Serializable {

    private static final long serialVersionUID = 3041916241054853666L;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "LINE_FK")
    private Line line;

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

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
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
