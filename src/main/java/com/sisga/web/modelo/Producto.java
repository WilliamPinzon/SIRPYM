
package com.sisga.web.modelo;

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
@Table(name = "productosCotizaciones", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombreProducto;
	
	private String precioProducto;
	
	private String incProducto;
	
	private String baseProducto;
	
	private String descripcionProducto;
	
	@Column(name = "fecha_de_registro")
    private LocalDateTime fechaDeRegistro= LocalDateTime.now();
	
	@Column(name = "fecha_de_modificacion")
    private LocalDateTime fechaDeModificacion= LocalDateTime.now();

	public Producto(Long id, String nombreProducto, String precioProducto, String incProducto, String baseProducto,
			String descripcionProducto, LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.incProducto = incProducto;
		this.baseProducto = baseProducto;
		this.descripcionProducto = descripcionProducto;
		this.fechaDeRegistro = fechaDeRegistro;
		this.fechaDeModificacion = fechaDeModificacion;
	}

	public Producto(String nombreProducto, String precioProducto, String incProducto, String baseProducto,
			String descripcionProducto) {
		super();
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.incProducto = incProducto;
		this.baseProducto = baseProducto;
		this.descripcionProducto = descripcionProducto;
	}

	public Producto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(String precioProducto) {
		this.precioProducto = precioProducto;
	}

	public String getIncProducto() {
	    if (incProducto != null) {
	        if (incProducto.length() < 2) {
	            return incProducto.substring(0, Math.min(2, incProducto.length()));
	        } else if (incProducto.length() >= 2) {
	            return incProducto.substring(0, Math.min(4, incProducto.length()));
	        }
	    }
	    return incProducto;
	}


	public void setIncProducto(String incProducto) {
		this.incProducto = incProducto;
	}

	public String getBaseProducto() {
	    return baseProducto;
	}

	public void setBaseProducto(String baseProducto) {
		this.baseProducto = baseProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
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
