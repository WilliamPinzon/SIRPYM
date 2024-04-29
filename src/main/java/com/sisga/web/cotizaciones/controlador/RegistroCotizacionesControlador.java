package com.sisga.web.cotizaciones.controlador;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisga.web.cotizaciones.controlador.dto.CotizacionesRegistroDTO;
import com.sisga.web.cotizaciones.modelo.Cliente;
import com.sisga.web.cotizaciones.modelo.CotizacionesRegistradas;
import com.sisga.web.cotizaciones.modelo.Producto;
import com.sisga.web.cotizaciones.servicio.ClientesServicio;
import com.sisga.web.cotizaciones.servicio.CotizacionesRegistradasServicio;
import com.sisga.web.cotizaciones.servicio.CotizacionesServicio;
import com.sisga.web.cotizaciones.servicio.ProductosServicio;

@Controller
@RequestMapping("/RegistroDeCotizaciones")
public class RegistroCotizacionesControlador {

	private ClientesServicio clientesServicio;
	private ProductosServicio productosServicio;
	private CotizacionesServicio cotizacionesServicio;
	private CotizacionesRegistradasServicio cotizacionesRegistradasServicio;

	public RegistroCotizacionesControlador(ClientesServicio clientesServicio, ProductosServicio productosServicio,
			CotizacionesServicio cotizacionesServicio, CotizacionesRegistradasServicio cotizacionesRegistradasServicio) {
		super();
		this.clientesServicio = clientesServicio;
		this.productosServicio = productosServicio;
		this.cotizacionesServicio = cotizacionesServicio;
		this.cotizacionesRegistradasServicio = cotizacionesRegistradasServicio;
	}

	@GetMapping
	public String mostrarFormularioDeRegistroCliente(Model model) throws IOException {
	    model.addAttribute("productos", productosServicio.listarProductos());
	    model.addAttribute("clientes", clientesServicio.listarClientes());
	    
	    List<CotizacionesRegistradas> cotizacion = cotizacionesRegistradasServicio.listarCotizaciones();
	    
	    if(cotizacion == null) {
	    	Long ultimoId = (long) 1;
	    	model.addAttribute("cotizaciones", ultimoId);
	    }
	    
	    if (!cotizacion.isEmpty()) {
	        Long ultimoId = cotizacion.get(cotizacion.size() - 1).getId();
	        model.addAttribute("cotizaciones", ultimoId + 1);
	    } else {
	        model.addAttribute("cotizaciones", 1L);
	    }
	    
	    return "/Cotizaciones/RegistroDeCotizaciones";
	}

	@PostMapping
	public String registraCotizacion(@ModelAttribute CotizacionesRegistroDTO cotizacionesRegistroDTO, Model modelo) {
		cotizacionesServicio.guardar(cotizacionesRegistroDTO);
		cotizacionesRegistradasServicio.guardar(cotizacionesRegistroDTO);
		return "redirect:/RegistroDeCotizaciones?save";
	}

	@GetMapping("/buscarClientePorID")
	public ResponseEntity<Cliente> obtenerClientePorDoc(@RequestParam String numeroDeDocumento) {
		Cliente cliente = clientesServicio.obtenerClientePorDoc(numeroDeDocumento);
		if (cliente != null) {
			System.out.println("Cliente id" + cliente);
			return ResponseEntity.ok(cliente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/buscarClientePorNombre")
	public ResponseEntity<Cliente> obtenerClientePorNombre(@RequestParam String nombreCompleto) {
		Cliente cliente = clientesServicio.obtenerClientePorNombre(nombreCompleto);
		if (cliente != null) {
			System.out.println("Cliente nom" + cliente.getNombreCompleto());
			return ResponseEntity.ok(cliente);
			
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/mostrarClientes")
	public String mostrarClientes(Model model) throws IOException {
		model.addAttribute("clientes", clientesServicio.listarClientes());
		return "RegistroDeCotizaciones";
	}

	@GetMapping("/buscarProducto")
	public ResponseEntity<Producto> buscarProducto(@RequestParam String nombreCompleto) {
		Producto producto = productosServicio.obtenerProducto(nombreCompleto);
		if (producto != null) {
			return ResponseEntity.ok(producto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/mostrarProductos")
	public String mostrarProductos(Model model) throws IOException {
		model.addAttribute("productos", productosServicio.listarProductos());
		return "/Cotizaciones/RegistroDeCotizaciones";
	}

}
