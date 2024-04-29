package com.sisga.web.nomina.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sisga.web.nomina.modelo.Cargo;
import com.sisga.web.nomina.modelo.Contrato;
import com.sisga.web.nomina.servicio.CargosServicio;
import com.sisga.web.nomina.servicio.ColaboradoresServicio;
import com.sisga.web.nomina.servicio.ContratosServicio;

@Controller
public class ColaboradorNominaControlador {

	@Autowired
	private ColaboradoresServicio colaboradoresServicio;
	
	@Autowired
	private CargosServicio cargosServicio;
	
	@Autowired
	private ContratosServicio contratosServicio;
	
	@GetMapping("ColaboradoresRegistrados")
	public String verRegistrosDeClientes(Model modelo) {
		modelo.addAttribute("Colaboradores", colaboradoresServicio.listarColaboradores());
		modelo.addAttribute("maxIndice", colaboradoresServicio.cantidadDeRegistros());
		return "/Nomina/ColaboradoresRegistrados";
	}
	
	@GetMapping("ConfiguracionDeColaboradores")
	public String verConfiguracionDeClientes(Model modelo) {
		
		List<Contrato> contrato = contratosServicio.listarContratos();
		List<Cargo> cargo = cargosServicio.listarCargos();
		
		if(contrato == null || cargo == null) {
			modelo.addAttribute("Colaboradores", colaboradoresServicio.listarColaboradores());
			modelo.addAttribute("maxIndice", colaboradoresServicio.cantidadDeRegistros());
			return "/Nomina/ConfiguracionDeColaboradores";
		}else {
			modelo.addAttribute("tipoDeContrato", contrato);
			modelo.addAttribute("tipoDeCargo", cargo);
			modelo.addAttribute("Colaboradores", colaboradoresServicio.listarColaboradores());
			modelo.addAttribute("maxIndice", colaboradoresServicio.cantidadDeRegistros());
			return "/Nomina/ConfiguracionDeColaboradores";
		}
	}
	
}
