package com.sisga.web.nomina.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sisga.web.nomina.controlador.dto.NominaDiariaRegistroDTO;
import com.sisga.web.nomina.modelo.NominaDiaria;

public interface NominaDiariaRepositorio extends JpaRepository<NominaDiaria, Long>{
	
	public NominaDiaria findByNombreCompleto(String nombreCompleto);
	public NominaDiaria findById(long id);
	public NominaDiaria deleteById(long id);
	public NominaDiaria save(NominaDiariaRegistroDTO nominaDiariaRegistroDTO);

}
