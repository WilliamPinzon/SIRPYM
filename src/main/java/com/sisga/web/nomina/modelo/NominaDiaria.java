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
@Table(name = "NOMINA_DIARIA", uniqueConstraints = @UniqueConstraint(columnNames = "ID_NOMINA_DIARIA"))
public class NominaDiaria {
	
	@Id
	@Column(name = "ID_NOMINA_DIARIA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "FECHA_DE_REGISTRO_HORA_EXTRA", nullable = false)
	private LocalDate fechaDeRegistroNomina;

	@Column(name = "NOMBRE_COLABORADOR", nullable = false)
	private String nombreCompleto;

	@Column(name = "CARGO", nullable = false)
	private String cargo;
	
	@Column(name = "DIA_LABORADO", nullable = false)
	private float diaLaborado;
	
	@Column(name = "VALOR_A_CANCELAR", nullable = false)
	private float valorACancelar;
	
	@Column(name = "FECHA_DE_REGISTRO")
	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	@Column(name = "FECHA_DE_MODIFICACION")
	private LocalDateTime fechaDeModificacion = LocalDateTime.now();
	
	public NominaDiaria() {
		super();
	}

	public NominaDiaria(Long id, LocalDate fechaDeRegistroNomina, String nombreCompleto, String cargo, float diaLaborado, float valorACancelar,
			LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
		super();
		this.id = id;
		this.fechaDeRegistroNomina = fechaDeRegistroNomina;
		this.nombreCompleto = nombreCompleto;
		this.cargo = cargo;
		this.diaLaborado = diaLaborado;
		this.valorACancelar = valorACancelar;
		this.fechaDeRegistro = fechaDeRegistro;
		this.fechaDeModificacion = fechaDeModificacion;
	}

	public NominaDiaria(LocalDate fechaDeRegistroNomina, String nombreCompleto, String cargo, float diaLaborado, float valorACancelar) {
		super();
		this.fechaDeRegistroNomina = fechaDeRegistroNomina;
		this.nombreCompleto = nombreCompleto;
		this.cargo = cargo;
		this.diaLaborado = diaLaborado;
		this.valorACancelar = valorACancelar;
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

	@PreUpdate
	public void beforeUpdate() {
		fechaDeModificacion = LocalDateTime.now();
	}
	
	
}
