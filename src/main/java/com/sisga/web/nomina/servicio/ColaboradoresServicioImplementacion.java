package com.sisga.web.nomina.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisga.web.cotizaciones.modelo.TipodeID;
import com.sisga.web.nomina.controlador.dto.ColaboradoresRegistroDTO;
import com.sisga.web.nomina.modelo.Colaborador;
import com.sisga.web.nomina.repositorio.ColaboradoresRepositorio;

@Service
public class ColaboradoresServicioImplementacion implements ColaboradoresServicio {
	
	@Autowired
	private ColaboradoresRepositorio colaboradoresRepositorio;

	@Autowired
	public ColaboradoresServicioImplementacion(ColaboradoresRepositorio colaboradoresRepositorio) {
		this.colaboradoresRepositorio = colaboradoresRepositorio;
	}

	@Override
	public List<Colaborador> listarColaboradores() {
		return colaboradoresRepositorio.findAll();
	}
	
	@Override
	public List<Colaborador> listarColaboradoresHorasExtra() {
	    List<Colaborador> lista = colaboradoresRepositorio.findAll();
	    List<Colaborador> listaExtra = new ArrayList<>();

	    for (Colaborador colaborador : lista) {
	        if (colaborador.isHorasExtra()) {
	            listaExtra.add(colaborador);
	        }
	    }

	    if (listaExtra.isEmpty()) {
	        return null;
	    } else {
	        return listaExtra;
	    }
	}


	@Override
	public Colaborador guardar(ColaboradoresRegistroDTO colaboradoresRegistroDTO) {
		Colaborador colaborador = new Colaborador(colaboradoresRegistroDTO.getNombreCompleto(), 
				colaboradoresRegistroDTO.getTipoDeDocumento(),
				colaboradoresRegistroDTO.getNumeroDeDocumento(), 
				colaboradoresRegistroDTO.getTipoDeContrato(),
				colaboradoresRegistroDTO.getTipoDeCargo(),
				colaboradoresRegistroDTO.getCorreoElectronico(),
				colaboradoresRegistroDTO.getNumeroDeContacto(), 
				colaboradoresRegistroDTO.getDireccion(),
				colaboradoresRegistroDTO.getFechaDeIngreso(),
				colaboradoresRegistroDTO.isHorasExtra());
		return colaboradoresRepositorio.save(colaborador);
	}

	@Override
	public boolean existeColaborador(String numeroDeDocumento) {
		Colaborador colaborador = colaboradoresRepositorio.findByNumeroDeDocumento(numeroDeDocumento);
		return colaborador != null;
	}

	@Override
	public Colaborador obtenerColaboradorPorId(Long id) {
		return colaboradoresRepositorio.findById(id).orElse(null);
	}

	@Override
	public Colaborador obtenerColaboradorPorNombre(String nombreCompleto) {
		Colaborador colaborador = colaboradoresRepositorio.findByNombreCompleto(nombreCompleto);
		return colaborador;
	}

	@Override
	public Colaborador obtenerColaboradorPorDoc(String numeroDeDocumento) {
		Colaborador colaborador = colaboradoresRepositorio.findByNumeroDeDocumento(numeroDeDocumento);
		return colaborador;
	}

	@Override
	public void guardarCliente(ColaboradoresRegistroDTO colaboradorData) {
		colaboradoresRepositorio.save(colaboradorData);
	}

	@Override
	public void deleteById(Long id) {
		colaboradoresRepositorio.deleteById(id);
	}

	@Override
	public long cantidadDeRegistros() {
		long cantidadRegistros = colaboradoresRepositorio.count();
		return cantidadRegistros;
	}

	@Override
	public Colaborador editarColaborador(Long id, String nombreCompleto, TipodeID tipoDeDocumento, String numeroDeDocumento,
			String tipoDeContrato, String tipoDeCargo, String correoElectronico, String numeroDeContacto, String direccion,
			String fechaDeIngreso, boolean horasExtra) {
		Optional<Colaborador> optionalColaborador = colaboradoresRepositorio.findById(id);
		if (optionalColaborador.isPresent()) {
			Colaborador colaborador = optionalColaborador.get();
			colaborador.setNombreCompleto(nombreCompleto);
			colaborador.setTipoDeDocumento(tipoDeDocumento);
			colaborador.setNumeroDeDocumento(numeroDeDocumento);
			colaborador.setTipoDeContrato(tipoDeContrato);
			colaborador.setTipoDeCargo(tipoDeCargo);
			colaborador.setCorreoElectronico(correoElectronico);
			colaborador.setNumeroDeContacto(numeroDeContacto);
			colaborador.setFechaDeIngreso(fechaDeIngreso);
			colaborador.setHorasExtra(horasExtra);
			return colaboradoresRepositorio.save(colaborador);
		}
		return null;
	}
}
