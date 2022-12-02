package com.mx.totalplay.main;

public enum Estatus {
	PRIMERA_LLAMADA("Primera_Llamada"),
	SEGUNDA_LLAMADA("Segunda_Llamada"),
	TERCERA_LLAMADA("Tercera_Llamada");
	
	private String descripcion;
	
	private Estatus(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public static Estatus getEstatus(String estatus) {
		switch(estatus) {
		case "Primera_Llamada":
			return PRIMERA_LLAMADA;
		case "Segunda_Llamada":
			return SEGUNDA_LLAMADA;
		case "Tercera_Llamada":
			return TERCERA_LLAMADA;
		default:
			return null;
		}
	}
}
