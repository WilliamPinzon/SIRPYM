package com.sisga.web.nomina.controlador;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisga.web.nomina.controlador.dto.CargosRegistroDTO;
import com.sisga.web.nomina.modelo.Contrato;
import com.sisga.web.nomina.servicio.CargosServicio;
import com.sisga.web.nomina.servicio.ContratosServicio;

@Controller
@RequestMapping("/RegistroDeCargos")
public class RegistroCargoControlador {

	private CargosServicio cargosServicio;
	
	private ContratosServicio contratosServicio;

	public RegistroCargoControlador(CargosServicio cargosServicio, ContratosServicio contratosServicio) {
		super();
		this.cargosServicio = cargosServicio;
		this.contratosServicio = contratosServicio;
	}

	@ModelAttribute("Cargo")
	public CargosRegistroDTO retornarNuevoCargoRegistroDTO(Model modelo) {
		List<Contrato> contrato = contratosServicio.listarContratos();
		
		if(contrato == null) {
			return new CargosRegistroDTO();
		}else {
			modelo.addAttribute("tiposContratos", contratosServicio.listarContratos());
			return new CargosRegistroDTO();
		}
	}

	@GetMapping
	public String mostrarFormularioDeRegistroCargo(Model model) throws IOException {
		return "/Nomina/RegistroDeCargos";
	}

	@PostMapping
	public String registrarCargo(@ModelAttribute("Cargo") CargosRegistroDTO cargosRegistroDTO, Model modelo) {
//		if (ContratosRegistroDTO.existeColaborador(colaboradoresRegistroDTO.getNumeroDeDocumento())) {
//			modelo.addAttribute("ColaboradorExistente", true);
//			return "/Nomina/RegistroDeColaboradores";
//		}

		cargosServicio.guardar(cargosRegistroDTO);
		return "redirect:/RegistroDeCargos?exito";
	}
}
