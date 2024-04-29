package com.sisga.web.materiaprima.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisga.web.materiaprima.controlador.dto.ProductosMateriaPrimaRegistroDTO;
import com.sisga.web.materiaprima.modelo.Productos;
import com.sisga.web.materiaprima.repositorio.ProductosMateriaPrimaRepositorio;

@Service
public class ProductosMateriaPrimaServicioImplementacion implements ProductosMateriaPrimaServicio {

	@Autowired
	private ProductosMateriaPrimaRepositorio productosMateriaPrimaRepositorio;

	@Autowired
	public ProductosMateriaPrimaServicioImplementacion(ProductosMateriaPrimaRepositorio productosMateriaPrimaRepositorio) {
		this.productosMateriaPrimaRepositorio = productosMateriaPrimaRepositorio;
	}

	@Override
	public List<Productos> listarProductos() {
		return productosMateriaPrimaRepositorio.findAll();
	}

	@Override
	public Productos guardar(ProductosMateriaPrimaRegistroDTO productosMateriaPrimaRegistroDTO) {
		Productos productos = new Productos(productosMateriaPrimaRegistroDTO.getNombreItem(),
				productosMateriaPrimaRegistroDTO.getUnidad());

		return productosMateriaPrimaRepositorio.save(productos);
	}

	@Override
	public boolean existeProducto(String nombreItem) {
//		Producto producto = productosRepositorio.findBynombreItem(nombreItem);
		return nombreItem != null;
	}

	@Override
	public Productos obtenerProductoPorId(Long id) {
		return productosMateriaPrimaRepositorio.findById(id).orElse(null);
	}

	@Override
	public void guardarProducto(ProductosMateriaPrimaRegistroDTO productosMateriaPrimaRegistroDTO) {
		productosMateriaPrimaRepositorio.save(productosMateriaPrimaRegistroDTO);
	}

	@Override
	public Productos obtenerProducto(String nombreItem) {
		Productos productos = productosMateriaPrimaRepositorio.findBynombreItem(nombreItem);
		return productos;
	}

	@Override
	public void deleteById(Long Id) {
		productosMateriaPrimaRepositorio.deleteById(Id);

	}

	@Override
	public long cantidadDeRegistros() {
		long cantidadRegistros = productosMateriaPrimaRepositorio.count();
		return cantidadRegistros;
	}

	@Override
	public Productos editarProducto(Long id, String nombreItem, String unidad) {
		Optional<Productos> optionalProductos = productosMateriaPrimaRepositorio.findById(id);
		if (optionalProductos.isPresent()) {
			Productos productos = optionalProductos.get();
			productos.setNombreItem(nombreItem);
			return productosMateriaPrimaRepositorio.save(productos);
		}
		return null;
	}

	@Override
	public Optional<Productos> obtenerPrecioPorId(Long Id) {
		return productosMateriaPrimaRepositorio.findById(Id);
	}

}
