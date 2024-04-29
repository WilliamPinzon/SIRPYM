package com.sisga.web.nomina.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sisga.web.nomina.controlador.dto.NominaHorasExtraRegistroDTO;
import com.sisga.web.nomina.modelo.NominaHorasExtra;

public interface NominaHorasExtraRepositorio extends JpaRepository<NominaHorasExtra, Long>{
	
	public NominaHorasExtra findByNombreCompleto(String nombreCompleto);
	public NominaHorasExtra findById(long id);
	public NominaHorasExtra deleteById(long id);
	public NominaHorasExtra save(NominaHorasExtraRegistroDTO nominaHorasExtraRegistroDTO);

}
