// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.web;

import hu.cent4ur.alwara.model.Timetable;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

/**
 * Implementation of {@link ListDataModel} that wraps a <code>List</code> of
 * <code>Timetable</code> objects.
 * 
 * @author Sandor Balazs
 */
public class TimetableDataModel extends ListDataModel<Timetable> implements
        SelectableDataModel<Timetable> {

    public TimetableDataModel() {
    }

    public TimetableDataModel(List<Timetable> timetables) {
        super(timetables);
    }

    @Override
    public Timetable getRowData(String rowKey) {
        List<Timetable> timetables = (List<Timetable>) getWrappedData();

        for (Timetable timetable : timetables) {
            if (timetable.getId() == Integer.parseInt(rowKey)) {
                return timetable;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(Timetable timetable) {
        return timetable.getId();
    }
}
