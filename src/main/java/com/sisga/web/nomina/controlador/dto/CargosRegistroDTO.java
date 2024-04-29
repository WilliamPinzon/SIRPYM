package com.sisga.web.nomina.controlador.dto;

import java.time.LocalDateTime;

public class CargosRegistroDTO {
	private Long id;

	private String tipoDeCargo;

	private String valorDeTransporte;

	private String valorDeBase;

	private String valorTotal;
	
	private String descripcion;

	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public CargosRegistroDTO() {
		super();
	}

	public CargosRegistroDTO(Long id, String tipoDeCargo, String valorDeTransporte,
			String valorDeBase, String valorTotal, String descripcion, LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
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
}
