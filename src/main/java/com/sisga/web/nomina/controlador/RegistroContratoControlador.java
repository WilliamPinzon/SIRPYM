package com.sisga.web.nomina.controlador;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisga.web.nomina.controlador.dto.ContratosRegistroDTO;
import com.sisga.web.nomina.servicio.ContratosServicio;

@Controller
@RequestMapping("/RegistroDeContratos")
public class RegistroContratoControlador {

	private ContratosServicio contratosServicio;

	public RegistroContratoControlador(ContratosServicio contratosServicio) {
		super();
		this.contratosServicio = contratosServicio;
	}

	@ModelAttribute("Contrato")
	public ContratosRegistroDTO retornarNuevoContratoRegistroDTO(Model modelo) {
//		modelo.addAttribute("tiposID", TipodeID.values());
		return new ContratosRegistroDTO();
	}

	@GetMapping
	public String mostrarFormularioDeRegistroContrato(Model model) throws IOException {
		return "/Nomina/RegistroDeContratos";
	}

	@PostMapping
	public String registrarContrato(@ModelAttribute("Contrato") ContratosRegistroDTO contratosRegistroDTO, Model modelo) {
//		if (ContratosRegistroDTO.existeColaborador(colaboradoresRegistroDTO.getNumeroDeDocumento())) {
//			modelo.addAttribute("ColaboradorExistente", true);
//			return "/Nomina/RegistroDeColaboradores";
//		}

		contratosServicio.guardar(contratosRegistroDTO);
		return "redirect:/RegistroDeContratos?exito";
	}
}
