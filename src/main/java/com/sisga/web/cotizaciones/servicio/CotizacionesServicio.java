package com.sisga.web.cotizaciones.servicio;

import java.util.List;

import com.sisga.web.cotizaciones.controlador.dto.CotizacionesRegistroDTO;
import com.sisga.web.cotizaciones.modelo.Cotizacion;

public interface CotizacionesServicio {

	public List<Cotizacion> listarCotizaciones();

	public Cotizacion guardar(CotizacionesRegistroDTO cotizacionesRegistroDTO);

//	public boolean existeCotizacion(
//			String numeroIDCliente
//			);

//	public Cotizacion obtenerCotizacionPorId(
//			Long Id
//			);

	public void guardarCotizacion(CotizacionesRegistroDTO cotizacionData);

	public long cantidadDeRegistros();

	void deleteById(Long id);
}
