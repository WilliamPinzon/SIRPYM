
package com.sisga.web.materiaprima.modelo;

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
@Table(name = "MATERIAS_PRIMAS_REGISTRO_SEMANAL", uniqueConstraints = @UniqueConstraint(columnNames = "ID_REGISTRO"))
public class RegistrosSemanales {

	@Id
	@Column(name = "ID_REGISTRO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "FECHA_REGISTRO_SEMANAL", nullable = false)
	private LocalDate fechaRegistroSemanal;
	
	@Column(name = "ANHO", nullable = false)
	private String anho;
	
	@Column(name = "MES", nullable = false)
	private String mes;
	
	@Column(name = "SEMANA", nullable = false)
	private String semana;

	@Column(name = "NOMBRE_ITEM", nullable = false)
	private String nombreItem;

	@Column(name = "UNIDAD", nullable = false)
	private String unidad;

	@Column(name = "DISPONIBLES", nullable = false)
	private double disponibles;

	@Column(name = "PRODUCIDOS", nullable = false)
	private double producidos;

	@Column(name = "STOCK_ACTUAL", nullable = false)
	private double stockActual;
	
	@Column(name = "VENTA_TOTAL", nullable = false)
	private double ventaTotal;

	@Column(name = "FECHA_DE_REGISTRO")
	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	@Column(name = "FECHA_DE_MODIFICACION")
	private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public RegistrosSemanales(Long id, LocalDate fechaRegistroSemanal, String anho, String mes, String semana, String nombreItem, String unidad, double disponibles, double producidos,
			double stockActual, double ventaTotal, LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
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

	public RegistrosSemanales(LocalDate fechaRegistroSemanal, String anho, String mes, String semana, String nombreItem, String unidad, double disponibles, double producidos,
			double stockActual, double ventaTotal) {
		super();
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
	}

	public RegistrosSemanales() {
		super();
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

	public void setStockActual(double stockActual) {
		this.stockActual = stockActual;
	}

	public double getVentaTotal() {
		return ventaTotal;
	}

	public void setVentaTotal(double ventaTotal) {
		this.ventaTotal = ventaTotal;
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
