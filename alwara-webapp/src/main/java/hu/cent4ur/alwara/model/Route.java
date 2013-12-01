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
 * Represents a bus / train route that travels along a line.
 * 
 * @author Sandor Balazs
 */
@Entity
@NamedQueries({
        @NamedQuery(
            name = "Route.findAll",
            query = "SELECT r FROM Route r") })
public class Route extends EntityBase {

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    @Column(columnDefinition = "NUMBER(10) DEFAULT 0 NOT NULL")
    private Integer late = 0;

    // Bus or train route.
    private Boolean bus;
    private Boolean train;

    public Route() {
    }

    public Route(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLate() {
        return late;
    }

    public void setLate(Integer late) {
        this.late = late;
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

    @Override
    public String toString() {
        return name;
    }
}
