package com.sisga.web.nomina.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasesNominaControlador {

	@GetMapping("Bases")
	public String verBasesNomina() {
		return "/Nomina/Bases";
	}
	
}
