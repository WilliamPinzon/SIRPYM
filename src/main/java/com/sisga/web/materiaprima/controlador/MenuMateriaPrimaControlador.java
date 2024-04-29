package com.sisga.web.materiaprima.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sisga.web.cotizaciones.servicio.ProductosServicio;

@Controller
public class MenuMateriaPrimaControlador {

	@Autowired
	private ProductosServicio productosServicio;
	
	@GetMapping("MenuMateriaPrima")
	public String MenuPrincipalMateriaPrima() {
		return "/MateriaPrima/MenuMateriaPrima";
	}
	
	@GetMapping("AnalisisDeVentas")
	public String MenuPrincipalAnalisisDeVentas() {
		return "/MateriaPrima/AnalisisDeVentas";
	}
	

	
}
