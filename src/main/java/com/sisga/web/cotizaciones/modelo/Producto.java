
package com.sisga.web.cotizaciones.modelo;

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
@Table(name = "COTIZACIONES_PRODUCTOS", uniqueConstraints = @UniqueConstraint(columnNames = "ID_PRODUCTO"))
public class Producto {
	
    @Id
    @Column(name = "ID_PRODUCTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "NOMBRE_ITEM", nullable = false)
	private String nombreItem;
	
    @Column(name = "VALOR_UNITARIO", nullable = false)
	private String valorUnitario;
	
    @Column(name = "IMPOCONSUMO", nullable = false)
	private String impoconsumo;
	
    @Column(name = "VALOR_BASE", nullable = false)
	private String valorBase;
	
    @Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "FECHA_DE_REGISTRO")
    private LocalDateTime fechaDeRegistro= LocalDateTime.now();
	
	@Column(name = "FECHA_DE_MODIFICACION")
    private LocalDateTime fechaDeModificacion= LocalDateTime.now();

	public Producto(Long id, String nombreItem, String valorUnitario, String impoconsumo, String valorBase,
			String descripcion, LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
		super();
		this.id = id;
		this.nombreItem = nombreItem;
		this.valorUnitario = valorUnitario;
		this.impoconsumo = impoconsumo;
		this.valorBase = valorBase;
		this.descripcion = descripcion;
		this.fechaDeRegistro = fechaDeRegistro;
		this.fechaDeModificacion = fechaDeModificacion;
	}

	public Producto(String nombreItem, String valorUnitario, String impoconsumo, String valorBase,
			String descripcion) {
		super();
		this.nombreItem = nombreItem;
		this.valorUnitario = valorUnitario;
		this.impoconsumo = impoconsumo;
		this.valorBase = valorBase;
		this.descripcion = descripcion;
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

	public String getNombreItem() {
		return nombreItem;
	}

	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}

	public String getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getImpoconsumo() {
	    if (impoconsumo != null) {
	        if (impoconsumo.length() < 2) {
	            return impoconsumo.substring(0, Math.min(2, impoconsumo.length()));
	        } else if (impoconsumo.length() >= 2) {
	            return impoconsumo.substring(0, Math.min(4, impoconsumo.length()));
	        }
	    }
	    return impoconsumo;
	}


	public void setImpoconsumo(String impoconsumo) {
		this.impoconsumo = impoconsumo;
	}

	public String getValorBase() {
	    return valorBase;
	}

	public void setValorBase(String valorBase) {
		this.valorBase = valorBase;
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
