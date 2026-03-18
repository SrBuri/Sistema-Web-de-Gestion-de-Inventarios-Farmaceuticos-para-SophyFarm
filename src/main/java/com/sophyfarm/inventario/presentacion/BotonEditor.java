package com.sophyfarm.inventario.presentacion;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class BotonEditor extends AbstractCellEditor implements TableCellEditor {

	private JButton button;
	private String codigo;
	private ProductoGUI gui;

	public BotonEditor(ProductoGUI gui, String texto) {
		this.gui = gui;
		button = new JButton(texto);

		button.addActionListener(e -> {
			fireEditingStopped();

			if (texto.equals("Editar")) {
				gui.editarProducto(codigo);
			} else {
				gui.eliminarProducto(codigo);
			}
		});
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

		codigo = table.getValueAt(row, 0).toString();
		button.setText(value.toString());
		return button;
	}

	@Override
	public Object getCellEditorValue() {
		return button.getText();
	}
}