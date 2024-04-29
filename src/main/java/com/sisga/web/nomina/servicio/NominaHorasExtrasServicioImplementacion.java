package com.sisga.web.nomina.servicio;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisga.web.nomina.controlador.dto.NominaHorasExtraRegistroDTO;
import com.sisga.web.nomina.modelo.NominaHorasExtra;
import com.sisga.web.nomina.repositorio.NominaHorasExtraRepositorio;

@Service
public class NominaHorasExtrasServicioImplementacion implements NominaHorasExtraServicio {
	
	@Autowired
	private NominaHorasExtraRepositorio nominaHorasExtraRepositorio;

	@Autowired
	public NominaHorasExtrasServicioImplementacion(NominaHorasExtraRepositorio nominaHorasExtraRepositorio) {
		this.nominaHorasExtraRepositorio = nominaHorasExtraRepositorio;
	}

	@Override
	public List<NominaHorasExtra> listarNominaHorasExtra() {
		return nominaHorasExtraRepositorio.findAll();
	}
	
	@Override
	public NominaHorasExtra guardar(NominaHorasExtraRegistroDTO nominaHorasExtraRegistroDTO) {
		NominaHorasExtra nominaHorasExtra = new NominaHorasExtra(
				nominaHorasExtraRegistroDTO.getNombreCompleto(), 
				nominaHorasExtraRegistroDTO.getFechaDeRegistroNomina(),
				nominaHorasExtraRegistroDTO.getHoraDeIngreso(), 
				nominaHorasExtraRegistroDTO.getTotalHoraExtra(),
				nominaHorasExtraRegistroDTO.getHoraDeSalida());
		return nominaHorasExtraRepositorio.save(nominaHorasExtra);
	}

	@Override
	public NominaHorasExtra obtenerNominaHorasExtraPorId(Long id) {
		return nominaHorasExtraRepositorio.findById(id).orElse(null);
	}

	@Override
	public void guardarNominaHorasExtra(NominaHorasExtraRegistroDTO nominaHorasExtraRegistroDTO) {
		nominaHorasExtraRepositorio.save(nominaHorasExtraRegistroDTO);
	}

	@Override
	public void deleteById(Long id) {
		nominaHorasExtraRepositorio.deleteById(id);
	}

	@Override
	public long cantidadDeRegistros() {
		long cantidadRegistros = nominaHorasExtraRepositorio.count();
		return cantidadRegistros;
	}

	@Override
	public NominaHorasExtra editarNominaHorasExtra(Long id, String nombreCompleto, LocalDate fechaDeRegistroNomina,
			String horaDeIngreso, String horaDeSalida, String totalHoraExtra) {
		Optional<NominaHorasExtra> optionalNominaHorasExtra = nominaHorasExtraRepositorio.findById(id);
		if (optionalNominaHorasExtra.isPresent()) {
			NominaHorasExtra nominaHorasExtra = optionalNominaHorasExtra.get();
			nominaHorasExtra.setNombreCompleto(nombreCompleto);
			nominaHorasExtra.setFechaDeRegistroNomina(fechaDeRegistroNomina);
			nominaHorasExtra.setHoraDeIngreso(horaDeIngreso);
			nominaHorasExtra.setHoraDeSalida(horaDeSalida);
			nominaHorasExtra.setTotalHoraExtra(totalHoraExtra);
			return nominaHorasExtraRepositorio.save(nominaHorasExtra);
		}
		return null;
	}

	@Override
	public List<NominaHorasExtraRegistroDTO> listarColaboradoresPorMes(int año, int mes) {
	    // Obtener todos los colaboradores
	    List<NominaHorasExtra> nominaHorasExtra = nominaHorasExtraRepositorio.findAll();

	    // Filtrar los colaboradores por el mes y año especificados
	    List<NominaHorasExtra> nominaHorasExtraFiltrados = nominaHorasExtra.stream()
	            .filter(nominaHoraExtra -> {
	                LocalDate fechaNomina = nominaHoraExtra.getFechaDeRegistroNomina();
	                return fechaNomina.getYear() == año && fechaNomina.getMonthValue() == mes;
	            })
	            .collect(Collectors.toList());    

	    // Agrupar los registros por colaborador
	    Map<String, List<NominaHorasExtra>> registrosPorColaborador = nominaHorasExtraFiltrados.stream()
	            .collect(Collectors.groupingBy(NominaHorasExtra::getNombreCompleto));

	    // Calcular los totales de horas extra para cada colaborador
	    List<NominaHorasExtraRegistroDTO> resumenPorColaborador = registrosPorColaborador.entrySet().stream()
	            .map(entry -> {
	                String nombreCompleto = entry.getKey();
	                List<NominaHorasExtra> registros = entry.getValue();
	                float totalHorasExtra = (float) registros.stream()
	                        .mapToDouble(nominaHorasExtraRegistro -> Double.parseDouble(nominaHorasExtraRegistro.getTotalHoraExtra()))
	                        .sum();
	                String total = String.valueOf(totalHorasExtra);
	                System.out.println("Total de horas extra " + total);
	                return new NominaHorasExtraRegistroDTO(null, nombreCompleto, null, null, null, total, null, null);
	            })
	            .collect(Collectors.toList());

	    return resumenPorColaborador;
	}



}
