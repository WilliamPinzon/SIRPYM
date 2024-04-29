package com.sisga.web.nomina.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisga.web.nomina.controlador.dto.ContratosRegistroDTO;
import com.sisga.web.nomina.modelo.Contrato;
import com.sisga.web.nomina.repositorio.ContratosRepositorio;
import com.sisga.web.nomina.servicio.ContratosServicio;

@Controller
public class ConfiguracionContratoControlador {

	@Autowired
	private ContratosRepositorio contratosRepositorio;

	@Autowired
	private ContratosServicio contratosServicio;

	@PostMapping("/eliminarContrato")
	public String eliminarContratoPorId(@RequestParam Long id) {
		contratosServicio.deleteById(id);
		return "redirect:/ConfiguracionDeContratos?delete";
	}

	@PostMapping("/editarContrato")
	public String editarContrato(@RequestParam("id") String idStr, 
			@RequestParam("tipoDeContrato") String tipoDeContrato,
			@RequestParam("descripcion") String descripcion,
			Model modelo,
			ContratosRegistroDTO contratosRegistroDTO) {
		
		try {
			Long id = Long.parseLong(idStr);
			Contrato contrato = contratosRepositorio.findById(id).orElse(null);
			System.out.println("id: " + id);
			if (contrato != null) {
				contrato.setTipoDeContrato(tipoDeContrato);
				contrato.setDescripcion(descripcion);
				contratosRepositorio.save(contrato);
				return "redirect:/ConfiguracionDeContratos?save";
			} else {
				return "Contrato no encontrado";
			}

		} catch (NumberFormatException e) {
			return "Error en formato de número";
		} catch (Exception e) {
			return "Error al actualizar el Contrato";
		}
	}

}
