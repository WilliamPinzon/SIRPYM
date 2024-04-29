package com.sisga.web.nomina.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sisga.web.nomina.servicio.ColaboradoresServicio;
import com.sisga.web.nomina.servicio.NominaHorasExtraServicio;

@Controller
public class NominaHorasExtraNominaControlador {

	@Autowired
	private ColaboradoresServicio colaboradoresServicio;
	
	@Autowired
	private NominaHorasExtraServicio nominaHorasExtraServicio;
	
	
	@GetMapping("NominaHorasExtra")
	public String verNominaHorasExtra(Model modelo) {
		modelo.addAttribute("Colaboradores", colaboradoresServicio.listarColaboradoresHorasExtra());
		modelo.addAttribute("maxIndice", colaboradoresServicio.cantidadDeRegistros());
		return "/Nomina/NominaHorasExtra";
	}
	
	@GetMapping("NominaHorasExtraRegistradas")
	public String verNominaHorasExtraRegistradas(Model modelo) {
		modelo.addAttribute("HorasExtra", nominaHorasExtraServicio.listarNominaHorasExtra());
		modelo.addAttribute("maxIndice", nominaHorasExtraServicio.cantidadDeRegistros());
		return "/Nomina/NominaHorasExtraRegistradas";
	}
	
	@GetMapping("ConfiguracionNominaHorasExtra")
	public String verConfigurarNominaHorasExtra(Model modelo) {
		modelo.addAttribute("HorasExtra", nominaHorasExtraServicio.listarNominaHorasExtra());
		modelo.addAttribute("maxIndice", nominaHorasExtraServicio.cantidadDeRegistros());
		return "/Nomina/ConfiguracionNominaHorasExtra";
	}
	
}
