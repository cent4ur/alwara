// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Represents the type of vehicles that can stop at stations (bus stop, train
 * stop or both) and the that can travel along lines (bus line, train line or
 * both).
 * 
 * @author Sandor Balazs
 */
@Entity
@Table(name = "VEHICLE_TYPE")
public class VehicleType extends EntityBase {

    @Column(unique = true)
    private String name;

    public VehicleType() {
    }

    public VehicleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
