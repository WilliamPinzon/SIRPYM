package com.sisga.web.nomina.servicio;

import java.util.List;

import com.sisga.web.nomina.controlador.dto.CargosRegistroDTO;
import com.sisga.web.nomina.modelo.Cargo;

public interface CargosServicio {
	public List<Cargo> listarCargos();
	
	public Cargo guardar(CargosRegistroDTO cargosRegistroDTO);

	public Cargo obtenerCargoPorId(Long Id);
	
	Cargo obtenerValorTotalPorTipoDeCargo(String tipoDeCargo);

	public void guardarCargo(CargosRegistroDTO cargosRegistroDTO);

	public long cantidadDeRegistros();

	Cargo editarCargo(Long id, String tipoDeCargo, String valorDeTransporte,
			String valorDeBase, String valorTotal, String descripcion);

	void deleteById(Long id);
}
