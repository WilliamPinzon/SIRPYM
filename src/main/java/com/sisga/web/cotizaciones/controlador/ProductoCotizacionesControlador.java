package com.sisga.web.cotizaciones.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sisga.web.cotizaciones.servicio.ProductosServicio;

@Controller
public class ProductoCotizacionesControlador {

	@Autowired
	private ProductosServicio productosServicio;
	
	@GetMapping("Cotizaciones")
	public String MenuPrincipalCotizaciones() {
		return "/Cotizaciones/Cotizaciones";
	}
	
	@GetMapping("Servicios")
	public String MenuPrincipalServicios() {
		return "/index";
	}
	
	@GetMapping("ProductosRegistrados")
	public String verInventarioDeProductos(Model modelo) {
		modelo.addAttribute("Productos", productosServicio.listarProductos());
		modelo.addAttribute("maxIndice", productosServicio.cantidadDeRegistros());
		return "/Cotizaciones/ProductosRegistrados";
	}
	
	@GetMapping("ConfiguracionDeProductos")
	public String verConfiguracionDeProductos(Model modelo) {
		modelo.addAttribute("Productos", productosServicio.listarProductos());
		modelo.addAttribute("maxIndice", productosServicio.cantidadDeRegistros());
		return "/Cotizaciones/ConfiguracionDeProductos";
	}
	
}
