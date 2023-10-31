package com.sisga.web.servicio;

import java.util.List;

import com.sisga.web.controlador.dto.ClientesRegistroDTO;
import com.sisga.web.modelo.Cliente;
import com.sisga.web.modelo.TipodeID;

public interface ClientesServicio {

	public List<Cliente> listarClientes();
	
	public Cliente guardar(
			ClientesRegistroDTO clientesRegistroDTO
			);
	
	public boolean existeCliente(
			String numeroIDCliente
			);

	public Cliente obtenerClientePorId(
			Long Id
			);

	public void guardarCliente(
			ClientesRegistroDTO clienteData
			);
	
//	public void eliminarCliente(
//			Long Id
//			);
	
	public long cantidadDeRegistros();

	Cliente editarCliente(Long id, String nombreCliente, TipodeID tipoIDCliente, String numeroIDCliente,
			String correoElectronicoCliente, String numeroDeContactoCliente, String direccionCliente,
			String adicionalCliente);
}

