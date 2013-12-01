// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 * Represents that when and from which station starts a specific bus or train
 * route.
 * 
 * @author Sandor Balazs
 */
@Entity
@NamedQueries({
        @NamedQuery(
            name = "Timetable.findAll",
            query = "SELECT t FROM Timetable t") })
public class Timetable extends EntityBase {

    @Column(name = "START_TIME")
    private Integer startTime;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "STATION_FK")
    private Station station;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ROUTE_FK")
    private Route route;

    private Boolean weekend = false;
    private Boolean holiday = false;

    /**
     * Returns start time stored as minutes. It should be converted to hh:mm
     * format when displaying.
     * 
     * @return start time in minutes
     */
    public Integer getStartTime() {
        return startTime;
    }

    /**
     * Returns start time in hh:mm format.
     * 
     * @return start time in hh:mm format.
     */
    public String getFormattedStartTime() {
        Integer hours = startTime / 60;
        Integer minutes = startTime % 60;
        return String.format("%02d:%02d", hours, minutes);
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Boolean getWeekend() {
        return weekend;
    }

    public void setWeekend(Boolean weekend) {
        this.weekend = weekend;
    }

    public Boolean getHoliday() {
        return holiday;
    }

    public void setHoliday(Boolean holiday) {
        this.holiday = holiday;
    }
}
