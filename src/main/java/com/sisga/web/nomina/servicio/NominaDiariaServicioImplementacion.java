package com.sisga.web.nomina.servicio;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisga.web.nomina.controlador.dto.NominaDiariaRegistroDTO;
import com.sisga.web.nomina.modelo.NominaDiaria;
import com.sisga.web.nomina.repositorio.NominaDiariaRepositorio;

@Service
public class NominaDiariaServicioImplementacion implements NominaDiariaServicio {
	
	@Autowired
	private NominaDiariaRepositorio nominaDiariaRepositorio;

	@Autowired
	public NominaDiariaServicioImplementacion(NominaDiariaRepositorio nominaDiariaRepositorio) {
		this.nominaDiariaRepositorio = nominaDiariaRepositorio;
	}

	@Override
	public List<NominaDiaria> listarNominaDiaria() {
		return nominaDiariaRepositorio.findAll();
	}
	
	@Override
	public NominaDiaria guardar(NominaDiariaRegistroDTO nominaDiariaRegistroDTO) {
		NominaDiaria nominaDiaria = new NominaDiaria(
				nominaDiariaRegistroDTO.getFechaDeRegistroNomina(), 
				nominaDiariaRegistroDTO.getNombreCompleto(),
				nominaDiariaRegistroDTO.getCargo(), 
				nominaDiariaRegistroDTO.getDiaLaborado(),
				nominaDiariaRegistroDTO.getValorACancelar());
		return nominaDiariaRepositorio.save(nominaDiaria);
	}

	@Override
	public NominaDiaria obtenerNominaDiariaPorId(Long id) {
		return nominaDiariaRepositorio.findById(id).orElse(null);
	}

	@Override
	public void guardarNominaDiaria(NominaDiariaRegistroDTO nominaDiariaRegistroDTO) {
		nominaDiariaRepositorio.save(nominaDiariaRegistroDTO);
	}

	@Override
	public void deleteById(Long id) {
		nominaDiariaRepositorio.deleteById(id);
	}

	@Override
	public long cantidadDeRegistros() {
		long cantidadRegistros = nominaDiariaRepositorio.count();
		return cantidadRegistros;
	}

	@Override
	public NominaDiaria editarNominaDiaria(Long id, LocalDate fechaDeRegistroNomina, String nombreCompleto, String cargo,
			float diaLaborado, float valorACancelar) {
		Optional<NominaDiaria> optionalNominaDiaria = nominaDiariaRepositorio.findById(id);
		if (optionalNominaDiaria.isPresent()) {
			NominaDiaria nominaDiaria = optionalNominaDiaria.get();
			nominaDiaria.setFechaDeRegistroNomina(fechaDeRegistroNomina);
			nominaDiaria.setNombreCompleto(nombreCompleto);
			nominaDiaria.setCargo(cargo);
			nominaDiaria.setDiaLaborado(diaLaborado);
			nominaDiaria.setValorACancelar(valorACancelar);
			return nominaDiariaRepositorio.save(nominaDiaria);
		}
		return null;
	}

	@Override
	public List<NominaDiaria> listarColaboradoresPorFecha(LocalDate fechaDeRegistroNomina) {
		// Obtener todos los colaboradores
	    List<NominaDiaria> nominaDiarias = nominaDiariaRepositorio.findAll();

	    // Filtrar los colaboradores por la fecha especificada
	    List<NominaDiaria> nominaDiariaFiltrados = nominaDiarias.stream()
	            .filter(nominaDiaria -> nominaDiaria.getFechaDeRegistroNomina().isEqual(fechaDeRegistroNomina)) // Suponiendo que la fecha de la nómina se encuentra en el atributo "fechaNomina" del colaborador
	            .collect(Collectors.toList());	

	    return nominaDiariaFiltrados;
	}

//	@Override
//	public List<NominaDiaria> listarColaboradoresPorMes(int año, int mes) {
//	    // Obtener todos los colaboradores
//	    List<NominaDiaria> nominaDiarias = nominaDiariaRepositorio.findAll();
//
//	    // Filtrar los colaboradores por el mes y año especificados
//	    List<NominaDiaria> nominaDiariaFiltrados = nominaDiarias.stream()
//	            .filter(nominaDiaria -> {
//	                LocalDate fechaNomina = nominaDiaria.getFechaDeRegistroNomina();
//	                return fechaNomina.getYear() == año && fechaNomina.getMonthValue() == mes;
//	            })
//	            .collect(Collectors.toList());    
//
//	    return nominaDiariaFiltrados;
//	}
	
	@Override
	public List<NominaDiariaRegistroDTO> listarColaboradoresPorMes(int año, int mes) {
	    // Obtener todos los colaboradores
	    List<NominaDiaria> nominaDiarias = nominaDiariaRepositorio.findAll();

	    // Filtrar los colaboradores por el mes y año especificados
	    List<NominaDiaria> nominaDiariaFiltrados = nominaDiarias.stream()
	            .filter(nominaDiaria -> {
	                LocalDate fechaNomina = nominaDiaria.getFechaDeRegistroNomina();
	                return fechaNomina.getYear() == año && fechaNomina.getMonthValue() == mes;
	            })
	            .collect(Collectors.toList());    

	    // Agrupar los registros por colaborador
	    Map<String, List<NominaDiaria>> registrosPorColaborador = nominaDiariaFiltrados.stream()
	            .collect(Collectors.groupingBy(NominaDiaria::getNombreCompleto));

	    // Calcular los totales de días laborados y valor a cancelar para cada colaborador
	    List<NominaDiariaRegistroDTO> resumenPorColaborador = registrosPorColaborador.entrySet().stream()
	            .map(entry -> {
	            	String nombreCompleto = entry.getKey();
	                List<NominaDiaria> registros = entry.getValue();
	                
	                String cargo = registros.get(0).getCargo();
	                
	                float totalDiasLaborados = (float) registros.stream()
	                        .mapToDouble(NominaDiaria::getDiaLaborado) // Aquí deberías usar mapToInt
	                        .sum();
	                float totalValorCancelar = (float) registros.stream()
	                        .mapToDouble(NominaDiaria::getValorACancelar) // Aquí deberías usar mapToDouble
	                        .sum();
	                return new NominaDiariaRegistroDTO(null, null, nombreCompleto, cargo, totalDiasLaborados, totalValorCancelar, null, null);
	            })
	            .collect(Collectors.toList());

	    return resumenPorColaborador;
	}



}
