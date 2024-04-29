package com.sisga.web.nomina.servicio;

import java.util.List;

import com.sisga.web.nomina.controlador.dto.ContratosRegistroDTO;
import com.sisga.web.nomina.modelo.Contrato;

public interface ContratosServicio {
	public List<Contrato> listarContratos();

	public Contrato guardar(ContratosRegistroDTO contratosRegistroDTO);

	public Contrato obtenerContratoPorId(Long Id);

	public void guardarContrato(ContratosRegistroDTO contratosRegistroDTO);

	public long cantidadDeRegistros();

	Contrato editarContrato(Long id, String tipoDeContrato, String descripcion);

	void deleteById(Long id);
}
