package com.sisga.web.materiaprima.servicio;

import java.util.List;
import java.util.Optional;

import com.sisga.web.materiaprima.controlador.dto.ProductosMateriaPrimaRegistroDTO;
import com.sisga.web.materiaprima.modelo.Productos;

public interface ProductosMateriaPrimaServicio {

	public Productos guardar(ProductosMateriaPrimaRegistroDTO productosMateriaPrimaRegistroDTO);

	public List<Productos> listarProductos();

	public boolean existeProducto(String nombreItem);

	public Productos obtenerProductoPorId(Long Id);

	public Optional<Productos> obtenerPrecioPorId(Long Id);

	public void guardarProducto(ProductosMateriaPrimaRegistroDTO productosMateriaPrimaRegistroDTO);

	public long cantidadDeRegistros();

	Productos editarProducto(Long id, String nombreItem, String unidad);

	public void deleteById(Long id);

	public Productos obtenerProducto(String nombreItem);
}
