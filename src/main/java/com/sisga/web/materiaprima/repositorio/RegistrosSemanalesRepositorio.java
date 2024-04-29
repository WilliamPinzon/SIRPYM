package com.sisga.web.materiaprima.repositorio;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisga.web.materiaprima.controlador.dto.RegistrosSemanalesRegistroDTO;
import com.sisga.web.materiaprima.modelo.RegistrosSemanales;

public interface RegistrosSemanalesRepositorio extends JpaRepository<RegistrosSemanales, Long> {

	public RegistrosSemanales findByfechaRegistroSemanal(LocalDate fechaRegistroSemanal);
	public RegistrosSemanales findById(long id);
	public RegistrosSemanales deleteById(long id);
	public RegistrosSemanales save(RegistrosSemanalesRegistroDTO registrosSemanalesRegistroDTO);

}
