package com.sisga.web.cotizaciones.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sisga.web.cotizaciones.servicio.ClientesServicio;

@Controller
public class ClienteCotizacionesControlador {

	@Autowired
	private ClientesServicio clientesServicio;
	
	@GetMapping("ClientesRegistrados")
	public String verRegistrosDeClientes(Model modelo) {
		modelo.addAttribute("Clientes", clientesServicio.listarClientes());
		modelo.addAttribute("maxIndice", clientesServicio.cantidadDeRegistros());
		return "/Cotizaciones/ClientesRegistrados";
	}
	
	@GetMapping("ConfiguracionDeClientes")
	public String verConfiguracionDeClientes(Model modelo) {
		modelo.addAttribute("Clientes", clientesServicio.listarClientes());
		modelo.addAttribute("maxIndice", clientesServicio.cantidadDeRegistros());
		return "/Cotizaciones/ConfiguracionDeClientes";
	}
	
}
