package com.sisga.web.materiaprima.controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisga.web.cotizaciones.modelo.TipodeID;
import com.sisga.web.materiaprima.controlador.dto.RegistrosSemanalesRegistroDTO;
import com.sisga.web.materiaprima.modelo.Productos;
import com.sisga.web.materiaprima.modelo.RegistrosSemanales;
import com.sisga.web.materiaprima.repositorio.RegistrosSemanalesRepositorio;
import com.sisga.web.materiaprima.servicio.ProductosMateriaPrimaServicio;
import com.sisga.web.materiaprima.servicio.RegistroSemanalServicio;
import com.sisga.web.nomina.servicio.NominaDiariaServicio;

@Controller
public class AnalisisVentasControlador {

	@Autowired
	private ProductosMateriaPrimaServicio productosMateriaPrimaServicio;
	
	@Autowired
	private RegistroSemanalServicio registroSemanalServicio;
	
	@Autowired
	private NominaDiariaServicio nominaDiariaServicio;
	
	@Autowired
	private RegistrosSemanalesRepositorio registrosSemanalesRepositorio;
	
	@GetMapping("AnalisisVentasPeriodicas")
	public String verNominaDiariaRegistradas(Model modelo) {
		return "/MateriaPrima/AnalisisVentasPeriodicas";
	}
	
//	@GetMapping("AnalisisDeVentas")
//	public String verNominaHorasExtra(Model modelo) {
//	    List<Productos> productos = productosMateriaPrimaServicio.listarProductos();
//	    modelo.addAttribute("Productos", productos);
//	    return "/MateriaPrima/RegistroSemanal";
//	}
	
	@GetMapping("/verSemanaRegistroSemanalPorMes")
	public ResponseEntity<List<RegistrosSemanalesRegistroDTO>> verNominaHorasExtra(@RequestParam("año") int año, @RequestParam("mes") int mes) {
	    List<RegistrosSemanalesRegistroDTO> registrosSemanales = registroSemanalServicio.listarRegistrosSemanalesPorMes(año, mes);
	    return new ResponseEntity<>(registrosSemanales, HttpStatus.OK);
	}
	
	@GetMapping("/verSemanaRegistroSemanalPorAnho")
	public ResponseEntity<List<RegistrosSemanalesRegistroDTO>> verNominaHorasExtra(@RequestParam("año") int año) {
	    List<RegistrosSemanalesRegistroDTO> registrosSemanales = registroSemanalServicio.listarRegistrosSemanalesPorAnho(año);
	    return new ResponseEntity<>(registrosSemanales, HttpStatus.OK);
	}

		
}
