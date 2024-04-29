package com.sisga.web.materiaprima.servicio;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisga.web.materiaprima.controlador.dto.RegistrosSemanalesRegistroDTO;
import com.sisga.web.materiaprima.modelo.RegistrosSemanales;
import com.sisga.web.materiaprima.repositorio.RegistrosSemanalesRepositorio;

@Service
public class RegistrosSemanalesServicioImplementacion implements RegistroSemanalServicio {

	@Autowired
	private RegistrosSemanalesRepositorio registrosSemanalesRepositorio;

	@Autowired
	public RegistrosSemanalesServicioImplementacion(RegistrosSemanalesRepositorio registrosSemanalesRepositorio) {
		this.registrosSemanalesRepositorio = registrosSemanalesRepositorio;
	}

	@Override
	public List<RegistrosSemanales> listarRegistrosSemanales() {
		return registrosSemanalesRepositorio.findAll();
	}

	@Override
	public RegistrosSemanales guardar(RegistrosSemanalesRegistroDTO registrosSemanalesRegistroDTO) {
		RegistrosSemanales registrosSemanales = new RegistrosSemanales(
				registrosSemanalesRegistroDTO.getFechaRegistroSemanal(),
				registrosSemanalesRegistroDTO.getAnho(),
				registrosSemanalesRegistroDTO.getMes(),
				registrosSemanalesRegistroDTO.getSemana(),
				registrosSemanalesRegistroDTO.getNombreItem(),
				registrosSemanalesRegistroDTO.getUnidad(),
				registrosSemanalesRegistroDTO.getDisponibles(),
				registrosSemanalesRegistroDTO.getProducidos(),
				registrosSemanalesRegistroDTO.getStockActual(),
				registrosSemanalesRegistroDTO.getVentaTotal());

		return registrosSemanalesRepositorio.save(registrosSemanales);
	}

	@Override
	public boolean existeRegistrosSemanales(LocalDate fechaRegistroSemanal) {
//		Producto producto = productosRepositorio.findBynombreItem(nombreItem);
		return fechaRegistroSemanal != null;
	}

	@Override
	public RegistrosSemanales obtenerRegistrosSemanalesPorId(Long id) {
		return registrosSemanalesRepositorio.findById(id).orElse(null);
	}

	@Override
	public void guardarRegistrosSemanales(RegistrosSemanalesRegistroDTO registrosSemanalesRegistroDTO) {
		registrosSemanalesRepositorio.save(registrosSemanalesRegistroDTO);
	}

	@Override
	public RegistrosSemanales obtenerRegistrosSemanales(LocalDate fechaRegistroSemanal) {
		RegistrosSemanales registrosSemanales = registrosSemanalesRepositorio.findByfechaRegistroSemanal(fechaRegistroSemanal);
		return registrosSemanales;
	}

	@Override
	public void deleteById(Long Id) {
		registrosSemanalesRepositorio.deleteById(Id);

	}

	@Override
	public long cantidadDeRegistros() {
		long cantidadRegistros = registrosSemanalesRepositorio.count();
		return cantidadRegistros;
	}

	@Override
	public RegistrosSemanales editarRegistrosSemanales(Long id, LocalDate fechaRegistroSemanal, LocalDate anho, LocalDate mes, LocalDate semana,String nombreItem, String unidad, double disponibles, 
			double producidos, double stockActual, double ventaTotal) {
		Optional<RegistrosSemanales> optionalRegistrosSemanales = registrosSemanalesRepositorio.findById(id);
		if (optionalRegistrosSemanales.isPresent()) {
			RegistrosSemanales registrosSemanales = optionalRegistrosSemanales.get();
			registrosSemanales.setNombreItem(nombreItem);
			return registrosSemanalesRepositorio.save(registrosSemanales);
		}
		return null;
	}
	
	@Override
	public List<RegistrosSemanalesRegistroDTO> listarRegistrosSemanalesPorSemana(int año, int semana) {
		// Obtener todos los registros semanales
		List<RegistrosSemanales> registrosSemanales = registrosSemanalesRepositorio.findAll();
		
		// Filtrar los registros por el año y la semana especificados
		List<RegistrosSemanales> registrosSemanalesFiltrados = registrosSemanales.stream()
				.filter(registro -> {
					LocalDate fechaRegistro = registro.getFechaRegistroSemanal();
					return fechaRegistro.getYear() == año && fechaRegistro.get(WeekFields.ISO.weekOfWeekBasedYear()) == semana;
				})
				.collect(Collectors.toList());    
		
		// Convertir los registros filtrados a DTO si es necesario y devolverlos
		return convertirARegistrosSemanalesDTO(registrosSemanalesFiltrados);
	}
	
	private List<RegistrosSemanalesRegistroDTO> convertirARegistrosSemanalesDTO(List<RegistrosSemanales> registros) {
		return registros.stream()
				.map(registro -> {
					RegistrosSemanalesRegistroDTO dto = new RegistrosSemanalesRegistroDTO();
					dto.setId(registro.getId());
					dto.setFechaRegistroSemanal(registro.getFechaRegistroSemanal());
					dto.setNombreItem(registro.getNombreItem());
					dto.setUnidad(registro.getUnidad());
					dto.setDisponibles(registro.getDisponibles());
					dto.setProducidos(registro.getProducidos());
					dto.setStockActual(registro.getStockActual());
					dto.setVentaTotal(registro.getVentaTotal());
					
					// Aquí asigna otros atributos del DTO según corresponda
					return dto;
				})
				.collect(Collectors.toList());
	}
	
	@Override
	public List<RegistrosSemanalesRegistroDTO> listarRegistrosSemanalesPorMes(int año, int mes) {
		// Obtener todos los registros semanales
		List<RegistrosSemanales> registrosSemanales = registrosSemanalesRepositorio.findAll();
		
		// Filtrar los registros por el año y el mes especificados
		List<RegistrosSemanales> registrosSemanalesFiltrados = registrosSemanales.stream()
				.filter(registro -> {
					LocalDate fechaRegistro = registro.getFechaRegistroSemanal();
					return fechaRegistro.getYear() == año && fechaRegistro.getMonthValue() == mes;
				})
				.collect(Collectors.toList());
		
		// Crear una lista de DTOs para almacenar los registros
		List<RegistrosSemanalesRegistroDTO> registrosDTO = new ArrayList<>();
		
		// Iterar sobre los registros semanales filtrados
		registrosSemanalesFiltrados.forEach(registro -> {
			RegistrosSemanalesRegistroDTO dto = new RegistrosSemanalesRegistroDTO();
			dto.setNombreItem(registro.getNombreItem());
			dto.setVentaTotal(registro.getVentaTotal());
			dto.setSemana(registro.getSemana()); // Asegúrate de tener un campo para la semana en tu DTO
			
			// Aquí establecemos la unidad en el DTO
			dto.setUnidad(registro.getUnidad());
			
			registrosDTO.add(dto);
		});
		
		return registrosDTO;
	}
	
	@Override
	public List<RegistrosSemanalesRegistroDTO> listarRegistrosSemanalesPorAnho(int año) {
	    // Obtener todos los registros semanales
	    List<RegistrosSemanales> registrosSemanales = registrosSemanalesRepositorio.findAll();

	    // Filtrar los registros por el año especificado
	    List<RegistrosSemanales> registrosSemanalesFiltrados = registrosSemanales.stream()
	            .filter(registro -> registro.getFechaRegistroSemanal().getYear() == año)
	            .collect(Collectors.toList());

	    // Crear una lista de DTOs para almacenar los registros
	    List<RegistrosSemanalesRegistroDTO> registrosDTO = new ArrayList<>();

	    // Iterar sobre los registros semanales filtrados
	    registrosSemanalesFiltrados.forEach(registro -> {
	        RegistrosSemanalesRegistroDTO dto = new RegistrosSemanalesRegistroDTO();
	        dto.setNombreItem(registro.getNombreItem());
	        dto.setVentaTotal(registro.getVentaTotal());
	        dto.setSemana(registro.getSemana()); // Asegúrate de tener un campo para la semana en tu DTO
	        dto.setMes(registro.getMes()); // Asegúrate de tener un campo para el mes en tu DTO
	        dto.setAnho(registro.getAnho()); // Asegúrate de tener un campo para el año en tu DTO
	        
	        // Aquí establecemos la unidad en el DTO
	        dto.setUnidad(registro.getUnidad());
	        
	        registrosDTO.add(dto);
	    });

	    return registrosDTO;
	}












}
