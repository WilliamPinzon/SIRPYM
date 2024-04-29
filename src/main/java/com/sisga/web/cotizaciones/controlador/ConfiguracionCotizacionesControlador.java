package com.sisga.web.cotizaciones.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisga.web.cotizaciones.servicio.CotizacionesServicio;

@Controller
public class ConfiguracionCotizacionesControlador {

	@Autowired
	private CotizacionesServicio cotizacionesServicio;

	@PostMapping("/eliminarCotizacion")
	public String eliminarCotizacionPorId(@RequestParam Long id) {
		cotizacionesServicio.deleteById(id);
		return "redirect:/CotizacionesRegistradas?delete";
	}

}
