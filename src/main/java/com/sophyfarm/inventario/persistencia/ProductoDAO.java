package com.sophyfarm.inventario.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sophyfarm.inventario.modelo.Producto;

public class ProductoDAO {
	public boolean guardarProducto(Producto producto) {
		String sql = "INSERT INTO producto (codigo, nombre) VALUES (?,?)";

		try (Connection con = ConexionBD.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, producto.getCodigo());
			ps.setString(2, producto.getNombre());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			return false;
		}
	}

	public Producto buscarProducto(String codigo) {
		String sql = "SELECT * FROM producto WHERE codigo = ?";

		try (Connection con = ConexionBD.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, codigo);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String codigoConsulta = rs.getString("codigo");
				String nombreConsulta = rs.getString("nombre");

				Producto producto = new Producto(codigoConsulta, nombreConsulta);
				return producto;
			}

		} catch (SQLException e) {
		}

		return null;
	}

	public boolean editarProducto(String codigo, String nombreNuevo) {
		String sql = "UPDATE producto SET nombre = ? WHERE codigo = ?";

		try (Connection con = ConexionBD.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, nombreNuevo);
			ps.setString(2, codigo);

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}

	public ArrayList<Producto> listarProductos() {
		var lista = new ArrayList<Producto>();
		String sql = "Select * FROM producto WHERE activo = true";

		try (Connection con = ConexionBD.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String codigo = rs.getString("codigo");
				String nombre = rs.getString("nombre");
				var producto = new Producto(codigo, nombre);
				lista.add(producto);
			}

		} catch (Exception e) {
		}
		return lista;
	}

	public boolean existeProducto(String codigo) {
		String sql = "SELECT * FROM producto where codigo = ?";

		try (Connection con = ConexionBD.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, codigo);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (Exception e) {
			return false;
		}

	}

	public boolean eliminarProducto(String codigo) {
		String sql = "UPDATE producto set activo = false where codigo = ?";

		try (Connection con = ConexionBD.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, codigo);
			return (ps.executeUpdate() > 0);
		} catch (Exception e) {
			return false;
		}
	}
}
