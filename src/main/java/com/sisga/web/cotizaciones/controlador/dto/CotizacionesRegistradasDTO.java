package com.sisga.web.cotizaciones.controlador.dto;

import java.time.LocalDateTime;

public class CotizacionesRegistradasDTO {

	private Long id;

	private String numeroDeDocumentoCliente;

	private String nombreCompletoCliente;

	private String productos;
	
	private String valorTotal;
	
	private String fechaEvento;
	
	private String cantidadComensales;

	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public CotizacionesRegistradasDTO() {
		super();
	}

	public CotizacionesRegistradasDTO(Long id, String numeroDeDocumentoCliente, String nombreCompletoCliente, String productos, String valorTotal, String fechaEvento, String cantidadComensales, LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
		super();
		this.id = id;
		this.numeroDeDocumentoCliente = numeroDeDocumentoCliente;
		this.nombreCompletoCliente = nombreCompletoCliente;
		this.productos = productos;
		this.valorTotal = valorTotal;
		this.fechaEvento = fechaEvento;
		this.cantidadComensales = cantidadComensales;
		this.fechaDeRegistro = fechaDeRegistro;
		this.fechaDeModificacion = fechaDeModificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroDeDocumentoCliente() {
		return numeroDeDocumentoCliente;
	}

	public void setNumeroDeDocumentoCliente(String numeroDeDocumentoCliente) {
		this.numeroDeDocumentoCliente = numeroDeDocumentoCliente;
	}

	public String getNombreCompletoCliente() {
		return nombreCompletoCliente;
	}

	public void setNombreCompletoCliente(String nombreCompletoCliente) {
		this.nombreCompletoCliente = nombreCompletoCliente;
	}

	public String getProductos() {
		return productos;
	}

	public void setProductos(String productos) {
		this.productos = productos;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(String fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public String getCantidadComensales() {
		return cantidadComensales;
	}

	public void setCantidadComensales(String cantidadComensales) {
		this.cantidadComensales = cantidadComensales;
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
