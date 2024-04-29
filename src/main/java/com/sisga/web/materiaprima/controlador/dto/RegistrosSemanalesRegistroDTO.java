package com.sisga.web.materiaprima.controlador.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class RegistrosSemanalesRegistroDTO {

	private Long id;
	
	private LocalDate fechaRegistroSemanal;
	
	private String anho;

	private String mes;
	
	private String semana;
	
	private String nombreItem;
	
	private String unidad;
	
	private double disponibles;
    
	private double producidos;
    
	private double stockActual;
	
	private double ventaTotal;
	
    private LocalDateTime fechaDeRegistro = LocalDateTime.now();
    
    private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public RegistrosSemanalesRegistroDTO() {
		super();
	}

	public RegistrosSemanalesRegistroDTO(Long id, LocalDate fechaRegistroSemanal, String anho, String mes, String semana, String nombreItem, String unidad, double disponibles,
			double producidos, double stockActual, double ventaTotal, LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
		super();
		this.id = id;
		this.fechaRegistroSemanal = fechaRegistroSemanal;
		this.anho = anho;
		this.mes = mes;
		this.semana = semana;
		this.nombreItem = nombreItem;
		this.unidad = unidad;
		this.disponibles = disponibles;
		this.producidos = producidos;
		this.stockActual = stockActual;
		this.ventaTotal = ventaTotal;
		this.fechaDeRegistro = fechaDeRegistro;
		this.fechaDeModificacion = fechaDeModificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaRegistroSemanal() {
		return fechaRegistroSemanal;
	}

	public void setFechaRegistroSemanal(LocalDate fechaRegistroSemanal) {
		this.fechaRegistroSemanal = fechaRegistroSemanal;
	}

	public String getAnho() {
		return anho;
	}

	public void setAnho(String anho) {
		this.anho = anho;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getSemana() {
		return semana;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

	public String getNombreItem() {
		return nombreItem;
	}

	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public double getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(double disponibles) {
		this.disponibles = disponibles;
	}

	public double getProducidos() {
		return producidos;
	}

	public void setProducidos(double producidos) {
		this.producidos = producidos;
	}

	public double getStockActual() {
		return stockActual;
	}

	public double getVentaTotal() {
		return ventaTotal;
	}

	public void setVentaTotal(double ventaTotal) {
		this.ventaTotal = ventaTotal;
	}

	public void setStockActual(double stockActual) {
		this.stockActual = stockActual;
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
