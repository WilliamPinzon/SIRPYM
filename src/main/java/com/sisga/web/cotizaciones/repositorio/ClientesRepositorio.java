package com.sisga.web.cotizaciones.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sisga.web.cotizaciones.controlador.dto.ClientesRegistroDTO;
import com.sisga.web.cotizaciones.modelo.Cliente;

@Repository
public interface ClientesRepositorio extends JpaRepository<Cliente, Long> {
	
	public Cliente findByNombreCompleto(String nombreCompleto);
	public Cliente findByNumeroDeDocumento(String numeroDeDocumento);
	public Cliente findById(long id);
	public Cliente deleteById(long id);
	public Cliente save(ClientesRegistroDTO clientesRegistroDTO);
}
