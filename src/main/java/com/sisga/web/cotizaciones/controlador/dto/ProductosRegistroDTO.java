package com.sisga.web.cotizaciones.controlador.dto;

import java.time.LocalDateTime;

public class ProductosRegistroDTO {

private Long id;
	
	private String nombreItem;
	
	private String valorUnitario;
	
	private String impoconsumo;
	
	private String valorBase;
	
	private String descripcion;
	
    private LocalDateTime fechaDeRegistro = LocalDateTime.now();
    
    private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public ProductosRegistroDTO() {
		super();
	}

	public ProductosRegistroDTO(Long id, String nombreItem, String valorUnitario, String impoconsumo,
			String valorBase, String descripcion, LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
		super();
		this.id = id;
		this.nombreItem = nombreItem;
		this.valorUnitario = valorUnitario;
		this.impoconsumo = impoconsumo;
		this.valorBase = valorBase;
		this.descripcion = descripcion;
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

	public String getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getImpoconsumo() {
		return impoconsumo;
	}

	public void setImpoconsumo(String impoconsumo) {
		this.impoconsumo = impoconsumo;
	}

	public String getValorBase() {
		return valorBase;
	}

	public void setValorBase(String valorBase) {
		this.valorBase = valorBase;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
