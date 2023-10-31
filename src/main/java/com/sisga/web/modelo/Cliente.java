
package com.sisga.web.modelo;

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
@Table(name = "clientesCotizaciones", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombreCliente;

	@Enumerated(EnumType.STRING)
	private TipodeID tipoIDCliente;

	private String numeroIDCliente;

	private String correoElectronicoCliente;

	private String numeroDeContactoCliente;

	private String direccionCliente;

	private String adicionalCliente;

	@Column(name = "fecha_de_registro")
	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	@Column(name = "fecha_de_modificacion")
	private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public Cliente() {
		super();
	}

	public Cliente(Long id, String nombreCliente, TipodeID tipoIDCliente, String numeroIDCliente,
			String correoElectronicoCliente, String numeroDeContactoCliente, String direccionCliente,
			String adicionalCliente, LocalDateTime fechaDeRegistro, LocalDateTime fechaDeModificacion) {
		super();
		this.id = id;
		this.nombreCliente = nombreCliente;
		this.tipoIDCliente = tipoIDCliente;
		this.numeroIDCliente = numeroIDCliente;
		this.correoElectronicoCliente = correoElectronicoCliente;
		this.numeroDeContactoCliente = numeroDeContactoCliente;
		this.direccionCliente = direccionCliente;
		this.adicionalCliente = adicionalCliente;
		this.fechaDeRegistro = fechaDeRegistro;
		this.fechaDeModificacion = fechaDeModificacion;
	}

	public Cliente(String nombreCliente, TipodeID tipoIDCliente, String numeroIDCliente,
			String correoElectronicoCliente, String numeroDeContactoCliente, String direccionCliente,
			String adicionalCliente) {
		super();
		this.nombreCliente = nombreCliente;
		this.tipoIDCliente = tipoIDCliente;
		this.numeroIDCliente = numeroIDCliente;
		this.correoElectronicoCliente = correoElectronicoCliente;
		this.numeroDeContactoCliente = numeroDeContactoCliente;
		this.direccionCliente = direccionCliente;
		this.adicionalCliente = adicionalCliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public TipodeID getTipoIDCliente() {
		return tipoIDCliente;
	}

	public void setTipoIDCliente(TipodeID tipoIDCliente) {
		this.tipoIDCliente = tipoIDCliente;
	}

	public String getNumeroIDCliente() {
		return numeroIDCliente;
	}

	public void setNumeroIDCliente(String numeroIDCliente) {
		this.numeroIDCliente = numeroIDCliente;
	}

	public String getCorreoElectronicoCliente() {
		return correoElectronicoCliente;
	}

	public void setCorreoElectronicoCliente(String correoElectronicoCliente) {
		this.correoElectronicoCliente = correoElectronicoCliente;
	}

	public String getNumeroDeContactoCliente() {
		return numeroDeContactoCliente;
	}

	public void setNumeroDeContactoCliente(String numeroDeContactoCliente) {
		this.numeroDeContactoCliente = numeroDeContactoCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getAdicionalCliente() {
		return adicionalCliente;
	}

	public void setAdicionalCliente(String adicionalCliente) {
		this.adicionalCliente = adicionalCliente;
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
