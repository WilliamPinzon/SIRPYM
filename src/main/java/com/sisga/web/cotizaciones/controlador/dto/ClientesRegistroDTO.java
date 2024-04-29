package com.sisga.web.controlador.dto;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisga.web.modelo.TipodeID;

public class ClientesRegistroDTO {

	private Long id;

	private String nombreCliente;

	private TipodeID tipoIDCliente;

	private String numeroIDCliente;

	private String correoElectronicoCliente;

	private String numeroDeContactoCliente;

	private String direccionCliente;

	private String adicionalCliente;

	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public ClientesRegistroDTO() {
		super();
	}

	public ClientesRegistroDTO(Long id, String nombreCliente, TipodeID tipoIDCliente, String numeroIDCliente,
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


}
