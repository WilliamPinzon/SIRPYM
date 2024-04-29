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
public class RegistroSemanalControlador {

	@Autowired
	private ProductosMateriaPrimaServicio productosMateriaPrimaServicio;
	
	@Autowired
	private RegistroSemanalServicio registroSemanalServicio;
	
	@Autowired
	private NominaDiariaServicio nominaDiariaServicio;
	
	@Autowired
	private RegistrosSemanalesRepositorio registrosSemanalesRepositorio;
	
	@GetMapping("RegistroSemanal")
	public String verNominaHorasExtra(Model modelo) {
	    List<Productos> productos = productosMateriaPrimaServicio.listarProductos();
	    
	    modelo.addAttribute("Productos", productos);
	    return "/MateriaPrima/RegistroSemanal";
	}
	
	@GetMapping("/verSemanaRegistroSemanal")
	public ResponseEntity<List<RegistrosSemanalesRegistroDTO>> verNominaHorasExtra(@RequestParam("año") int año, @RequestParam("semana") int semana) {
	    List<RegistrosSemanalesRegistroDTO> registrosSemanales = registroSemanalServicio.listarRegistrosSemanalesPorSemana(año, semana);
	   	
	    // Iterar sobre la lista de registrosSemanales
//		for (RegistrosSemanalesRegistroDTO registro : registrosSemanales) {
//		    // Aquí puedes acceder a las propiedades de cada objeto RegistrosSemanalesRegistroDTO
//		    System.out.println("Nombre del ítem: " + registro.getNombreItem());
//		    System.out.println("Unidad: " + registro.getUnidad());
//		    System.out.println("Disponibles: " + registro.getDisponibles());
//		    System.out.println("Producidos: " + registro.getProducidos());
//		    System.out.println("Stock Actual: " + registro.getStockActual());
//		}
	    return new ResponseEntity<>(registrosSemanales, HttpStatus.OK);
	}

	
//	@GetMapping("/obtenerValorTotal")
//	@ResponseBody
//	public ResponseEntity<String> obtenerValorTotalPorTipoDeCargo(@RequestParam("tipoDeCargo") String tipoDeCargo) {
//	    Cargo cargo = cargosServicio.obtenerValorTotalPorTipoDeCargo(tipoDeCargo);
//	    if (cargo != null) {
//	        return ResponseEntity.ok(cargo.getValorTotal());
//	    } else {
//	        return ResponseEntity.notFound().build();
//	    }
//	}

	@GetMapping("RegistrosSemanalesGuardados")
	public String verNominaDiariaRegistradas(Model modelo) {
//		modelo.addAttribute("nominaDiaria", productosMateriaPrimaServicio.listarProductos());
//		modelo.addAttribute("maxIndice", nominaDiariaServicio.cantidadDeRegistros());
		return "/MateriaPrima/RegistrosSemanalesGuardados";
	}
	
	@GetMapping("EditarRegistrosSemanalesGuardados")
	public String verConfiguracionNominaDiaria(Model modelo) {
//		modelo.addAttribute("nominaDiaria", nominaDiariaServicio.listarNominaDiaria());
//		modelo.addAttribute("maxIndice", nominaDiariaServicio.cantidadDeRegistros());
		return "/MateriaPrima/EditarRegistrosSemanalesGuardados";
	}
	
	@PostMapping("/eliminarRegistroSemanal")
	public String eliminarClientePorId(@RequestParam Long id) {
		registroSemanalServicio.deleteById(id);
		return "redirect:/EditarRegistrosSemanalesGuardados?delete";
	}
	
	@PostMapping("/editarRegistroSemanal")
	public String editarCliente(@RequestParam("id") String idStr, 
	                            @RequestParam("disponibles") String disponiblesStr,
	                            @RequestParam("producidos") String producidosStr,
	                            @RequestParam("stockActual") String stockActualStr,
	                            @RequestParam("ventaTotal") String ventaTotalStr,
	                            RegistrosSemanalesRegistroDTO registrosSemanalesRegistroDTO) {
		
		System.out.println("Producidos " + producidosStr);
		System.out.println("id " + idStr);
	    try {
	        Long id = Long.parseLong(idStr);
	        RegistrosSemanales registrosSemanales = registrosSemanalesRepositorio.findById(id).orElse(null);
	        
	        LocalDate fechaRegistroSemanal = registrosSemanales.getFechaRegistroSemanal();
	        String nombreItem = registrosSemanales.getNombreItem();
	        String unidad = registrosSemanales.getUnidad();
	        
	        double disponibles = Double.parseDouble(disponiblesStr);
	        double producidos = Double.parseDouble(producidosStr);
	        double stockActual = Double.parseDouble(stockActualStr);
	        double ventaTotal = Double.parseDouble(ventaTotalStr);
	        
	        System.out.println("id " + idStr);

	        if (registrosSemanales != null) {
	            registrosSemanales.setFechaRegistroSemanal(fechaRegistroSemanal);
	            registrosSemanales.setNombreItem(nombreItem);
	            registrosSemanales.setUnidad(unidad);
	            registrosSemanales.setDisponibles(disponibles);
	            registrosSemanales.setProducidos(producidos);
	            registrosSemanales.setStockActual(stockActual);
	            registrosSemanales.setVentaTotal(ventaTotal);
	            registrosSemanalesRepositorio.save(registrosSemanales);
	            return "redirect:/EditarRegistrosSemanalesGuardados?exito";
	        } else {
	            return "Cliente no encontrado";
	        }
	    } catch (NumberFormatException e) {
	        return "redirect:/EditarRegistrosSemanalesGuardados?exito";
	    } catch (Exception e) {
	        return "Error al actualizar el Cliente";
	    }
	}

	
}
