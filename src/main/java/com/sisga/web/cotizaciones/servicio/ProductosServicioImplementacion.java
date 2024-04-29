package com.sisga.web.cotizaciones.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisga.web.cotizaciones.controlador.dto.ProductosRegistroDTO;
import com.sisga.web.cotizaciones.modelo.Producto;
import com.sisga.web.cotizaciones.repositorio.ProductosRepositorio;

@Service
public class ProductosServicioImplementacion implements ProductosServicio {

	@Autowired
	private ProductosRepositorio productosRepositorio;

	@Autowired
	public ProductosServicioImplementacion(ProductosRepositorio productosRepositorio) {
		this.productosRepositorio = productosRepositorio;
	}

	@Override
	public List<Producto> listarProductos() {
		return productosRepositorio.findAll();
	}

	@Override
	public Producto guardar(ProductosRegistroDTO productosRegistroDTO) {
		Producto producto = new Producto(productosRegistroDTO.getNombreItem(),
				productosRegistroDTO.getValorUnitario(), productosRegistroDTO.getImpoconsumo(),
				productosRegistroDTO.getValorBase(), productosRegistroDTO.getDescripcion());

		return productosRepositorio.save(producto);
	}

	@Override
	public boolean existeProducto(String nombreItem) {
//		Producto producto = productosRepositorio.findBynombreItem(nombreItem);
		return nombreItem != null;
	}

	@Override
	public Producto obtenerProductoPorId(Long id) {
		return productosRepositorio.findById(id).orElse(null);
	}

	@Override
	public void guardarProducto(ProductosRegistroDTO productosRegistroDTO) {
		productosRepositorio.save(productosRegistroDTO);
	}

	@Override
	public Producto obtenerProducto(String nombreItem) {
		Producto producto = productosRepositorio.findBynombreItem(nombreItem);
		return producto;
	}

	@Override
	public void deleteById(Long Id) {
		productosRepositorio.deleteById(Id);

	}

	@Override
	public long cantidadDeRegistros() {
		long cantidadRegistros = productosRepositorio.count();
		return cantidadRegistros;
	}

	@Override
	public Producto editarProducto(Long id, String nombreItem, String valorUnitario, String impoconsumo,
			String valorBase, String descripcion) {
		Optional<Producto> optionalProducto = productosRepositorio.findById(id);
		if (optionalProducto.isPresent()) {
			Producto producto = optionalProducto.get();
			producto.setNombreItem(nombreItem);
			producto.setValorUnitario(valorUnitario);
			producto.setImpoconsumo(impoconsumo);
			producto.setValorBase(valorBase);
			producto.setDescripcion(descripcion);
			return productosRepositorio.save(producto);
		}
		return null;
	}

	@Override
	public Optional<Producto> obtenerPrecioPorId(Long Id) {
		return productosRepositorio.findById(Id);
	}

}
