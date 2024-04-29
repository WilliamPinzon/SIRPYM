package com.sisga.web.nomina.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisga.web.nomina.controlador.dto.CargosRegistroDTO;
import com.sisga.web.nomina.modelo.Cargo;
import com.sisga.web.nomina.repositorio.CargosRepositorio;

@Service
public class CargosServicioImplementacion implements CargosServicio {
	
	@Autowired
	private CargosRepositorio cargosRepositorio;

	@Autowired
	public CargosServicioImplementacion(CargosRepositorio cargosRepositorio) {
		this.cargosRepositorio = cargosRepositorio;
	}

	@Override
	public List<Cargo> listarCargos() {
		return cargosRepositorio.findAll();
	}

	@Override
	public Cargo guardar(CargosRegistroDTO cargosRegistroDTO) {
		Cargo cargo = new Cargo(
				cargosRegistroDTO.getTipoDeCargo(), 
				cargosRegistroDTO.getValorDeTransporte(),
				cargosRegistroDTO.getValorDeBase(),
				cargosRegistroDTO.getValorTotal(),
				cargosRegistroDTO.getDescripcion());
		return cargosRepositorio.save(cargo);
	}

	@Override
	public Cargo obtenerCargoPorId(Long id) {
		return cargosRepositorio.findById(id).orElse(null);
	}
	
	@Override
	public Cargo obtenerValorTotalPorTipoDeCargo(String tipoDeCargo) {
	    return cargosRepositorio.findByTipoDeCargo(tipoDeCargo);
	}


	@Override
	public void guardarCargo(CargosRegistroDTO cargosRegistroDTO) {
		cargosRepositorio.save(cargosRegistroDTO);
	}

	@Override
	public void deleteById(Long id) {
		cargosRepositorio.deleteById(id);
	}

	@Override
	public long cantidadDeRegistros() {
		long cantidadRegistros = cargosRepositorio.count();
		return cantidadRegistros;
	}

	@Override
	public Cargo editarCargo(Long id, String tipoDeCargo, String valorDeTransporte, String valorDeBase, String valorTotal, String descripcion) {
		Optional<Cargo> optionalCargo = cargosRepositorio.findById(id);
		if (optionalCargo.isPresent()) {
			Cargo cargo = optionalCargo.get();
			cargo.setTipoDeCargo(tipoDeCargo);
			cargo.setValorDeTransporte(valorDeTransporte);
			cargo.setValorDeBase(valorDeBase);
			cargo.setValorTotal(valorTotal);
			cargo.setDescripcion(descripcion);
			return cargosRepositorio.save(cargo);
		}
		return null;
	}
}
