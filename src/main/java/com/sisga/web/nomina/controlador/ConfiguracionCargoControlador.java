package com.sisga.web.nomina.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisga.web.nomina.controlador.dto.CargosRegistroDTO;
import com.sisga.web.nomina.modelo.Cargo;
import com.sisga.web.nomina.repositorio.CargosRepositorio;
import com.sisga.web.nomina.servicio.CargosServicio;

@Controller
public class ConfiguracionCargoControlador {

	@Autowired
	private CargosRepositorio cargosRepositorio;

	@Autowired
	private CargosServicio cargosServicio;

	@PostMapping("/eliminarCargo")
	public String eliminarCargoPorId(@RequestParam Long id) {
		cargosServicio.deleteById(id);
		return "redirect:/ConfiguracionDeCargos?delete";
	}

	@PostMapping("/editarCargo")
	public String editarCargo(@RequestParam("id") String idStr, 
			@RequestParam("tipoDeCargo") String tipoDeCargo,
			@RequestParam("valorDeTransporte") String valorDeTransporte,
			@RequestParam("valorDeBase") String valorDeBase,
			@RequestParam("valorTotal") String valorTotal,
			@RequestParam("descripcion") String descripcion,
			Model modelo,
			CargosRegistroDTO cargosRegistroDTO) {
		
		try {
			Long id = Long.parseLong(idStr);
			Cargo cargo = cargosRepositorio.findById(id).orElse(null);

			if (cargo != null) {
				cargo.setTipoDeCargo(tipoDeCargo);
				cargo.setValorDeTransporte(valorDeTransporte);
				cargo.setValorDeBase(valorDeBase);
				cargo.setValorTotal(valorTotal);
				cargo.setDescripcion(descripcion);
				cargosRepositorio.save(cargo);
				return "redirect:/ConfiguracionDeCargos?save";
			} else {
				return "Cargo no encontrado";
			}

		} catch (NumberFormatException e) {
			return "Error en formato de número";
		} catch (Exception e) {
			return "Error al actualizar el Cargo";
		}
	}

}
