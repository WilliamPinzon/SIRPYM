package com.sisga.web.cotizaciones.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisga.web.cotizaciones.controlador.dto.CotizacionesRegistroDTO;
import com.sisga.web.cotizaciones.modelo.CotizacionesRegistradas;

public interface CotizacionesRegistradasRepositorio extends JpaRepository<CotizacionesRegistradas, Long> {
	public CotizacionesRegistradas save(CotizacionesRegistroDTO cotizacionesRegistroDTO);
}
