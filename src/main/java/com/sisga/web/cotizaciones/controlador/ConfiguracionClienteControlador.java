package com.sisga.web.cotizaciones.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisga.web.cotizaciones.controlador.dto.ClientesRegistroDTO;
import com.sisga.web.cotizaciones.modelo.Cliente;
import com.sisga.web.cotizaciones.modelo.TipodeID;
import com.sisga.web.cotizaciones.repositorio.ClientesRepositorio;
import com.sisga.web.cotizaciones.servicio.ClientesServicio;

@Controller
public class ConfiguracionClienteControlador {

	@Autowired
	private ClientesRepositorio clientesRepositorio;

	@Autowired
	private ClientesServicio clientesServicio;

	@PostMapping("/eliminarCliente")
	public String eliminarClientePorId(@RequestParam Long id) {
		clientesServicio.deleteById(id);
		return "redirect:/ConfiguracionDeClientes?delete";
	}

	@PostMapping("/editarCliente")
	public String editarCliente(@RequestParam("id") String idStr, 
			@RequestParam("nombreCompleto") String nombreCompleto,
			@RequestParam("tipoDeDocumento") TipodeID tipoDeDocumento,
			@RequestParam("numeroDeDocumento") String numeroDeDocumento,
			@RequestParam("correoElectronico") String correoElectronico,
			@RequestParam("numeroDeContacto") String numeroDeContacto, 
			@RequestParam("direccion") String direccion,
			@RequestParam("informacionAdicional") String informacionAdicional, 
			Model modelo,
			ClientesRegistroDTO clientesRegistroDTO) {
		modelo.addAttribute("tiposID", TipodeID.values());

		try {
			Long id = Long.parseLong(idStr);
			Cliente cliente = clientesRepositorio.findById(id).orElse(null);

			/*if (clientesRegistroDTO != null
					&& clientesServicio.existeCliente(clientesRegistroDTO.getNumeroDeDocumento())) {
				modelo.addAttribute("ClienteExistente", true);
				modelo.addAttribute("Clientes", clientesServicio.listarClientes());
				return "/Cotizaciones/ConfiguracionDeClientes";

			} else*/ if (cliente != null) {
				cliente.setNombreCompleto(nombreCompleto);
				cliente.setTipoDeDocumento(tipoDeDocumento);
				cliente.setNumeroDeDocumento(numeroDeDocumento);
				cliente.setCorreoElectronico(correoElectronico);
				cliente.setNumeroDeContacto(numeroDeContacto);
				cliente.setDireccion(direccion);
				cliente.setInformacionAdicional(informacionAdicional);
				clientesRepositorio.save(cliente);
				return "redirect:/ConfiguracionDeClientes?save";
			} else {
				return "Cliente no encontrado";
			}

		} catch (NumberFormatException e) {
			return "Error en formato de número";
		} catch (Exception e) {
			return "Error al actualizar el Cliente";
		}
	}

}
