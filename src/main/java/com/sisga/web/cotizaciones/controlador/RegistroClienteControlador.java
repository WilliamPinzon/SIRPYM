package com.sisga.web.cotizaciones.controlador;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisga.web.cotizaciones.controlador.dto.ClientesRegistroDTO;
import com.sisga.web.cotizaciones.modelo.TipodeID;
import com.sisga.web.cotizaciones.servicio.ClientesServicio;

@Controller
@RequestMapping("/RegistroDeClientes")
public class RegistroClienteControlador {

	private ClientesServicio clientesServicio;

	public RegistroClienteControlador(ClientesServicio clientesServicio) {
		super();
		this.clientesServicio = clientesServicio;
	}

	@ModelAttribute("cliente")
	public ClientesRegistroDTO retornarNuevoClienteRegistroDTO(Model modelo) {
		modelo.addAttribute("tiposID", TipodeID.values());
		return new ClientesRegistroDTO();
	}

	@GetMapping
	public String mostrarFormularioDeRegistroCliente(Model model) throws IOException {
		return "/Cotizaciones/RegistroDeClientes";
	}

	@PostMapping
	public String registrarCliente(@ModelAttribute("cliente") ClientesRegistroDTO clientesRegistroDTO, Model modelo) {
		if (clientesServicio.existeCliente(clientesRegistroDTO.getNumeroDeDocumento())) {
			modelo.addAttribute("ClienteExistente", true);
			return "/Cotizaciones/RegistroDeClientes";
		}

		clientesServicio.guardar(clientesRegistroDTO);
		return "redirect:/RegistroDeClientes?exito";
	}
}
