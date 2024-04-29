package com.sisga.web.nomina.controlador;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisga.web.nomina.controlador.dto.NominaHorasExtraRegistroDTO;
import com.sisga.web.nomina.modelo.NominaHorasExtra;
import com.sisga.web.nomina.repositorio.NominaHorasExtraRepositorio;
import com.sisga.web.nomina.servicio.NominaHorasExtraServicio;

@Controller
public class ConfiguracionHorasExtraControlador {

	@Autowired
	private NominaHorasExtraRepositorio nominaHorasExtraRepositorio;

	@Autowired
	private NominaHorasExtraServicio nominaHorasExtraServicio;

	@PostMapping("/eliminarHorasExtra")
	public String eliminarHorasExtraPorId(@RequestParam Long id) {
		nominaHorasExtraServicio.deleteById(id);
		return "redirect:/ConfiguracionNominaHorasExtra?delete";
	}

	@PostMapping("/editarHorasExtra")
	public String editarHorasExtra(@RequestParam("id") String idStr, 
			@RequestParam("fechaDeRegistroNomina") LocalDate fechaDeRegistroNomina,
			@RequestParam("horaDeIngreso") String horaDeIngreso,
			@RequestParam("horaDeSalida") String horaDeSalida,
			@RequestParam("totalHoraExtra") String totalHoraExtra,
			Model modelo,
			NominaHorasExtraRegistroDTO NominaHorasExtraRegistroDTO) {
			System.out.println("Datos: " + horaDeSalida);
		try {
			Long id = Long.parseLong(idStr);
			NominaHorasExtra nominaHorasExtra = nominaHorasExtraRepositorio.findById(id).orElse(null);
			String nombre = nominaHorasExtra.getNombreCompleto();

			nominaHorasExtra.setNombreCompleto(nombre);
			nominaHorasExtra.setFechaDeRegistroNomina(fechaDeRegistroNomina);
			nominaHorasExtra.setHoraDeIngreso(horaDeIngreso);
			nominaHorasExtra.setHoraDeSalida(horaDeSalida);
			nominaHorasExtra.setTotalHoraExtra(totalHoraExtra);
			nominaHorasExtraRepositorio.save(nominaHorasExtra);
			return "redirect:/ConfiguracionNominaHorasExtra?save";
			
		} catch (NumberFormatException e) {
			return "Error en formato de número";
		} catch (Exception e) {
			return "Error al actualizar el Colaborador";
		}
	}

}
