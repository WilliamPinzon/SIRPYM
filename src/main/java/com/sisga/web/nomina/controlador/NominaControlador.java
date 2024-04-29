package com.sisga.web.nomina.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NominaControlador {

	@GetMapping("Nomina")
	public String MenuPrincipalNomina() {
		return "/Nomina/Nomina";
	}
	
}
