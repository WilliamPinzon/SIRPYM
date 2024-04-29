package com.sisga.web.cotizaciones.servicio;

import java.util.List;

import com.sisga.web.cotizaciones.controlador.dto.CotizacionesRegistroDTO;
import com.sisga.web.cotizaciones.modelo.CotizacionesRegistradas;

public interface CotizacionesRegistradasServicio {
	
	public List<CotizacionesRegistradas> listarCotizaciones();

	public CotizacionesRegistradas guardar(CotizacionesRegistroDTO cotizacionesRegistroDTO);

	public void guardarCotizacion(CotizacionesRegistroDTO cotizacionData);

	public long cantidadDeRegistros();

}
