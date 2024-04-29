package com.sisga.web.materiaprima.controlador.dto;

import java.time.LocalDateTime;

public class ProductosMateriaPrimaRegistroDTO {

private Long id;
	
	private String nombreItem;
	
	private String unidad;
	
    private LocalDateTime fechaDeRegistro = LocalDateTime.now();
    
    private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public ProductosMateriaPrimaRegistroDTO() {
		super();
	}

	public ProductosMateriaPrimaRegistroDTO(Long id, String nombreItem, String unidad, LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
		super();
		this.id = id;
		this.nombreItem = nombreItem;
		this.unidad = unidad;
		this.fechaDeRegistro = fechaDeRegistro;
		this.fechaDeModificacion = fechaDeModificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreItem() {
		return nombreItem;
	}

	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
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
