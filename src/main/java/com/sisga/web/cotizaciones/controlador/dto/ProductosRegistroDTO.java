package com.sisga.web.controlador.dto;

import java.time.LocalDateTime;

public class ProductosRegistroDTO {

private Long id;
	
	private String nombreProducto;
	
	private String precioProducto;
	
	private String incProducto;
	
	private String baseProducto;
	
	private String descripcionProducto;
	
    private LocalDateTime fechaDeRegistro = LocalDateTime.now();
    
    private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public ProductosRegistroDTO() {
		super();
	}

	public ProductosRegistroDTO(Long id, String nombreProducto, String precioProducto, String incProducto,
			String baseProducto, String descripcionProducto, LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.incProducto = incProducto;
		this.baseProducto = baseProducto;
		this.descripcionProducto = descripcionProducto;
		this.fechaDeRegistro = fechaDeRegistro;
		this.fechaDeModificacion = fechaDeModificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(String precioProducto) {
		this.precioProducto = precioProducto;
	}

	public String getIncProducto() {
		return incProducto;
	}

	public void setIncProducto(String incProducto) {
		this.incProducto = incProducto;
	}

	public String getBaseProducto() {
		return baseProducto;
	}

	public void setBaseProducto(String baseProducto) {
		this.baseProducto = baseProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public LocalDateTime getFechaDeRegistro() {
		return fechaDeRegistro;
	}

	public void setFechaDeRegistro(LocalDateTime fechaDeRegistro) {
		this.fechaDeRegistro = fechaDeRegistro;
	}

	public LocalDateTime getFechaDeModificacion() {
		return fechaDeModificacion;
	}

	public void setFechaDeModificacion(LocalDateTime fechaDeModificacion) {
		this.fechaDeModificacion = fechaDeModificacion;
	}
}
