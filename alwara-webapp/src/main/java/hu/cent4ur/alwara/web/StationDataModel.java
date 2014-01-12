// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.web;

import hu.cent4ur.alwara.model.Station;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

/**
 * Implementation of {@link ListDataModel} that wraps a <code>List</code> of
 * <code>Station</code> objects.
 * 
 * @author Sandor Balazs
 */
public class StationDataModel extends ListDataModel<Station> implements
        SelectableDataModel<Station> {

    public StationDataModel() {
    }

    public StationDataModel(List<Station> stations) {
        super(stations);
    }

    @Override
    public Station getRowData(String rowKey) {
        List<Station> stations = (List<Station>) getWrappedData();

        for (Station station : stations) {
            if (station.getName().equals(rowKey)) {
                return station;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(Station station) {
        return station.getName();
    }
}
