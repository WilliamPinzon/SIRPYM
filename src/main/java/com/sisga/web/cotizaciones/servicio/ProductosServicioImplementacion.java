package com.sisga.web.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisga.web.controlador.dto.ProductosRegistroDTO;
import com.sisga.web.modelo.Producto;
import com.sisga.web.repositorio.ProductosRepositorio;

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
		Producto producto = new Producto(
										productosRegistroDTO.getNombreProducto(),
										productosRegistroDTO.getPrecioProducto(),
										productosRegistroDTO.getIncProducto(),
										productosRegistroDTO.getBaseProducto(),
										productosRegistroDTO.getDescripcionProducto());
		
		return productosRepositorio.save(producto);
	}

	@Override
	public boolean existeProducto(String nombreProducto) {
		Producto producto = productosRepositorio.findBynombreProducto(nombreProducto);
        return nombreProducto != null;
	}

	@Override
	public Producto obtenerProductoPorId(Long id) {
        return productosRepositorio.findById(id).orElse(null);
    }

	@Override
    public void guardarProducto(ProductosRegistroDTO productoData) {
		productosRepositorio.save(productoData);
    }

	@Override
	public void eliminarProducto(Long Id) {
		productosRepositorio.deleteById(Id);
		
	}

	@Override
	public long cantidadDeRegistros() {
	  long cantidadRegistros = productosRepositorio.count();
	  return cantidadRegistros;
	}

	@Override
    public Producto editarProducto(Long id, String nombreProducto, String precioProducto, String descripcionProducto, String baseProducto, String incProducto) {
        Optional<Producto> optionalProducto = productosRepositorio.findById(id);
        if (optionalProducto.isPresent()) {
        	Producto producto = optionalProducto.get();
        	producto.setNombreProducto(nombreProducto);
        	producto.setPrecioProducto(precioProducto);
        	producto.setDescripcionProducto(descripcionProducto);
        	producto.setBaseProducto(baseProducto);
        	producto.setIncProducto(incProducto);
            return productosRepositorio.save(producto);
        }
        return null; // Manejar la lógica de error si el artículo no existe
    }


}

