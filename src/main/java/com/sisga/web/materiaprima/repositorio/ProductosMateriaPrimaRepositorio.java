package com.sisga.web.materiaprima.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisga.web.materiaprima.controlador.dto.ProductosMateriaPrimaRegistroDTO;
import com.sisga.web.materiaprima.modelo.Productos;

public interface ProductosMateriaPrimaRepositorio extends JpaRepository<Productos, Long> {

	public Productos findBynombreItem(String nombreItem);
	public Productos findById(long id);
	public Productos deleteById(long id);
	public Productos save(ProductosMateriaPrimaRegistroDTO productosMateriaPrimaRegistroDTO);

}
