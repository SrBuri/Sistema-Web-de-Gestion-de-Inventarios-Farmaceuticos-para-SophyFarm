package com.sophyfarm.inventario.presentacion;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class BotonRenderer extends JButton implements TableCellRenderer {

    public BotonRenderer(String texto) {
        setText(texto);
    }

    @Override
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column) {

        setText(value == null ? "" : value.toString());
        return this;
    }
}