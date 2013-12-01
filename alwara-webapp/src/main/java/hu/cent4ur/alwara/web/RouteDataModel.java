// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.web;

import hu.cent4ur.alwara.model.Route;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

/**
 * Implementation of {@link ListDataModel} that wraps a <code>List</code> of
 * <code>Route</code> objects.
 * 
 * @author Sandor Balazs
 */
public class RouteDataModel extends ListDataModel<Route> implements
        SelectableDataModel<Route> {

    public RouteDataModel() {
    }

    public RouteDataModel(List<Route> routes) {
        super(routes);
    }

    @Override
    public Route getRowData(String rowKey) {
        List<Route> routes = (List<Route>) getWrappedData();

        for (Route route : routes) {
            if (route.getName().equals(rowKey)) {
                return route;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(Route route) {
        return route.getName();
    }
}
