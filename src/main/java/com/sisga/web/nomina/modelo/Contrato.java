package com.sisga.web.nomina.modelo;

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
@Table(name = "NOMINA_CONTRATOS", uniqueConstraints = @UniqueConstraint(columnNames = "ID_CONTRATO"))
public class Contrato {

	@Id
	@Column(name = "ID_CONTRATO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "TIPO_DE_CONTRATO", nullable = false)
	private String tipoDeContrato;

	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;

	@Column(name = "FECHA_DE_REGISTRO")
	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	@Column(name = "FECHA_DE_MODIFICACION")
	private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public Contrato() {
		super();
	}

	public Contrato(Long id, String tipoDeContrato, String descripcion, LocalDateTime fechaDeRegistro,
			LocalDateTime fechaDeModificacion) {
		super();
		this.id = id;
		this.tipoDeContrato = tipoDeContrato;
		this.descripcion = descripcion;
		this.fechaDeRegistro = fechaDeRegistro;
		this.fechaDeModificacion = fechaDeModificacion;
	}

	public Contrato(String tipoDeContrato, String descripcion) {
		super();
		this.tipoDeContrato = tipoDeContrato;
		this.descripcion = descripcion;
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

	@PreUpdate
	public void beforeUpdate() {
		fechaDeModificacion = LocalDateTime.now();
	}

}
