package com.sisga.web.materiaprima.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sisga.web.cotizaciones.servicio.ClientesServicio;
import com.sisga.web.materiaprima.servicio.ProductosMateriaPrimaServicio;

@Controller
public class ProductosMateriaPrimaControlador {

	@Autowired
	private ProductosMateriaPrimaServicio productosMateriaPrimaServicio;
	
	@GetMapping("ProductosRegistradosMateriaPrima")
	public String verRegistrosDeProductosMateriaPrima(Model modelo) {
		modelo.addAttribute("Productos", productosMateriaPrimaServicio.listarProductos());
		modelo.addAttribute("maxIndice", productosMateriaPrimaServicio.cantidadDeRegistros());
		return "/MateriaPrima/ProductosRegistradosMateriaPrima";
	}
	
	@GetMapping("ConfiguracionDeProductosMateriaPrima")
	public String verConfiguracionDeProductosMateriaPrima(Model modelo) {
		modelo.addAttribute("Productos", productosMateriaPrimaServicio.listarProductos());
		modelo.addAttribute("maxIndice", productosMateriaPrimaServicio.cantidadDeRegistros());
		return "/MateriaPrima/ConfiguracionDeProductosMateriaPrima";
	}
	
}
