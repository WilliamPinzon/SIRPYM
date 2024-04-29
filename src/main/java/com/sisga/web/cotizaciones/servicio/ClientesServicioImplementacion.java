package com.sisga.web.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisga.web.controlador.dto.ClientesRegistroDTO;
import com.sisga.web.modelo.Cliente;
import com.sisga.web.modelo.TipodeID;
import com.sisga.web.repositorio.ClientesRepositorio;

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

//	@Override
//	public List<Cliente> listarClientes() {
//		return clientesRepositorio.findAll();
//	}
//
	@Override
	public Cliente guardar(ClientesRegistroDTO clientesRegistroDTO) {
		Cliente cliente = new Cliente(
									clientesRegistroDTO.getNombreCliente(),
									clientesRegistroDTO.getTipoIDCliente(),
									clientesRegistroDTO.getNumeroIDCliente(),
									clientesRegistroDTO.getCorreoElectronicoCliente(),
									clientesRegistroDTO.getNumeroDeContactoCliente(),
									clientesRegistroDTO.getDireccionCliente(),
									clientesRegistroDTO.getAdicionalCliente());
		return clientesRepositorio.save(cliente);
	}

	@Override
	public boolean existeCliente(String nombreCliente) {
		Cliente cliente = clientesRepositorio.findByNombreCliente(nombreCliente);
        return nombreCliente != null;
	}

	@Override
	public Cliente obtenerClientePorId(Long id) {
        return clientesRepositorio.findById(id).orElse(null);
    }

	@Override
    public void guardarCliente(ClientesRegistroDTO clienteData) {
		clientesRepositorio.save(clienteData);
    }

//	@Override
//	public void eliminarCliente(Long Id) {
//		clientesRepositorio.deleteById(Id);
//		
//	}

	@Override
	public long cantidadDeRegistros() {
	  long cantidadRegistros = clientesRepositorio.count();
	  return cantidadRegistros;
	}

	@Override
    public Cliente editarCliente(Long id, String nombreCliente, TipodeID tipoIDCliente, String numeroIDCliente, String correoElectronicoCliente, String numeroDeContactoCliente, String direccionCliente, String adicionalCliente) {
        Optional<Cliente> optionalCliente = clientesRepositorio.findById(id);
        if (optionalCliente.isPresent()) {
        	Cliente cliente = optionalCliente.get();
        	cliente.setNombreCliente(nombreCliente);
        	cliente.setTipoIDCliente(tipoIDCliente);
        	cliente.setNumeroIDCliente(numeroIDCliente);
        	cliente.setCorreoElectronicoCliente(correoElectronicoCliente);
        	cliente.setNumeroDeContactoCliente(direccionCliente);
        	cliente.setDireccionCliente(adicionalCliente);
            return clientesRepositorio.save(cliente);
        }
        return null; // Manejar la lógica de error si el artículo no existe
    }


}

