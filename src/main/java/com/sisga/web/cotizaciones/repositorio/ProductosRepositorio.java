package com.sisga.web.cotizaciones.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisga.web.cotizaciones.controlador.dto.ProductosRegistroDTO;
import com.sisga.web.cotizaciones.modelo.Producto;

public interface ProductosRepositorio extends JpaRepository<Producto, Long> {

	public Producto findBynombreItem(String nombreItem);
	public Producto findById(long id);
	public Producto deleteById(long id);
	public Producto save(ProductosRegistroDTO productosRegistroDTO);

}
