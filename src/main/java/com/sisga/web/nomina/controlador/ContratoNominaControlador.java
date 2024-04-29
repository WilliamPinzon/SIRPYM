package com.sisga.web.nomina.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sisga.web.nomina.servicio.ContratosServicio;

@Controller
public class ContratoNominaControlador {

	@Autowired
	private ContratosServicio contratosServicio;
	
	@GetMapping("ContratosRegistrados")
	public String verRegistrosDeContratos(Model modelo) {
		modelo.addAttribute("Contratos", contratosServicio.listarContratos());
		modelo.addAttribute("maxIndice", contratosServicio.cantidadDeRegistros());
		return "/Nomina/ContratosRegistrados";
	}
	
	@GetMapping("ConfiguracionDeContratos")
	public String verConfiguracionDeContratos(Model modelo) {
		modelo.addAttribute("Contratos", contratosServicio.listarContratos());
		modelo.addAttribute("maxIndice", contratosServicio.cantidadDeRegistros());
		return "/Nomina/ConfiguracionDeContratos";
	}
	
}
