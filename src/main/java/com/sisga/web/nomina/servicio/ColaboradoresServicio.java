package com.sisga.web.nomina.servicio;

import java.util.List;

import com.sisga.web.cotizaciones.modelo.TipodeID;
import com.sisga.web.nomina.controlador.dto.ColaboradoresRegistroDTO;
import com.sisga.web.nomina.modelo.Colaborador;

public interface ColaboradoresServicio {
	public List<Colaborador> listarColaboradores();

	public Colaborador guardar(ColaboradoresRegistroDTO colaboradoresRegistroDTO);

	public boolean existeColaborador(String numeroDeDocumento);

	public Colaborador obtenerColaboradorPorId(Long Id);

	public Colaborador obtenerColaboradorPorDoc(String numeroDeDocumento);

	public Colaborador obtenerColaboradorPorNombre(String nombreCompleto);

	public void guardarCliente(ColaboradoresRegistroDTO colaboradorData);

	public long cantidadDeRegistros();

	Colaborador editarColaborador(Long id, String nombreCompleto, TipodeID tipoDeDocumento, String numeroDeDocumento, String tipoDeContrato,
			String tipoDeCargo, String correoElectronico, String numeroDeContacto, String direccion, String fechaDeIngreso, boolean horasExtra);

	void deleteById(Long id);

	public List<Colaborador> listarColaboradoresHorasExtra();
}
