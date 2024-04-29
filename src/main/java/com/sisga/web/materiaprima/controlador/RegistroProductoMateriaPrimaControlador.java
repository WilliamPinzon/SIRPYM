package com.sisga.web.materiaprima.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisga.web.cotizaciones.controlador.dto.ProductosRegistroDTO;
import com.sisga.web.materiaprima.controlador.dto.ProductosMateriaPrimaRegistroDTO;
import com.sisga.web.materiaprima.servicio.ProductosMateriaPrimaServicio;

@Controller
@RequestMapping("/RegistroDeProductosMateriaPrima")
public class RegistroProductoMateriaPrimaControlador {
	
	private ProductosMateriaPrimaServicio productosMateriaPrimaServicio;
	
	public RegistroProductoMateriaPrimaControlador(ProductosMateriaPrimaServicio productosMateriaPrimaServicio) {
		super();
		this.productosMateriaPrimaServicio = productosMateriaPrimaServicio;
	}
	
	@ModelAttribute("producto")
	public ProductosMateriaPrimaRegistroDTO retornarNuevoProductoRegistroDTO() {
		return new ProductosMateriaPrimaRegistroDTO();
	}
	
	@GetMapping
	public String mostrarFormularioDeRegistroProducto() {
		return "/MateriaPrima/RegistroDeProductos";
	}
	
	@PostMapping
	public String registrarProducto(@ModelAttribute("producto") ProductosMateriaPrimaRegistroDTO productosMateriaPrimaRegistroDTO, Model modelo) {
		productosMateriaPrimaServicio.guardar(productosMateriaPrimaRegistroDTO);
	    return "redirect:/RegistroDeProductosMateriaPrima?exito";
	}
}
