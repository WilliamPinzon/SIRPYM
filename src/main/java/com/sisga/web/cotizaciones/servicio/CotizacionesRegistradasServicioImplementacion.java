package com.sisga.web.cotizaciones.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisga.web.cotizaciones.controlador.dto.CotizacionesRegistroDTO;
import com.sisga.web.cotizaciones.modelo.CotizacionesRegistradas;
import com.sisga.web.cotizaciones.repositorio.CotizacionesRegistradasRepositorio;

@Service
public class CotizacionesRegistradasServicioImplementacion implements CotizacionesRegistradasServicio {
	
	@Autowired
	private CotizacionesRegistradasRepositorio cotizacionesRegistradasRepositorio;

	@Autowired
	public CotizacionesRegistradasServicioImplementacion(CotizacionesRegistradasRepositorio cotizacionesRegistradasRepositorio) {
		this.cotizacionesRegistradasRepositorio = cotizacionesRegistradasRepositorio;
	}
	
	@Override
	public List<CotizacionesRegistradas> listarCotizaciones() {
		return cotizacionesRegistradasRepositorio.findAll();
	}

	@Override
	public CotizacionesRegistradas guardar(CotizacionesRegistroDTO cotizacionesRegistroDTO) {
		CotizacionesRegistradas cotizacion = new CotizacionesRegistradas(
				cotizacionesRegistroDTO.getNumeroDeDocumentoCliente(),
				cotizacionesRegistroDTO.getNombreCompletoCliente(),
				cotizacionesRegistroDTO.getProductos(),
				cotizacionesRegistroDTO.getValorTotal(),
				cotizacionesRegistroDTO.getFechaEvento(),
				cotizacionesRegistroDTO.getCantidadComensales());
		return cotizacionesRegistradasRepositorio.save(cotizacion);
	}

	@Override
    public void guardarCotizacion(CotizacionesRegistroDTO cotizacionData) {
		cotizacionesRegistradasRepositorio.save(cotizacionData);
    }

	@Override
	public long cantidadDeRegistros() {
	  long cantidadRegistros = cotizacionesRegistradasRepositorio.count();
	  return cantidadRegistros;
	}


}

