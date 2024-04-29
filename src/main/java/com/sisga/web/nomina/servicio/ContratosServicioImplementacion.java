package com.sisga.web.nomina.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisga.web.nomina.controlador.dto.ContratosRegistroDTO;
import com.sisga.web.nomina.modelo.Contrato;
import com.sisga.web.nomina.repositorio.ContratosRepositorio;

@Service
public class ContratosServicioImplementacion implements ContratosServicio {
	
	@Autowired
	private ContratosRepositorio contratosRepositorio;

	@Autowired
	public ContratosServicioImplementacion(ContratosRepositorio contratosRepositorio) {
		this.contratosRepositorio = contratosRepositorio;
	}

	@Override
	public List<Contrato> listarContratos() {
		return contratosRepositorio.findAll();
	}

	@Override
	public Contrato guardar(ContratosRegistroDTO contratosRegistroDTO) {
		Contrato contrato = new Contrato(contratosRegistroDTO.getTipoDeContrato(), 
				contratosRegistroDTO.getDescripcion());
		return contratosRepositorio.save(contrato);
	}

	@Override
	public Contrato obtenerContratoPorId(Long id) {
		return contratosRepositorio.findById(id).orElse(null);
	}

	@Override
	public void guardarContrato(ContratosRegistroDTO contratosRegistroDTO) {
		contratosRepositorio.save(contratosRegistroDTO);
	}

	@Override
	public void deleteById(Long id) {
		contratosRepositorio.deleteById(id);
	}

	@Override
	public long cantidadDeRegistros() {
		long cantidadRegistros = contratosRepositorio.count();
		return cantidadRegistros;
	}

	@Override
	public Contrato editarContrato(Long id, String tipoDeContrato, String descripcion) {
		Optional<Contrato> optionalContrato = contratosRepositorio.findById(id);
		if (optionalContrato.isPresent()) {
			Contrato contrato = optionalContrato.get();
			contrato.setTipoDeContrato(tipoDeContrato);
			contrato.setDescripcion(descripcion);
			return contratosRepositorio.save(contrato);
		}
		return null;
	}
}
