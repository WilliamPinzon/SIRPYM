package com.sisga.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sisga.web.servicio.ProductosServicio;

@Controller
public class ProductoCotizacionesControlador {

	@Autowired
	private ProductosServicio productosServicio;
	
	@GetMapping("AdministracionDeCotizaciones")
	public String MenuPrincipalCotizaciones() {
		return "AdministracionDeCotizaciones";
	}
	
	@GetMapping("AdministracionDeServicios")
	public String MenuPrincipalServicios() {
		return "AdministracionDeServicios";
	}
	
	@GetMapping("InventarioDeProductos")
	public String verInventarioDeProductos(Model modelo) {
		modelo.addAttribute("Productos", productosServicio.listarProductos());
		modelo.addAttribute("maxIndice", productosServicio.cantidadDeRegistros());
		return "InventarioDeProductos";
	}
	
	@GetMapping("ConfiguracionDeProductos")
	public String verConfiguracionDeProductos(Model modelo) {
		modelo.addAttribute("Productos", productosServicio.listarProductos());
		modelo.addAttribute("maxIndice", productosServicio.cantidadDeRegistros());
		return "ConfiguracionDeProductos";
	}
	
}
