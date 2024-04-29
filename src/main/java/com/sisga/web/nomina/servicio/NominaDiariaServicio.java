package com.sisga.web.nomina.servicio;

import java.time.LocalDate;
import java.util.List;

import com.sisga.web.nomina.controlador.dto.NominaDiariaRegistroDTO;
import com.sisga.web.nomina.modelo.NominaDiaria;

public interface NominaDiariaServicio {
	public List<NominaDiaria> listarNominaDiaria();
	
	public NominaDiaria guardar(NominaDiariaRegistroDTO nominaDiariaRegistroDTO);

	public NominaDiaria obtenerNominaDiariaPorId(Long Id);

	public void guardarNominaDiaria(NominaDiariaRegistroDTO nominaDiariaRegistroDTO);

	public long cantidadDeRegistros();

	NominaDiaria editarNominaDiaria(Long id, LocalDate fechaDeRegistroNomina, String nombreCompleto, String cargo,
			float diaLaborado, float valorACancelar);

	void deleteById(Long id);

	public List<NominaDiaria> listarColaboradoresPorFecha(LocalDate fechaDeRegistroNomina);

	public List<NominaDiariaRegistroDTO> listarColaboradoresPorMes(int año, int mes);

}
