// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * A line contains links that connect stations in a pre-defined order.
 * 
 * @author Sandor Balazs
 */
@Entity
public class Line extends EntityBase {

    @NotNull
    private String name;
}
