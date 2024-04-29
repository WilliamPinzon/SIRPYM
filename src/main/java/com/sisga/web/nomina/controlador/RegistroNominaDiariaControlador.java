package com.sisga.web.nomina.controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisga.web.nomina.controlador.dto.NominaDiariaRegistroDTO;
import com.sisga.web.nomina.servicio.NominaDiariaServicio;

@Controller
@RequestMapping("/guardar-registrosNominaDiaria")
public class RegistroNominaDiariaControlador {

	
	private NominaDiariaServicio nominaDiariaServicio;

	public RegistroNominaDiariaControlador( NominaDiariaServicio nominaDiariaServicio) {
		super();
		this.nominaDiariaServicio = nominaDiariaServicio;
	}


	@PostMapping
	public String guardarRegistros(@RequestBody List<NominaDiariaRegistroDTO> registros, Model model) {
	    for (NominaDiariaRegistroDTO nominaDiaria : registros) {
	        // Convertir la fecha de cadena de texto a LocalDate
	        LocalDate fechaNomina = (LocalDate) nominaDiaria.getFechaDeRegistroNomina();
	        nominaDiaria.setFechaDeRegistroNomina(fechaNomina);
	        nominaDiariaServicio.guardar(nominaDiaria);
	    }

	    model.addAttribute("exito", true); // Agregar el parámetro de éxito

	    return "redirect:/NominaDiaria"; // Redirigir a la página principal de NominaHorasExtra
	}

}
