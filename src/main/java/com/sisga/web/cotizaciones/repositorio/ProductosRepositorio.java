package com.sisga.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisga.web.controlador.dto.ProductosRegistroDTO;
import com.sisga.web.modelo.Producto;

public interface ProductosRepositorio extends JpaRepository<Producto, Long> {

	public Producto findBynombreProducto(String nombreProducto);
	public Producto findById(long id);
	public Producto deleteById(long id);
	public Producto save(ProductosRegistroDTO productoData);

}
