package com.sisga.web.cotizaciones.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisga.web.cotizaciones.modelo.Producto;
import com.sisga.web.cotizaciones.repositorio.ProductosRepositorio;
import com.sisga.web.cotizaciones.servicio.ProductosServicio;

@Controller
public class ConfiguracionProductoControlador {

	@Autowired
	private ProductosRepositorio productosRepositorio;

	@Autowired
	private ProductosServicio productosServicio;

	@PostMapping("/eliminarProducto")
	public String eliminarProductoPorId(@RequestParam Long id) {
		productosServicio.deleteById(id);
		return "redirect:/ConfiguracionDeProductos?delete";
	}

	@PostMapping("/editarProducto")
	public String editarProducto(@RequestParam("id") String idStr,
			@RequestParam("nombreItem") String NombreItem, @RequestParam("valorUnitario") String valorUnitario,
			@RequestParam("impoconsumo") String impoconsumo, @RequestParam("valorBase") String valorBase,
			@RequestParam("descripcion") String descripcion) {
		try {
			Long id = Long.parseLong(idStr); // Convertir el ID a Long
			Producto producto = productosRepositorio.findById(id).orElse(null);

			if (producto != null) {
				producto.setNombreItem(NombreItem);
				producto.setValorUnitario(valorUnitario);
				producto.setImpoconsumo(impoconsumo);
				producto.setValorBase(valorBase);
				producto.setDescripcion(descripcion);
				productosRepositorio.save(producto);
				return "redirect:/ConfiguracionDeProductos?save";
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
