package com.sisga.web.nomina.controlador.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NominaHorasExtraRegistroDTO {
	
	private Long id;

	private String nombreCompleto;

	private LocalDate fechaDeRegistroNomina;
	
	private String horaDeIngreso;
	
	private String horaDeSalida;
	
	private String totalHoraExtra;

	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public NominaHorasExtraRegistroDTO() {
		super();
	}

	public NominaHorasExtraRegistroDTO(Long id, String nombreCompleto, LocalDate fechaDeRegistroNomina,
			String horaDeIngreso, String horaDeSalida, String totalHoraExtra, LocalDateTime fechaDeRegistro,
			LocalDateTime fechaDeModificacion) {
		super();
		this.id = id;
		this.nombreCompleto = nombreCompleto;
		this.fechaDeRegistroNomina = fechaDeRegistroNomina;
		this.horaDeIngreso = horaDeIngreso;
		this.horaDeSalida = horaDeSalida;
		this.totalHoraExtra = totalHoraExtra;
		this.fechaDeRegistro = fechaDeRegistro;
		this.fechaDeModificacion = fechaDeModificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public LocalDate getFechaDeRegistroNomina() {
		return fechaDeRegistroNomina;
	}

	public void setFechaDeRegistroNomina(LocalDate fechaNomina) {
		this.fechaDeRegistroNomina = fechaNomina;
	}

	public String getHoraDeIngreso() {
		return horaDeIngreso;
	}

	public void setHoraDeIngreso(String horaDeIngreso) {
		this.horaDeIngreso = horaDeIngreso;
	}

	public String getHoraDeSalida() {
		return horaDeSalida;
	}

	public void setHoraDeSalida(String horaDeSalida) {
		this.horaDeSalida = horaDeSalida;
	}

	public String getTotalHoraExtra() {
		return totalHoraExtra;
	}

	public void setTotalHoraExtra(String totalHoraExtra) {
		this.totalHoraExtra = totalHoraExtra;
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
