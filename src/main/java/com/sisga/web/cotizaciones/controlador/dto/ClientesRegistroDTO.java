package com.sisga.web.cotizaciones.controlador.dto;

import java.time.LocalDateTime;

import com.sisga.web.cotizaciones.modelo.TipodeID;

public class ClientesRegistroDTO {

	private Long id;

	private String nombreCompleto;

	private TipodeID tipoDeDocumento;

	private String numeroDeDocumento;

	private String correoElectronico;

	private String numeroDeContacto;

	private String direccion;

	private String informacionAdicional;

	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public ClientesRegistroDTO() {
		super();
	}

	public ClientesRegistroDTO(Long id, String nombreCompleto, TipodeID tipoDeDocumento, String numeroDeDocumento,
			String correoElectronico, String numeroDeContacto, String direccion,
			String informacionAdicional, LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
		super();
		this.id = id;
		this.nombreCompleto = nombreCompleto;
		this.tipoDeDocumento = tipoDeDocumento;
		this.numeroDeDocumento = numeroDeDocumento;
		this.correoElectronico = correoElectronico;
		this.numeroDeContacto = numeroDeContacto;
		this.direccion = direccion;
		this.informacionAdicional = informacionAdicional;
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

	public String getInformacionAdicional() {
		return informacionAdicional;
	}

	public void setInformacionAdicional(String informacionAdicional) {
		this.informacionAdicional = informacionAdicional;
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
