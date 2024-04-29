package com.sisga.web.nomina.servicio;

import java.time.LocalDate;
import java.util.List;

import com.sisga.web.nomina.controlador.dto.NominaHorasExtraRegistroDTO;
import com.sisga.web.nomina.modelo.NominaHorasExtra;

public interface NominaHorasExtraServicio {
	public List<NominaHorasExtra> listarNominaHorasExtra();
	
	public NominaHorasExtra guardar(NominaHorasExtraRegistroDTO nominaHorasExtraRegistroDTO);

	public NominaHorasExtra obtenerNominaHorasExtraPorId(Long Id);

	public void guardarNominaHorasExtra(NominaHorasExtraRegistroDTO nominaHorasExtraRegistroDTO);

	public long cantidadDeRegistros();

	NominaHorasExtra editarNominaHorasExtra(Long id, String nombreCompleto, LocalDate fechaDeRegistroNomina,
			String horaDeIngreso, String horaDeSalida, String totalHoraExtra);

	void deleteById(Long id);

	public List<NominaHorasExtraRegistroDTO> listarColaboradoresPorMes(int año, int mes);

}
