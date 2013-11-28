// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 * Common attributes for persistent objects in the domain. All new JPA entities
 * should extend this class.
 * 
 * @author Sandor Balazs
 */
@MappedSuperclass
public abstract class EntityBase {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALWARA_SEQUENCE")
    @SequenceGenerator(name = "ALWARA_SEQUENCE", allocationSize = 1)
    private Integer id;

    @Version
    @NotNull
    @Column(columnDefinition = "NUMBER(10) DEFAULT 1 NOT NULL")
    private Integer version = 1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
