package com.sophyfarm.inventario.logica;

import java.util.ArrayList;

import com.sophyfarm.inventario.modelo.Producto;
import com.sophyfarm.inventario.persistencia.ProductoDAO;

public class ProductoServicio {
	private ProductoDAO productoDAO;

	public ProductoServicio() {
		productoDAO = new ProductoDAO();
	}

	public String registrarProducto(String codigo, String nombre) {
		if (codigo == null || codigo.trim().isEmpty()) {
			return "Error: el codigo es obligatorio";
		} else if (nombre == null || nombre.trim().isEmpty()) {
			return "Error: el nombre es obligatorio";
		} else if (productoDAO.existeProducto(codigo)) {
			return "Error: el código del producto ya existe";
		}
		Producto producto = new Producto(codigo, nombre);
		if (productoDAO.guardarProducto(producto)) {
			return "El producto se guardó correctamente";
		}
		return "Error al guardar el producto";

	}

	public Producto buscarProducto(String codigo) {
		if (codigo == null || codigo.trim().isEmpty()) {
			return null;
		}
		return productoDAO.buscarProducto(codigo);
	}

	public String editarProducto(String codigo, String nombreNuevo) {
		if (codigo == null || codigo.trim().isEmpty()) {
			return "Error: el codigo es obligatorio";
		} else if (nombreNuevo == null || nombreNuevo.trim().isEmpty()) {
			return "Error: el nombre es obligatorio";
		} else if (!productoDAO.existeProducto(codigo)) {
			return "El producto no existe";
		}
		if (productoDAO.editarProducto(codigo, nombreNuevo)) {
			return "Producto editado correctamente";
		}
		return "No se pudo editar el producto";
	}

	public ArrayList<Producto> listarProductos() {
		var lista = new ArrayList<Producto>();
		lista = productoDAO.listarProductos();
		return lista;
	}

	public String eliminarProducto(String codigo) {
		if (codigo == null || codigo.trim().isEmpty()) {
			return "Error: el codigo es obligatorio";
		} else if (!productoDAO.existeProducto(codigo)) {
			return "Error: el producto no existe";
		}
		if (productoDAO.eliminarProducto(codigo)) {
			return "Producto eliminado correctamente";
		}
		return "No se pudo eliminar el producto";

	}

}
