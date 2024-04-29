package com.sisga.web.controlador;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisga.web.controlador.dto.ClientesRegistroDTO;
import com.sisga.web.modelo.TipodeID;
import com.sisga.web.servicio.ClientesServicio;

@Controller
@RequestMapping("/RegistroDeCotizaciones")
public class RegistroCotizacionesControlador {
	
	private ClientesServicio clientesServicio;
	
	public RegistroCotizacionesControlador(ClientesServicio clientesServicio) {
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
	    return "RegistroDeCotizaciones";
	}

	
	@PostMapping
	public String registrarProducto(@ModelAttribute("cliente") ClientesRegistroDTO clientesRegistroDTO, Model modelo) {
		if (clientesServicio.existeCliente(clientesRegistroDTO.getNumeroIDCliente())) {
	        modelo.addAttribute("ClienteExistente", true);
	        return "RegistroDeCotizaciones";
	    }
		
		clientesServicio.guardar(clientesRegistroDTO);
	    return "redirect:/RegistroDeCotizaciones?exito";
	}


}
