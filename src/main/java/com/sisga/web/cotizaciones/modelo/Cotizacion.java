
package com.sisga.web.cotizaciones.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "COTIZACIONES_REGISTROS", uniqueConstraints = @UniqueConstraint(columnNames = "ID_COTIZACION"))
public class Cotizacion {
	
	@Id
	@Column(name = "ID_COTIZACION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NUMERO_DE_DOCUMENTO_DEL_CLIENTE", nullable = false)
	private String numeroDeDocumentoCliente;

	@Column(name = "NOMBRE_DEL_CLIENTE", nullable = false)
	private String nombreCompletoCliente;
	
	@Lob
	@Column(name = "PRODUCTOS", columnDefinition = "TEXT", nullable = false)
	private String productos;
	
	@Column(name = "VALOR_TOTAL", nullable = false)
	private String valorTotal;
	
	@Column(name = "FECHA_DEL_EVENTO")
	private String fechaEvento;
	
	@Column(name = "COMENSALES", nullable = false)
	private String cantidadComensales;

	@Column(name = "FECHA_DE_REGISTRO")
	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	@Column(name = "FECHA_DE_MODIFICACION")
	private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public Cotizacion() {
		super();
	}

	public Cotizacion(Long id, String numeroDeDocumentoCliente, String nombreCompletoCliente,
			String productos, String valorTotal, String fechaEvento, String cantidadComensales, LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
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

	public Cotizacion(String numeroDeDocumentoCliente, String nombreCompletoCliente,
			String productos, String valorTotal, String fechaEvento, String cantidadComensales) {
		super();
		this.numeroDeDocumentoCliente = numeroDeDocumentoCliente;
		this.nombreCompletoCliente = nombreCompletoCliente;
		this.productos = productos;
		this.valorTotal = valorTotal;
		this.fechaEvento = fechaEvento;
		this.cantidadComensales = cantidadComensales;
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
