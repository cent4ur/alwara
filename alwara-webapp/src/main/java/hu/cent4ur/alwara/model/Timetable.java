// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Represents that when and from which station starts a specific bus or train
 * route.
 * 
 * @author Sandor Balazs
 */
@Entity
public class Timetable extends EntityBase {

    @Column(name = "START_TIME")
    @Temporal(TemporalType.DATE)
    private Date startTime;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "STATION_FK")
    private Station station;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ROUTE_FK")
    private Route route;

    private Boolean weekend;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Boolean getWeekend() {
        return weekend;
    }

    public void setWeekend(Boolean weekend) {
        this.weekend = weekend;
    }
}
