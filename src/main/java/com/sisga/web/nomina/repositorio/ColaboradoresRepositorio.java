package com.sisga.web.nomina.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sisga.web.nomina.controlador.dto.ColaboradoresRegistroDTO;
import com.sisga.web.nomina.modelo.Colaborador;

public interface ColaboradoresRepositorio extends JpaRepository<Colaborador, Long>{
	
	public Colaborador findByNombreCompleto(String nombreCompleto);
	public Colaborador findByNumeroDeDocumento(String numeroDeDocumento);
	public Colaborador findById(long id);
	public Colaborador findByHorasExtra(boolean horasEstra);
	public Colaborador deleteById(long id);
	public Colaborador save(ColaboradoresRegistroDTO colaboradoresRegistroDTO);

}
