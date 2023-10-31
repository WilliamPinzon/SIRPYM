package com.sisga.web.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisga.web.controlador.dto.ProductosRegistroDTO;
import com.sisga.web.servicio.ProductosServicio;

@Controller
@RequestMapping("/RegistroDeProductos")
public class RegistroProductoControlador {
	
	private ProductosServicio productosServicio;
	
	public RegistroProductoControlador(ProductosServicio productosServicio) {
		super();
		this.productosServicio = productosServicio;
	}
	
	@ModelAttribute("producto")
	public ProductosRegistroDTO retornarNuevoProductoRegistroDTO() {
		return new ProductosRegistroDTO();
	}
	
	@GetMapping
	public String mostrarFormularioDeRegistroProducto() {
		return "RegistroDeProductos";
	}
	
	@PostMapping
	public String registrarProducto(@ModelAttribute("producto") ProductosRegistroDTO productosRegistroDTO, Model modelo) {
		productosServicio.guardar(productosRegistroDTO);
	    return "redirect:/RegistroDeProductos?exito";
	}
}
