package com.sisga.web.nomina.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisga.web.nomina.controlador.dto.ContratosRegistroDTO;
import com.sisga.web.nomina.modelo.Contrato;

public interface ContratosRepositorio extends JpaRepository<Contrato, Long>{
	
//	public Contrato findByNombreCompleto(String nombreCompleto);
//	public Contrato findByNumeroDeDocumento(String numeroDeDocumento);
	public Contrato findById(long id);
	public Contrato deleteById(long id);
	public Contrato save(ContratosRegistroDTO contratosRegistroDTO);

}
