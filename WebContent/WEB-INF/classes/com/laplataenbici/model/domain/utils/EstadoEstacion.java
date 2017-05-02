package com.laplataenbici.model.domain.utils;

public enum EstadoEstacion {
	
	OPERATIVA("Operativa"),CERRADA("Cerrada"),CONSTRUCCION("En construcción");
	
	private final String value;
	
	
	EstadoEstacion(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
