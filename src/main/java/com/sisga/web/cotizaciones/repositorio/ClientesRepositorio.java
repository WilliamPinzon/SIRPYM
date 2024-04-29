package com.sisga.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisga.web.controlador.dto.ClientesRegistroDTO;
import com.sisga.web.modelo.Cliente;

public interface ClientesRepositorio extends JpaRepository<Cliente, Long> {

	public Cliente findByNombreCliente(String nombreCliente);
	public Cliente findById(long id);
	public Cliente deleteById(long id);
	public Cliente save(ClientesRegistroDTO clienteData);

}
