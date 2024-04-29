package com.sisga.web.nomina.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sisga.web.nomina.modelo.Cargo;
import com.sisga.web.nomina.modelo.Colaborador;
import com.sisga.web.nomina.servicio.CargosServicio;
import com.sisga.web.nomina.servicio.ColaboradoresServicio;
import com.sisga.web.nomina.servicio.NominaDiariaServicio;

@Controller
public class NominaDiariaNominaControlador {

	@Autowired
	private ColaboradoresServicio colaboradoresServicio;
	
	@Autowired
	private CargosServicio cargosServicio;
	
	@Autowired
	private NominaDiariaServicio nominaDiariaServicio;
	
	@GetMapping("NominaDiaria")
	public String verNominaHorasExtra(Model modelo) {
	    List<Colaborador> colaboradores = colaboradoresServicio.listarColaboradores();
	    
	    modelo.addAttribute("Colaboradores", colaboradores);
	    modelo.addAttribute("maxIndice", colaboradoresServicio.cantidadDeRegistros());
	    return "/Nomina/NominaDiaria";
	}
	
	@GetMapping("/obtenerValorTotal")
	@ResponseBody
	public ResponseEntity<String> obtenerValorTotalPorTipoDeCargo(@RequestParam("tipoDeCargo") String tipoDeCargo) {
	    Cargo cargo = cargosServicio.obtenerValorTotalPorTipoDeCargo(tipoDeCargo);
	    if (cargo != null) {
	        return ResponseEntity.ok(cargo.getValorTotal());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	@GetMapping("NominaDiariaRegistradas")
	public String verNominaDiariaRegistradas(Model modelo) {
		modelo.addAttribute("nominaDiaria", nominaDiariaServicio.listarNominaDiaria());
		modelo.addAttribute("maxIndice", nominaDiariaServicio.cantidadDeRegistros());
		return "/Nomina/NominaDiariaRegistradas";
	}
	
	@GetMapping("ConfiguracionNominaDiaria")
	public String verConfiguracionNominaDiaria(Model modelo) {
		modelo.addAttribute("nominaDiaria", nominaDiariaServicio.listarNominaDiaria());
		modelo.addAttribute("maxIndice", nominaDiariaServicio.cantidadDeRegistros());
		return "/Nomina/ConfiguracionNominaDiaria";
	}
	
}
