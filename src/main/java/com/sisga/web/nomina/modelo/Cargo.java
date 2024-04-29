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
@Table(name = "NOMINA_CARGOS", uniqueConstraints = @UniqueConstraint(columnNames = "ID_CARGO"))
public class Cargo {

	@Id
	@Column(name = "ID_CARGO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "TIPO_DE_CARGO", nullable = false)
	private String tipoDeCargo;

	@Column(name = "VALOR_DE_TRANSPORTE", nullable = false)
	private String valorDeTransporte;

	@Column(name = "VALOR_DE_BASE", nullable = false)
	private String valorDeBase;

	@Column(name = "VALOR_TOTAL", nullable = false)
	private String valorTotal;
	
	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;

	@Column(name = "FECHA_DE_REGISTRO")
	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	@Column(name = "FECHA_DE_MODIFICACION")
	private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public Cargo() {
		super();
	}

	public Cargo(Long id, String tipoDeCargo, String valorDeTransporte, String valorDeBase,
			String valorTotal, String descripcion, LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
		super();
		this.id = id;
		this.tipoDeCargo = tipoDeCargo;
		this.valorDeTransporte = valorDeTransporte;
		this.valorDeBase = valorDeBase;
		this.valorTotal = valorTotal;
		this.descripcion = descripcion;
		this.fechaDeRegistro = fechaDeRegistro;
		this.fechaDeModificacion = fechaDeModificacion;
	}

	public Cargo(String tipoDeCargo, String valorDeTransporte, String valorDeBase,
			String valorTotal, String descripcion) {
		super();
		this.tipoDeCargo = tipoDeCargo;
		this.valorDeTransporte = valorDeTransporte;
		this.valorDeBase = valorDeBase;
		this.valorTotal = valorTotal;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoDeCargo() {
		return tipoDeCargo;
	}

	public void setTipoDeCargo(String tipoDeCargo) {
		this.tipoDeCargo = tipoDeCargo;
	}

	public String getValorDeTransporte() {
		return valorDeTransporte;
	}

	public void setValorDeTransporte(String valorDeTransporte) {
		this.valorDeTransporte = valorDeTransporte;
	}

	public String getValorDeBase() {
		return valorDeBase;
	}

	public void setValorDeBase(String valorDeBase) {
		this.valorDeBase = valorDeBase;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
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
