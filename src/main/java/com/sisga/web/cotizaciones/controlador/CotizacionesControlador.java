package com.sisga.web.cotizaciones.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sisga.web.cotizaciones.servicio.CotizacionesServicio;

@Controller
public class CotizacionesControlador {

	@Autowired
	private CotizacionesServicio cotizacionesServicio;
	
	@GetMapping("CotizacionesRegistradas")
	public String verRegistrosDeClientes(Model modelo) {
		modelo.addAttribute("Cotizaciones", cotizacionesServicio.listarCotizaciones());
		modelo.addAttribute("maxIndice", cotizacionesServicio.cantidadDeRegistros());
		return "/Cotizaciones/CotizacionesRegistradas";
	}
	
}
