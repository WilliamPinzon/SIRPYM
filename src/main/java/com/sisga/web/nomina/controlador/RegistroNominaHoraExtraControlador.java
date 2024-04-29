package com.sisga.web.nomina.controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisga.web.nomina.controlador.dto.NominaHorasExtraRegistroDTO;
import com.sisga.web.nomina.servicio.NominaHorasExtraServicio;

@Controller
@RequestMapping("/guardar-registros")
public class RegistroNominaHoraExtraControlador {

	
	private NominaHorasExtraServicio nominaHorasExtraServicio;

	public RegistroNominaHoraExtraControlador( NominaHorasExtraServicio nominaHorasExtraServicio) {
		super();
		this.nominaHorasExtraServicio = nominaHorasExtraServicio;
	}


	@PostMapping
	public String guardarRegistros(@RequestBody List<NominaHorasExtraRegistroDTO> registros, Model model) {
	    for (NominaHorasExtraRegistroDTO nominaHorasExtra : registros) {
	        // Convertir la fecha de cadena de texto a LocalDate
	        LocalDate fechaNomina = (LocalDate) nominaHorasExtra.getFechaDeRegistroNomina();
	        nominaHorasExtra.setFechaDeRegistroNomina(fechaNomina);
	        nominaHorasExtraServicio.guardar(nominaHorasExtra);
	    }

	    model.addAttribute("exito", true); // Agregar el parámetro de éxito

	    return "redirect:/NominaHorasExtra"; // Redirigir a la página principal de NominaHorasExtra
	}

}
