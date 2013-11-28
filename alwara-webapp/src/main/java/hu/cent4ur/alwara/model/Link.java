// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * Connects stations in a pre-defined order.
 * 
 * @author Sandor Balazs
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "LINE_FK",
        "ORDINAL" }))
public class Link extends EntityBase implements Serializable {

    private static final long serialVersionUID = 1L;

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
    @NotNull
    @ManyToOne
    @JoinColumn(name = "VEHICLE_TYPE_FK")
    private VehicleType vehicleType;

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

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
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
