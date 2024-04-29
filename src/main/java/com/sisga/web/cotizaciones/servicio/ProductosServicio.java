package com.sisga.web.cotizaciones.servicio;

import java.util.List;
import java.util.Optional;

import com.sisga.web.cotizaciones.controlador.dto.ProductosRegistroDTO;
import com.sisga.web.cotizaciones.modelo.Producto;

public interface ProductosServicio {

	public Producto guardar(ProductosRegistroDTO productosRegistroDTO);

	public List<Producto> listarProductos();

	public boolean existeProducto(String nombreItem);

	public Producto obtenerProductoPorId(Long Id);

	public Optional<Producto> obtenerPrecioPorId(Long Id);

	public void guardarProducto(ProductosRegistroDTO productosRegistroDTO);

	public long cantidadDeRegistros();

	Producto editarProducto(Long id, String nombreItem, String valorUnitario, String impoconsumo, String valorBase,
			String descripcion);

	public void deleteById(Long id);

	public Producto obtenerProducto(String nombreItem);
}
