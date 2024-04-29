package com.sisga.web.cotizaciones.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisga.web.cotizaciones.controlador.dto.CotizacionesRegistroDTO;
import com.sisga.web.cotizaciones.modelo.Cotizacion;

public interface CotizacionesRepositorio extends JpaRepository<Cotizacion, Long> {

//	public Cotizacion findByNombreCliente(String numeroIDCliente);
//	public Cotizacion findByNumeroIDCliente(String numeroIDCliente);
//	public List<Cotizacion> findAllByNumeroIDCliente(String numeroIDCliente);
//	public Cotizacion findById(long id);
	public Cotizacion deleteById(long id);
	public Cotizacion save(CotizacionesRegistroDTO cotizacionesRegistroDTO);
}
