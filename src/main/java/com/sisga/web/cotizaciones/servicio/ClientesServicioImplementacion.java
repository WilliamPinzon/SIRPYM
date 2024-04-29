package com.sisga.web.cotizaciones.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisga.web.cotizaciones.controlador.dto.ClientesRegistroDTO;
import com.sisga.web.cotizaciones.modelo.Cliente;
import com.sisga.web.cotizaciones.modelo.TipodeID;
import com.sisga.web.cotizaciones.repositorio.ClientesRepositorio;

@Service
public class ClientesServicioImplementacion implements ClientesServicio {

	@Autowired
	private ClientesRepositorio clientesRepositorio;

	@Autowired
	public ClientesServicioImplementacion(ClientesRepositorio clientesRepositorio) {
		this.clientesRepositorio = clientesRepositorio;
	}

	@Override
	public List<Cliente> listarClientes() {
		return clientesRepositorio.findAll();
	}

	@Override
	public Cliente guardar(ClientesRegistroDTO clientesRegistroDTO) {
		Cliente cliente = new Cliente(clientesRegistroDTO.getNombreCompleto(), clientesRegistroDTO.getTipoDeDocumento(),
				clientesRegistroDTO.getNumeroDeDocumento(), clientesRegistroDTO.getCorreoElectronico(),
				clientesRegistroDTO.getNumeroDeContacto(), clientesRegistroDTO.getDireccion(),
				clientesRegistroDTO.getInformacionAdicional());
		return clientesRepositorio.save(cliente);
	}

	@Override
	public boolean existeCliente(String numeroDeDocumento) {
		Cliente cliente = clientesRepositorio.findByNumeroDeDocumento(numeroDeDocumento);
		return cliente != null;
	}

	@Override
	public Cliente obtenerClientePorId(Long id) {
		return clientesRepositorio.findById(id).orElse(null);
	}

	@Override
	public Cliente obtenerClientePorNombre(String nombreCompleto) {
		Cliente cliente = clientesRepositorio.findByNombreCompleto(nombreCompleto);
		return cliente;
	}

	@Override
	public Cliente obtenerClientePorDoc(String numeroDeDocumento) {
		Cliente cliente = clientesRepositorio.findByNumeroDeDocumento(numeroDeDocumento);
		return cliente;
	}

	@Override
	public void guardarCliente(ClientesRegistroDTO clientesRegistroDTO) {
		clientesRepositorio.save(clientesRegistroDTO);
	}

	@Override
	public void deleteById(Long id) {
		clientesRepositorio.deleteById(id);
	}

	@Override
	public long cantidadDeRegistros() {
		long cantidadRegistros = clientesRepositorio.count();
		return cantidadRegistros;
	}

	@Override
	public Cliente editarCliente(Long id, String nombreCompleto, TipodeID tipoDeDocumento, String numeroDeDocumento,
			String correoElectronico, String numeroDeContacto, String direccion,
			String informacionAdicional) {
		Optional<Cliente> optionalCliente = clientesRepositorio.findById(id);
		if (optionalCliente.isPresent()) {
			Cliente cliente = optionalCliente.get();
			cliente.setNombreCompleto(nombreCompleto);
			cliente.setTipoDeDocumento(tipoDeDocumento);
			cliente.setNumeroDeDocumento(numeroDeDocumento);
			cliente.setCorreoElectronico(correoElectronico);
			cliente.setNumeroDeContacto(numeroDeContacto);
			cliente.setInformacionAdicional(informacionAdicional);
			return clientesRepositorio.save(cliente);
		}
		return null;
	}

}
