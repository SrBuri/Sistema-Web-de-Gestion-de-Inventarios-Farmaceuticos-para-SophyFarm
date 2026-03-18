package com.sophyfarm.inventario.presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sophyfarm.inventario.logica.ProductoServicio;
import com.sophyfarm.inventario.modelo.Producto;

public class ProductoGUI extends JFrame {

	private ProductoServicio servicio = new ProductoServicio();

	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JButton btnRegistrar;
	private JButton btnListar;
	private JButton btnBuscar;
	private JTable tablaProductos;
	private DefaultTableModel modeloTabla;

	public ProductoGUI() {
		setTitle("Gestión de Productos - SophyFarm");
		setSize(700, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		inicializarComponentes();
		construirLayout();
		registrarEventos();
	}

	private void inicializarComponentes() {
		txtCodigo = new JTextField(10);
		txtNombre = new JTextField(20);

		btnRegistrar = new JButton("Registrar");
		btnListar = new JButton("Listar");
		btnBuscar = new JButton("Buscar");

		modeloTabla = new DefaultTableModel(new Object[] { "Código", "Nombre", "Editar", "Eliminar" }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 2 || column == 3;
			}
		};

		tablaProductos = new JTable(modeloTabla);
		tablaProductos.getColumn("Editar").setCellRenderer(new BotonRenderer("Editar"));
		tablaProductos.getColumn("Eliminar").setCellRenderer(new BotonRenderer("Eliminar"));
		tablaProductos.getColumn("Editar").setCellEditor(new BotonEditor(this, "Editar"));
		tablaProductos.getColumn("Eliminar").setCellEditor(new BotonEditor(this, "Eliminar"));

	}

	private void construirLayout() {
		JPanel panelFormulario = new JPanel(new FlowLayout());

		panelFormulario.add(new JLabel("Código:"));
		panelFormulario.add(txtCodigo);
		panelFormulario.add(new JLabel("Nombre:"));
		panelFormulario.add(txtNombre);
		panelFormulario.add(btnRegistrar);
		panelFormulario.add(btnListar);
		panelFormulario.add(btnBuscar);
		add(panelFormulario, BorderLayout.NORTH);
		add(new JScrollPane(tablaProductos), BorderLayout.CENTER);
	}

	private void registrarEventos() {
		btnRegistrar.addActionListener(e -> registrarProducto());
		btnListar.addActionListener(e -> listarProductos());
		btnBuscar.addActionListener(e -> buscarProducto());
	}

	private void registrarProducto() {
		String codigo = txtCodigo.getText().trim();
		String nombre = txtNombre.getText().trim();

		String resultado = servicio.registrarProducto(codigo, nombre);
		JOptionPane.showMessageDialog(this, resultado);

		listarProductos();
		limpiarCampos();
	}

	private void limpiarCampos() {
		txtCodigo.setText("");
		txtNombre.setText("");
	}

	private void listarProductos() {
		limpiarTabla();

		List<Producto> productos = servicio.listarProductos();

		if (productos.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No hay productos registrados");
			return;
		}

		for (Producto producto : productos) {
			modeloTabla.addRow(new Object[] { producto.getCodigo(), producto.getNombre(), "✏️", "❌" });
		}
	}

	private void limpiarTabla() {
		modeloTabla.setRowCount(0);
	}

	public void editarProducto(String codigo) {
		String nombreNuevo = JOptionPane.showInputDialog("Escribe el nuevo nombre del producto");
		JOptionPane.showMessageDialog(this, servicio.editarProducto(codigo, nombreNuevo));
		listarProductos();
	}

	public void eliminarProducto(String codigo) {
		JOptionPane.showMessageDialog(this, servicio.eliminarProducto(codigo));
		listarProductos();
	}

	public void buscarProducto() {
		String codigo = txtCodigo.getText().trim();
		Producto producto = servicio.buscarProducto(codigo);
		if (producto == null) {
			JOptionPane.showMessageDialog(this, "Producto no encontrado");
		} else {
			JOptionPane.showMessageDialog(this,
					"Codigo: " + producto.getCodigo() + "    " + " nombre: " + producto.getNombre());
		}

	}
}
