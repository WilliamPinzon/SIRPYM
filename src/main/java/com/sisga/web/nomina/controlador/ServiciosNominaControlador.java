package com.sisga.web.nomina.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiciosNominaControlador {

	@GetMapping("ServiciosNomina")
	public String verTiposNomina() {
		return "/Nomina/ServiciosNomina";
	}
	
}
