package com.sisga.web.servicio;

import java.util.List;

import com.sisga.web.controlador.dto.ProductosRegistroDTO;
import com.sisga.web.modelo.Producto;

public interface ProductosServicio {

	public Producto guardar(
			ProductosRegistroDTO productosRegistroDTO
			);
	
	public List<Producto> listarProductos();
	
	public boolean existeProducto(
			String nombreProducto
			);

	public Producto obtenerProductoPorId(
			Long Id
			);

	public void guardarProducto(
			ProductosRegistroDTO productoData
			);
	
	public void eliminarProducto(
			Long Id
			);
	
	public long cantidadDeRegistros();

	Producto editarProducto(
			Long id, 
			String nombreProducto, 
			String precioProducto, 
			String descripcionProducto,
			String baseProducto, 
			String incProducto
			);
}

