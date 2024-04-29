package com.sisga.web.cotizaciones.servicio;

import java.util.List;

import com.sisga.web.cotizaciones.controlador.dto.ClientesRegistroDTO;
import com.sisga.web.cotizaciones.modelo.Cliente;
import com.sisga.web.cotizaciones.modelo.TipodeID;

public interface ClientesServicio {

	public List<Cliente> listarClientes();

	public Cliente guardar(ClientesRegistroDTO clientesRegistroDTO);

	public boolean existeCliente(String numeroDeDocumento);

	public Cliente obtenerClientePorId(Long Id);

	public Cliente obtenerClientePorDoc(String numeroDeDocumento);

	public Cliente obtenerClientePorNombre(String nombreCompleto);

	public void guardarCliente(ClientesRegistroDTO clienteData);

	public long cantidadDeRegistros();

	Cliente editarCliente(Long id, String nombreCompleto, TipodeID tipoDeDocumento, String numeroDeDocumento,
			String correoElectronico, String numeroDeContacto, String direccion, String informacionAdicional);

	void deleteById(Long id);
	
	
}
