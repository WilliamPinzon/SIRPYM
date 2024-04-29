package com.sisga.web.nomina.controlador;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisga.web.cotizaciones.modelo.TipodeID;
import com.sisga.web.nomina.controlador.dto.ColaboradoresRegistroDTO;
import com.sisga.web.nomina.modelo.Cargo;
import com.sisga.web.nomina.modelo.Contrato;
import com.sisga.web.nomina.servicio.CargosServicio;
import com.sisga.web.nomina.servicio.ColaboradoresServicio;
import com.sisga.web.nomina.servicio.ContratosServicio;

@Controller
@RequestMapping("/RegistroDeColaboradores")
public class RegistroColaboradorControlador {

	private ColaboradoresServicio colaboradoresServicio;
	
	private CargosServicio cargosServicio;
	
	private ContratosServicio contratosServicio;

	public RegistroColaboradorControlador(ColaboradoresServicio colaboradoresServicio,CargosServicio cargosServicio, ContratosServicio contratosServicio) {
		super();
		this.colaboradoresServicio = colaboradoresServicio;
		this.cargosServicio = cargosServicio;
		this.contratosServicio = contratosServicio;
	}

	@ModelAttribute("Colaborador")
	public ColaboradoresRegistroDTO retornarNuevoColaboradorRegistroDTO(Model modelo) {
		
		List<Contrato> contrato = contratosServicio.listarContratos();
		List<Cargo> cargo = cargosServicio.listarCargos();
		
		if(contrato == null || cargo == null) {
			modelo.addAttribute("tiposID", TipodeID.values());
			return new ColaboradoresRegistroDTO();
		}else {
			modelo.addAttribute("tiposContratos", contrato);
			modelo.addAttribute("tiposCargos", cargo);
			modelo.addAttribute("tiposID", TipodeID.values());
			return new ColaboradoresRegistroDTO();
		}
		
		
	}

	@GetMapping
	public String mostrarFormularioDeRegistroColaborador(Model model) throws IOException {
		return "/Nomina/RegistroDeColaboradores";
	}

	@PostMapping
	public String registrarColaborador(@ModelAttribute("Colaborador") ColaboradoresRegistroDTO colaboradoresRegistroDTO, Model modelo) {
		if (colaboradoresServicio.existeColaborador(colaboradoresRegistroDTO.getNumeroDeDocumento())) {
			modelo.addAttribute("ColaboradorExistente", true);
			return "/Nomina/RegistroDeColaboradores";
		}

		colaboradoresServicio.guardar(colaboradoresRegistroDTO);
		return "redirect:/RegistroDeColaboradores?exito";
	}
}
