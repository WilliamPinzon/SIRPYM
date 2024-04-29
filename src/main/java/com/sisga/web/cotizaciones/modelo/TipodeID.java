package com.sisga.web.modelo;

public enum TipodeID {
	CEDULA("Cedula Persona Natural"),
    NIT("NIT Persona Juridica");

    private String nombre;

    TipodeID(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
