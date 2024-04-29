package com.sisga.web.nomina.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sisga.web.nomina.modelo.Contrato;
import com.sisga.web.nomina.servicio.CargosServicio;
import com.sisga.web.nomina.servicio.ContratosServicio;

@Controller
public class CargoNominaControlador {

	@Autowired
	private CargosServicio cargosServicio;
	
	@Autowired
	private ContratosServicio contratosServicio;
	
	@GetMapping("CargosRegistrados")
	public String verRegistrosDeContratos(Model modelo) {
		modelo.addAttribute("Cargos", cargosServicio.listarCargos());
		modelo.addAttribute("maxIndice", cargosServicio.cantidadDeRegistros());
		return "/Nomina/CargosRegistrados";
	}
	
	@GetMapping("ConfiguracionDeCargos")
	public String verConfiguracionDeContratos(Model modelo) {
	    List<Contrato> tiposContratos = contratosServicio.listarContratos();
	    Contrato tipoDeContrato = new Contrato(); // Inicializa el objeto tipoDeContrato
	    
	    modelo.addAttribute("tiposContratos", tiposContratos);
	    modelo.addAttribute("tipoDeContrato", tipoDeContrato); // Agrega el objeto al modelo
	    modelo.addAttribute("Cargos", cargosServicio.listarCargos());
	    modelo.addAttribute("maxIndice", cargosServicio.cantidadDeRegistros());
	    
	    return "/Nomina/ConfiguracionDeCargos";
	}


}
