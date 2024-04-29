package com.sisga.web.nomina.controlador.dto;

import java.time.LocalDateTime;

import com.sisga.web.cotizaciones.modelo.TipodeID;

public class ColaboradoresRegistroDTO {
	
	private Long id;

	private String nombreCompleto;

	private TipodeID tipoDeDocumento;

	private String numeroDeDocumento;
	
	private String tipoDeContrato;

	private String tipoDeCargo;

	private String correoElectronico;

	private String numeroDeContacto;

	private String direccion;

	private String fechaDeIngreso;
	
	private boolean horasExtra;

	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public ColaboradoresRegistroDTO() {
		super();
	}

	public ColaboradoresRegistroDTO(Long id, String nombreCompleto, TipodeID tipoDeDocumento, String numeroDeDocumento, String tipoDeContrato,
			String tipoDeCargo, String correoElectronico, String numeroDeContacto, String direccion,
			String fechaDeIngreso, boolean horasExtra, LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
		super();
		this.id = id;
		this.nombreCompleto = nombreCompleto;
		this.tipoDeDocumento = tipoDeDocumento;
		this.numeroDeDocumento = numeroDeDocumento;
		this.tipoDeContrato = tipoDeContrato;
		this.tipoDeCargo = tipoDeCargo;
		this.correoElectronico = correoElectronico;
		this.numeroDeContacto = numeroDeContacto;
		this.direccion = direccion;
		this.fechaDeIngreso = fechaDeIngreso;
		this.horasExtra = horasExtra;
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

	public TipodeID getTipoDeDocumento() {
		return tipoDeDocumento;
	}

	public void setTipoDeDocumento(TipodeID tipoDeDocumento) {
		this.tipoDeDocumento = tipoDeDocumento;
	}

	public String getNumeroDeDocumento() {
		return numeroDeDocumento;
	}

	public void setNumeroDeDocumento(String numeroDeDocumento) {
		this.numeroDeDocumento = numeroDeDocumento;
	}

	public String getTipoDeContrato() {
		return tipoDeContrato;
	}

	public void setTipoDeContrato(String tipoDeContrato) {
		this.tipoDeContrato = tipoDeContrato;
	}

	public String getTipoDeCargo() {
		return tipoDeCargo;
	}

	public void setTipoDeCargo(String tipoDeCargo) {
		this.tipoDeCargo = tipoDeCargo;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getNumeroDeContacto() {
		return numeroDeContacto;
	}

	public void setNumeroDeContacto(String numeroDeContacto) {
		this.numeroDeContacto = numeroDeContacto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(String fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}

	public LocalDateTime getFechaDeRegistro() {
		return fechaDeRegistro;
	}

	public boolean isHorasExtra() {
		return horasExtra;
	}

	public void setHorasExtra(boolean horasExtra) {
		this.horasExtra = horasExtra;
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
