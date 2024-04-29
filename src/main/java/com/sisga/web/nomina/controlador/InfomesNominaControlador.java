package com.sisga.web.nomina.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisga.web.nomina.controlador.dto.NominaDiariaRegistroDTO;
import com.sisga.web.nomina.controlador.dto.NominaHorasExtraRegistroDTO;
import com.sisga.web.nomina.servicio.NominaDiariaServicio;
import com.sisga.web.nomina.servicio.NominaHorasExtraServicio;

@Controller
public class InfomesNominaControlador {

	@GetMapping("InformesNomina")
	public String verTiposNomina() {
		return "/Nomina/InformesNomina";
	}
	
	@Autowired
	private NominaDiariaServicio nominaDiariaServicio;
	
	@Autowired
	private NominaHorasExtraServicio nominaHorasExtraServicio;
	
	
	@GetMapping("InformeMensualNominaDiaria")
	public String verInformeMensualNominaDiaria(Model modelo) {
	    return "/Nomina/InformeMensualNominaDiaria";
	}
	
	
	@GetMapping("/verInformeMensualNominaDiaria")
	public ResponseEntity<List<NominaDiariaRegistroDTO>> verInformeNominaDiaria(@RequestParam("año") int año, @RequestParam("mes") int mes) {
	    List<NominaDiariaRegistroDTO> colaboradores = nominaDiariaServicio.listarColaboradoresPorMes(año, mes);
	    return new ResponseEntity<>(colaboradores, HttpStatus.OK);
	}
	
	@GetMapping("InformeMensualNominaHorasExtra")
	public String verInformeMensualNominaHorasExtra(Model modelo) {
	    return "/Nomina/InformeMensualNominaHorasExtra";
	}
	
	
	@GetMapping("/verInformeMensualNominaHorasExtra")
	public ResponseEntity<List<NominaHorasExtraRegistroDTO>> verNominaHorasExtra(@RequestParam("año") int año, @RequestParam("mes") int mes) {
	    List<NominaHorasExtraRegistroDTO> colaboradores = nominaHorasExtraServicio.listarColaboradoresPorMes(año, mes);
	    return new ResponseEntity<>(colaboradores, HttpStatus.OK);
	}
	
//	@GetMapping("verInformeMensualNominaDiaria")
//	public List<NominaDiariaRegistroDTO> verNominaHorasExtra(@RequestParam("fechaDeRegistroNomina") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaDeRegistroNomina) {
//	    // Lógica para obtener y procesar los datos aquí
//	    return resumenPorColaborador; // Devuelve una lista de NominaDiariaRegistroDTO
//	}


}
