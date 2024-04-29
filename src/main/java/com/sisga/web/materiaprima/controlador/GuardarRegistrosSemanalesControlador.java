package com.sisga.web.materiaprima.controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisga.web.materiaprima.controlador.dto.RegistrosSemanalesRegistroDTO;
import com.sisga.web.materiaprima.servicio.RegistroSemanalServicio;

@Controller
@RequestMapping("/guardar-registrosSemanales")
public class GuardarRegistrosSemanalesControlador {

	
	private RegistroSemanalServicio registroSemanalServicio;

	public GuardarRegistrosSemanalesControlador(RegistroSemanalServicio registroSemanalServicio) {
		super();
		this.registroSemanalServicio = registroSemanalServicio;
	}


	@PostMapping
	public String guardarRegistros(@RequestBody List<RegistrosSemanalesRegistroDTO> registros, Model model) {
	    for (RegistrosSemanalesRegistroDTO registrosSemanales : registros) {
	        // Convertir la fecha de cadena de texto a LocalDate
	        LocalDate fechaNomina = (LocalDate) registrosSemanales.getFechaRegistroSemanal();
	        registrosSemanales.setFechaRegistroSemanal(fechaNomina);
	        registroSemanalServicio.guardar(registrosSemanales);
	        
	        System.out.println("hola  "+registrosSemanales);
	    }

	    model.addAttribute("exito", true); // Agregar el parámetro de éxito

	    return "redirect:/NominaDiaria"; // Redirigir a la página principal de NominaHorasExtra
	}

}
