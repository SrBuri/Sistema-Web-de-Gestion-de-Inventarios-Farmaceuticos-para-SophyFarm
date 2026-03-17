package com.sophyfarm.inventario.presentacion;

import java.util.ArrayList;
import java.util.Scanner;

import com.sophyfarm.inventario.logica.ProductoServicio;
import com.sophyfarm.inventario.modelo.Producto;

public class ProductoVista {
	private Scanner scanner;
	private ProductoServicio productoServicio;

	public ProductoVista() {
		scanner = new Scanner(System.in);
		productoServicio = new ProductoServicio();
	}

	public void mostrarMenu() {
		int opcion;

		do {
			System.out.println("\n=== MENU PRODUCTOS ===");
			System.out.println("1. Registrar producto");
			System.out.println("2. Buscar producto");
			System.out.println("3. Editar producto");
			System.out.println("4. Listar productos");
			System.out.println("5. Eliminar producto");
			System.out.println("6. Salir");
			System.out.print("Seleccione una opcion: ");

			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				registrarProducto();
				break;
			case 2:
				buscarProducto();
				break;
			case 3:
				editarProducto();
				break;
			case 4:
				listarProductos();
				break;
			case 5:
				eliminarProducto();
				break;
			case 6:
				System.out.println("Saliendo");
				break;
			default:
				System.out.println("Ingrese a una opcion valida");
			}
		} while (opcion != 6);
	}

	public void registrarProducto() {
		System.out.print("Ingrese el codigo del producto: ");
		String codigo = scanner.nextLine();

		System.out.print("Ingrese el nombre del producto: ");
		String nombre = scanner.nextLine();

		System.out.println(productoServicio.registrarProducto(codigo, nombre));
	}

	public void buscarProducto() {
		System.out.println("Ingrese el codigo del producto: ");
		String codigo = scanner.nextLine();

		Producto producto = productoServicio.buscarProducto(codigo);

		if (producto == null) {
			System.out.println("Producto no encontrado");
		} else {
			System.out.println("Producto encontrado");
			System.out.println("Codigo" + "		" + "Nombre");
			System.out.println(producto.getCodigo() + "		" + producto.getNombre());
		}
	}

	public void editarProducto() {
		System.out.print("Ingrese el codigo del producto: ");
		String codigo = scanner.nextLine();

		System.out.print("Ingrese el nombre nuevo del producto: ");
		String nombreNuevo = scanner.nextLine();

		System.out.println(productoServicio.editarProducto(codigo, nombreNuevo));
	}

	public void listarProductos() {
		var productos = new ArrayList<Producto>();

		productos = productoServicio.listaProductos();

		if (productos.isEmpty()) {
			System.out.println("No hay productos registrados");
		} else {
			System.out.println("=== LISTA DE PRODUCTOS ====");
			System.out.println("Codigo" + "		" + "Nombre");
			for (Producto producto : productos) {
				System.out.println(producto.getCodigo() + "		" + producto.getNombre());
			}
		}
	}

	public void eliminarProducto() {
		System.out.print("Ingrese el codigo del producto: ");
		String codigo = scanner.nextLine();

		System.out.println((productoServicio.eliminarProducto(codigo)));
	}

}
