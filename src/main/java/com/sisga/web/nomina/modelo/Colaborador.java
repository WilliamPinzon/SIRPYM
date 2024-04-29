package com.sisga.web.nomina.modelo;

import java.time.LocalDateTime;

import com.sisga.web.cotizaciones.modelo.TipodeID;

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
@Table(name = "NOMINA_COLABORADORES", uniqueConstraints = @UniqueConstraint(columnNames = "ID_COLABORADOR"))
public class Colaborador {
	
	@Id
	@Column(name = "ID_COLABORADOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NOMBRE_COMPLETO", nullable = false)
	private String nombreCompleto;

	@Column(name = "TIPO_DE_DOCUMENTO", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipodeID tipoDeDocumento;

	@Column(name = "NUMERO_DE_DOCUMENTO", nullable = false)
	private String numeroDeDocumento;
	
	@Column(name = "TIPO_DE_CONTRATO", nullable = false)
	private String tipoDeContrato;
	
	@Column(name = "CARGO", nullable = false)
	private String tipoDeCargo;

	@Column(name = "CORREO_ELECTORNICO", nullable = false)
	private String correoElectronico;

	@Column(name = "NUMERO_DE_CONTACTO", nullable = false)
	private String numeroDeContacto;
	
	@Column(name = "DIRECCION", nullable = false)
	private String direccion;
	
	@Column(name = "FECHA_DE_INGRESO", nullable = false)
	private String fechaDeIngreso;
	
	@Column(name = "HORAS_EXTRA", nullable = false)
	private boolean horasExtra;
	
	@Column(name = "FECHA_DE_REGISTRO")
	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	@Column(name = "FECHA_DE_MODIFICACION")
	private LocalDateTime fechaDeModificacion = LocalDateTime.now();
	
	public Colaborador() {
		super();
	}

	public Colaborador(Long id, String nombreCompleto, TipodeID tipoDeDocumento, String numeroDeDocumento, String tipoDeContrato, String tipoDeCargo,
			String correoElectronico, String numeroDeContacto, String direccion, String fechaDeIngreso, boolean horasExtra,
			LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
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
	
	public Colaborador(String nombreCompleto, TipodeID tipoDeDocumento, String numeroDeDocumento, String tipoDeContrato, String tipoDeCargo,
			String correoElectronico, String numeroDeContacto, String direccion, String fechaDeIngreso, boolean horasExtra) {
		super();
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

	public boolean isHorasExtra() {
		return horasExtra;
	}

	public void setHorasExtra(boolean horasExtra) {
		this.horasExtra = horasExtra;
	}

	public void setFechaDeIngreso(String fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
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
