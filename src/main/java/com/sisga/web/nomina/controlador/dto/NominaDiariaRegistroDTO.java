package com.sisga.web.nomina.controlador.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NominaDiariaRegistroDTO {
	
	private Long id;
	
	private LocalDate fechaDeRegistroNomina;

	private String nombreCompleto;

	private String cargo;
	
	private float diaLaborado;
	
	private float valorACancelar;

	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public NominaDiariaRegistroDTO() {
		super();
	}

	public NominaDiariaRegistroDTO(Long id, LocalDate fechaDeRegistroNomina, String nombreCompleto, String cargo, float diaLaborado, float valorACancelar,
			LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
		this.id = id;
		this.fechaDeRegistroNomina = fechaDeRegistroNomina;
		this.nombreCompleto = nombreCompleto;
		this.cargo = cargo;
		this.diaLaborado = diaLaborado;
		this.valorACancelar = valorACancelar;
		this.fechaDeRegistro = fechaDeRegistro;
		this.fechaDeModificacion = fechaDeModificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaDeRegistroNomina() {
		return fechaDeRegistroNomina;
	}

	public void setFechaDeRegistroNomina(LocalDate fechaDeRegistroNomina) {
		this.fechaDeRegistroNomina = fechaDeRegistroNomina;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public float getDiaLaborado() {
		return diaLaborado;
	}

	public void setDiaLaborado(float diaLaborado) {
		this.diaLaborado = diaLaborado;
	}

	public float getValorACancelar() {
		return valorACancelar;
	}

	public void setValorACancelar(float valorACancelar) {
		this.valorACancelar = valorACancelar;
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
