package com.sisga.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisga.web.modelo.Producto;
import com.sisga.web.repositorio.ProductosRepositorio;

@Controller
public class ConfiguracionProductoControlador {

	@Autowired
	private ProductosRepositorio productosRepositorio;	
	
	@PostMapping("/eliminarProducto")
	public String eliminarProducto(@RequestParam Long id) {
		productosRepositorio.deleteById(id);
	    return "redirect:/ConfiguracionDeProductos?delete";
	}
	
	@PostMapping("/editarProducto")
	public String editarProducto(@RequestParam("id") String idStr,
	                             @RequestParam("nombreProducto") String nombreProducto,
	                             @RequestParam("precioProducto") String precioProducto,
	                             @RequestParam("descripcionProducto") String descripcionProducto,
	                             @RequestParam("baseProducto") String baseProducto,
	                             @RequestParam("incProducto") String incProducto) {
	    try {
	        Long id = Long.parseLong(idStr); // Convertir el ID a Long
	        Producto producto = productosRepositorio.findById(id).orElse(null);

	        if (producto != null) {
	        	producto.setNombreProducto(nombreProducto);
	        	producto.setPrecioProducto(precioProducto); // Convertir a tipo double si es necesario
	        	producto.setDescripcionProducto(descripcionProducto);
	        	producto.setBaseProducto(baseProducto); // Convertir a tipo double si es necesario
	        	producto.setIncProducto(incProducto); // Convertir a tipo double si es necesario
	        	productosRepositorio.save(producto);
	            return "redirect:/ConfiguracionDeProductos?save"; // Redirige a la página "exito"
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
