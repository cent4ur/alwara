// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 * Represents a station where either buses or trains (or both) can stop.
 * 
 * @author Sandor Balazs
 */
@Entity
@NamedQueries({
        @NamedQuery(
            name = "Station.findAll",
            query = "SELECT s FROM Station s"),
        @NamedQuery(
            name = "Station.findByName",
            query = "SELECT s FROM Station s WHERE s.name = :name") })
public class Station extends EntityBase {

    @NotNull
    @Column(unique = true)
    private String name;
    private Boolean bus = true;
    private Boolean train = true;

    public Station() {
    }

    public Station(String name) {
        this.name = name;
    }

    public Station(String name, Boolean bus, Boolean train) {
        this.name = name;
        this.bus = bus;
        this.train = train;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
