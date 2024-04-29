package com.sisga.web.cotizaciones.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisga.web.cotizaciones.controlador.dto.CotizacionesRegistroDTO;
import com.sisga.web.cotizaciones.modelo.Cotizacion;
import com.sisga.web.cotizaciones.repositorio.CotizacionesRepositorio;

@Service
public class CotizacionesServicioImplementacion implements CotizacionesServicio {
	
	@Autowired
	private CotizacionesRepositorio cotizacionesRepositorio;

	@Autowired
	public CotizacionesServicioImplementacion(CotizacionesRepositorio cotizacionesRepositorio) {
		this.cotizacionesRepositorio = cotizacionesRepositorio;
	}

	@Override
	public List<Cotizacion> listarCotizaciones() {
		return cotizacionesRepositorio.findAll();
	}

	@Override
	public Cotizacion guardar(CotizacionesRegistroDTO cotizacionesRegistroDTO) {
		Cotizacion cotizacion = new Cotizacion(
				cotizacionesRegistroDTO.getNumeroDeDocumentoCliente(),
				cotizacionesRegistroDTO.getNombreCompletoCliente(),
				cotizacionesRegistroDTO.getProductos(),
				cotizacionesRegistroDTO.getValorTotal(),
				cotizacionesRegistroDTO.getFechaEvento(),
				cotizacionesRegistroDTO.getCantidadComensales());
		return cotizacionesRepositorio.save(cotizacion);
	}

//	@Override
//	public boolean existeCotizacion(String numeroIDCliente) {
//	    Cliente cliente = clientesRepositorio.findByNumeroIDCliente(numeroIDCliente);
//	    return cliente != null;
//	}


//	@Override
//	public Cliente obtenerClientePorId(Long id) {
//        return clientesRepositorio.findById(id).orElse(null);
//    }

	@Override
    public void guardarCotizacion(CotizacionesRegistroDTO cotizacionData) {
		cotizacionesRepositorio.save(cotizacionData);
    }

	@Override
    public void deleteById(Long id) {
		cotizacionesRepositorio.deleteById(id);
    }

	@Override
	public long cantidadDeRegistros() {
	  long cantidadRegistros = cotizacionesRepositorio.count();
	  return cantidadRegistros;
	}


}

