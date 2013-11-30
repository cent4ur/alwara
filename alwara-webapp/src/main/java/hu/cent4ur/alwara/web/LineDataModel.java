// Copyright (c) 2013, the Alwara project authors. Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.
package hu.cent4ur.alwara.web;

import hu.cent4ur.alwara.model.Line;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

/**
 * Implementation of {@link ListDataModel} that wraps a <code>List</code> of
 * <code>Line</code> objects.
 * 
 * @author Sandor Balazs
 */
public class LineDataModel extends ListDataModel<Line> implements
        SelectableDataModel<Line> {

    public LineDataModel() {
    }

    public LineDataModel(List<Line> lines) {
        super(lines);
    }

    @Override
    public Line getRowData(String rowKey) {
        List<Line> lines = (List<Line>) getWrappedData();

        for (Line line : lines) {
            if (line.getName().equals(rowKey)) {
                return line;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(Line line) {
        return line.getName();
    }
}
