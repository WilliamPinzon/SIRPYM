package com.sisga.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisga.web.modelo.Cliente;
import com.sisga.web.modelo.TipodeID;
import com.sisga.web.repositorio.ClientesRepositorio;

@Controller
public class ConfiguracionClienteControlador {

	@Autowired
	private ClientesRepositorio clientesRepositorio;	
	
	@PostMapping("/eliminarCliente")
	public String eliminarCliente(@RequestParam Long id) {
		clientesRepositorio.deleteById(id);
	    return "redirect:/ConfiguracionDeClientes?delete";
	}
	
	@PostMapping("/editarCliente")
	public String editarCliente(@RequestParam("id") String idStr,
	                             @RequestParam("nombreCliente") String nombreCliente,
	                             @RequestParam("tipoIDCliente") TipodeID tipoIDCliente,
	                             @RequestParam("numeroIDCliente") String numeroIDCliente,
	                             @RequestParam("correoElectronicoCliente") String correoElectronicoCliente,
	                             @RequestParam("numeroDeContactoCliente") String numeroDeContactoCliente,
								@RequestParam("direccionCliente") String direccionCliente,
							    @RequestParam("adicionalCliente") String adicionalCliente,
							    Model modelo){
		modelo.addAttribute("tiposID", TipodeID.values());
	    try {
	        Long id = Long.parseLong(idStr); // Convertir el ID a Long
	        Cliente cliente = clientesRepositorio.findById(id).orElse(null);

	        if (cliente != null) {
	        	cliente.setNombreCliente(nombreCliente);
	        	cliente.setTipoIDCliente(tipoIDCliente);
	        	cliente.setNumeroIDCliente(numeroIDCliente);
	        	cliente.setCorreoElectronicoCliente(correoElectronicoCliente);
	        	cliente.setNumeroDeContactoCliente(numeroDeContactoCliente);
	        	cliente.setDireccionCliente(direccionCliente);
	        	cliente.setAdicionalCliente(adicionalCliente);
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
