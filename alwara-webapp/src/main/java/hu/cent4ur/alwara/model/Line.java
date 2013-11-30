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
 * A line contains links that connect stations in a pre-defined order.
 * 
 * @author Sandor Balazs
 */
@Entity
@NamedQueries({
        @NamedQuery(
            name = "Line.findAll",
            query = "SELECT l FROM Line l") })
public class Line extends EntityBase {

    @NotNull
    @Column(unique = true)
    private String name;

    public Line() {
    }

    public Line(String name) {
        this.name = name;
    }
}
