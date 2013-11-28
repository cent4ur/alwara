// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Represents a station where either buses or trains (or both) can stop.
 * 
 * @author Sandor Balazs
 */
@Entity
public class Station extends EntityBase {

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "VEHICLE_TYPE_FK")
    private VehicleType vehicleType;

    public Station() {
    }

    public Station(String name, VehicleType vehicleType) {
        this.name = name;
        this.vehicleType = vehicleType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
