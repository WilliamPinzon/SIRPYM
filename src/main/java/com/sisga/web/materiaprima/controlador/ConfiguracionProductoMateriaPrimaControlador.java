package com.sisga.web.materiaprima.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisga.web.materiaprima.modelo.Productos;
import com.sisga.web.materiaprima.repositorio.ProductosMateriaPrimaRepositorio;
import com.sisga.web.materiaprima.servicio.ProductosMateriaPrimaServicio;

@Controller
public class ConfiguracionProductoMateriaPrimaControlador {

	@Autowired
	private ProductosMateriaPrimaRepositorio productosMateriaPrimaRepositorio;

	@Autowired
	private ProductosMateriaPrimaServicio productosMateriaPrimaServicio;

	@PostMapping("/eliminarProductoMateriaPrima")
	public String eliminarProductoPorId(@RequestParam Long id) {
		productosMateriaPrimaServicio.deleteById(id);
		return "redirect:/ConfiguracionDeProductosMateriaPrima?delete";
	}

	@PostMapping("/editarProductoMateriaPrima")
	public String editarProducto(@RequestParam("id") String idStr,
			@RequestParam("nombreItem") String NombreItem, @RequestParam("unidad") String unidad) {
		try {
			Long id = Long.parseLong(idStr); // Convertir el ID a Long
			Productos productos = productosMateriaPrimaRepositorio.findById(id).orElse(null);

			if (productos != null) {
				productos.setNombreItem(NombreItem);
				productos.setUnidad(unidad);
				productosMateriaPrimaRepositorio.save(productos);
				return "redirect:/ConfiguracionDeProductosMateriaPrima?save";
			} else {
				return "Artículo no encontrado";
			}
		} catch (NumberFormatException e) {
			return "Error en formato de número";
		} catch (Exception e) {
			return "Error al actualizar el Producto";
		}
	}
}
