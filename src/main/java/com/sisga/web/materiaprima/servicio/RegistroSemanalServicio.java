package com.sisga.web.materiaprima.servicio;

import java.time.LocalDate;
import java.util.List;

import com.sisga.web.materiaprima.controlador.dto.RegistrosSemanalesRegistroDTO;
import com.sisga.web.materiaprima.modelo.RegistrosSemanales;
import com.sisga.web.nomina.controlador.dto.NominaHorasExtraRegistroDTO;

public interface RegistroSemanalServicio {

	public RegistrosSemanales guardar(RegistrosSemanalesRegistroDTO registrosSemanalesRegistroDTO);

	public List<RegistrosSemanales> listarRegistrosSemanales();

	public boolean existeRegistrosSemanales(LocalDate fechaRegistroSemanal);

	public RegistrosSemanales obtenerRegistrosSemanalesPorId(Long Id);

	public void guardarRegistrosSemanales(RegistrosSemanalesRegistroDTO registrosSemanalesRegistroDTO);

	public long cantidadDeRegistros();

	RegistrosSemanales editarRegistrosSemanales(Long id, LocalDate fechaRegistroSemanal, LocalDate anho, LocalDate mes, LocalDate semana,String nombreItem, String unidad, double disponibles, 
			double producidos, double stockActual, double ventaTotal);

	public void deleteById(Long id);

	public RegistrosSemanales obtenerRegistrosSemanales(LocalDate fechaRegistroSemanal);
	
	public List<RegistrosSemanalesRegistroDTO> listarRegistrosSemanalesPorSemana(int año, int semana);
	
	public List<RegistrosSemanalesRegistroDTO> listarRegistrosSemanalesPorMes(int año, int semana);
	
	public List<RegistrosSemanalesRegistroDTO> listarRegistrosSemanalesPorAnho(int año);
}
