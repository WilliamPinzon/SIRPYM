package com.sisga.web.cotizaciones.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "COTIZACIONES_CLIENTES", uniqueConstraints = @UniqueConstraint(columnNames = "ID_CLIENTE"))
public class Cliente {

	@Id
	@Column(name = "ID_CLIENTE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NOMBRE_COMPLETO", nullable = false)
	private String nombreCompleto;

	@Enumerated(EnumType.STRING)
	private TipodeID tipoDeDocumento;

	@Column(name = "NUMERO_DE_DOCUMENTO", nullable = false)
	private String numeroDeDocumento;

	@Column(name = "CORREO_ELECTORNICO", nullable = false)
	private String correoElectronico;

	@Column(name = "NUMERO_DE_CONTACTO", nullable = false)
	private String numeroDeContacto;

	@Column(name = "DIRECCION", nullable = false)
	private String direccion;

	@Column(name = "INFORMACION_ADICIONAL", nullable = false)
	private String informacionAdicional;

	@Column(name = "FECHA_DE_REGISTRO")
	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	@Column(name = "FECHA_DE_MODIFICACION")
	private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public Cliente() {
		super();
	}

	public Cliente(Long id, String nombreCompleto, TipodeID tipoDeDocumento, String numeroDeDocumento,
			String correoElectronico, String numeroDeContacto, String direccion, String informacionAdicional,
			LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
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

	public Cliente(String nombreCompleto, TipodeID tipoDeDocumento, String numeroDeDocumento, String correoElectronico,
			String numeroDeContacto, String direccion, String informacionAdicional) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.tipoDeDocumento = tipoDeDocumento;
		this.numeroDeDocumento = numeroDeDocumento;
		this.correoElectronico = correoElectronico;
		this.numeroDeContacto = numeroDeContacto;
		this.direccion = direccion;
		this.informacionAdicional = informacionAdicional;
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

	@PreUpdate
	public void beforeUpdate() {
		fechaDeModificacion = LocalDateTime.now();
	}

}
