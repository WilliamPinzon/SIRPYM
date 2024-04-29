package com.sisga.web.nomina.controlador;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisga.web.nomina.controlador.dto.NominaDiariaRegistroDTO;
import com.sisga.web.nomina.modelo.NominaDiaria;
import com.sisga.web.nomina.repositorio.NominaDiariaRepositorio;
import com.sisga.web.nomina.servicio.NominaDiariaServicio;

@Controller
public class ConfiguracionNominaDiariaControlador {

	@Autowired
	private NominaDiariaRepositorio nominaDiariaRepositorio;

	@Autowired
	private NominaDiariaServicio nominaDiariaServicio;

	@PostMapping("/eliminarNominaDiaria")
	public String eliminarNominaDiariaPorId(@RequestParam Long id) {
		nominaDiariaServicio.deleteById(id);
		return "redirect:/ConfiguracionNominaDiaria?delete";
	}

	@PostMapping("/editarNominaDiaria")
	public String editarNominaDiaria(@RequestParam("id") String idStr, 
			@RequestParam("fechaDeRegistroNomina") LocalDate fechaDeRegistroNomina,
			@RequestParam("diaLaborado") float diaLaborado,
			@RequestParam("valorACancelar") float valorACancelar,
			Model modelo,
			NominaDiariaRegistroDTO nominaDiariaRegistroDTO) {
		try {
			Long id = Long.parseLong(idStr);
			
			NominaDiaria nominaDiaria = nominaDiariaRepositorio.findById(id).orElse(null);
			String nombre = nominaDiaria.getNombreCompleto();
			String cargo = nominaDiaria.getCargo();

			nominaDiaria.setFechaDeRegistroNomina(fechaDeRegistroNomina);
			nominaDiaria.setNombreCompleto(nombre);
			nominaDiaria.setCargo(cargo);
			nominaDiaria.setDiaLaborado(diaLaborado);
			nominaDiaria.setValorACancelar(valorACancelar);
			nominaDiariaRepositorio.save(nominaDiaria);
			return "redirect:/ConfiguracionNominaDiaria?save";
			
		} catch (NumberFormatException e) {
			return "Error en formato de número";
		} catch (Exception e) {
			return "Error al actualizar el Colaborador";
		}
	}

}
