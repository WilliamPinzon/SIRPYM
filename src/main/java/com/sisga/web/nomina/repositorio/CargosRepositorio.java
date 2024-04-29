package com.sisga.web.nomina.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisga.web.nomina.controlador.dto.CargosRegistroDTO;
import com.sisga.web.nomina.modelo.Cargo;

public interface CargosRepositorio extends JpaRepository<Cargo, Long>{
	
//	public Cargo findByNombreCompleto(String nombreCompleto);
//	public Cargo findByNumeroDeDocumento(String numeroDeDocumento);
	public Cargo findById(long id);
	Cargo findByTipoDeCargo(String tipoDeCargo);
	public Cargo deleteById(long id);
	public Cargo save(CargosRegistroDTO cargosRegistroDTO);

}
