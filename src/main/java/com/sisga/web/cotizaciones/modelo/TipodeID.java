package com.sisga.web.cotizaciones.modelo;

public enum TipodeID {
	CEDULAC("Cédula de ciudadanía"),
	CEDULAE("Cédula de extranjería"),
	PASAPORTE("Pasaporte"),
	NIT("NIT persona jurídica");
   

    private String nombre;

    TipodeID(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
