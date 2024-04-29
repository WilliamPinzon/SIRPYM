
package com.sisga.web.materiaprima.modelo;

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
@Table(name = "MATERIAS_PRIMAS_PRODUCTOS", uniqueConstraints = @UniqueConstraint(columnNames = "ID_PRODUCTO"))
public class Productos {
	
    @Id
    @Column(name = "ID_PRODUCTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "NOMBRE_ITEM", nullable = false)
	private String nombreItem;
	
    @Column(name = "UNIDAD", nullable = false)
	private String unidad;
	
	@Column(name = "FECHA_DE_REGISTRO")
    private LocalDateTime fechaDeRegistro= LocalDateTime.now();
	
	@Column(name = "FECHA_DE_MODIFICACION")
    private LocalDateTime fechaDeModificacion= LocalDateTime.now();

	public Productos(Long id, String nombreItem, String unidad, LocalDateTime fechaDeRegistro,
			LocalDateTime fechaDeModificacion) {
		super();
		this.id = id;
		this.nombreItem = nombreItem;
		this.unidad = unidad;
		this.fechaDeRegistro = fechaDeRegistro;
		this.fechaDeModificacion = fechaDeModificacion;
	}

	public Productos(String nombreItem, String unidad) {
		super();
		this.nombreItem = nombreItem;
		this.unidad = unidad;
	}

	public Productos() {
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

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
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
