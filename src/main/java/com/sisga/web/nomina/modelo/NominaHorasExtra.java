package com.sisga.web.nomina.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "NOMINA_HORAS_EXTRA", uniqueConstraints = @UniqueConstraint(columnNames = "ID_NOMINA_HORAS_EXTRA"))
public class NominaHorasExtra {
	
	@Id
	@Column(name = "ID_NOMINA_HORAS_EXTRA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NOMBRE_COLABORADOR", nullable = false)
	private String nombreCompleto;

	@Column(name = "FECHA_DE_REGISTRO_HORA_EXTRA", nullable = false)
	private LocalDate fechaDeRegistroNomina;
	
	@Column(name = "HORA_DE_INGRESO", nullable = false)
	private String horaDeIngreso;
	
	@Column(name = "HORA_DE_SALIDA", nullable = false)
	private String horaDeSalida;
	
	@Column(name = "TOTAL_HORA_EXTRA", nullable = false)
	private String totalHoraExtra;

	@Column(name = "FECHA_DE_REGISTRO")
	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	@Column(name = "FECHA_DE_MODIFICACION")
	private LocalDateTime fechaDeModificacion = LocalDateTime.now();
	
	public NominaHorasExtra() {
		super();
	}


	public NominaHorasExtra(Long id, String nombreCompleto, LocalDate fechaDeRegistroNomina, String horaDeIngreso,
			String horaDeSalida, String totalHoraExtra, LocalDateTime fechaDeRegistro,
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


	public NominaHorasExtra(String nombreCompleto, LocalDate fechaDeRegistroNomina, String horaDeIngreso,
			String horaDeSalida, String totalHoraExtra) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.fechaDeRegistroNomina = fechaDeRegistroNomina;
		this.horaDeIngreso = horaDeIngreso;
		this.horaDeSalida = horaDeSalida;
		this.totalHoraExtra = totalHoraExtra;
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


	public void setFechaDeRegistroNomina(LocalDate fechaDeRegistroNomina) {
		this.fechaDeRegistroNomina = fechaDeRegistroNomina;
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


	@PreUpdate
	public void beforeUpdate() {
		fechaDeModificacion = LocalDateTime.now();
	}
	
	
}
