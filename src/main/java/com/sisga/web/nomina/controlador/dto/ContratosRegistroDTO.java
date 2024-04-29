package com.sisga.web.nomina.controlador.dto;

import java.time.LocalDateTime;

public class ContratosRegistroDTO {
	
	private Long id;

	private String tipoDeContrato;

	private String descripcion;

	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public ContratosRegistroDTO() {
		super();
	}

	public ContratosRegistroDTO(Long id, String tipoDeContrato, String descripcion, LocalDateTime fechaDeRegistro,
			LocalDateTime fechaDeModificacion) {
		super();
		this.id = id;
		this.tipoDeContrato = tipoDeContrato;
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

	public String getTipoDeContrato() {
		return tipoDeContrato;
	}

	public void setTipoDeContrato(String tipoDeContrato) {
		this.tipoDeContrato = tipoDeContrato;
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
