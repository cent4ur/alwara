// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

/**
 * Represents a bus / train route that travels along a line.
 * 
 * @author Sandor Balazs
 */
@Entity
public class Route extends EntityBase {

    @NotNull
    private String name;

    @NotNull
    @JoinColumn(name = "LINE_FK")
    private Line line;

    @JoinColumn(name = "VEHICLE_TYPE_FK")
    private VehicleType vehicleType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
