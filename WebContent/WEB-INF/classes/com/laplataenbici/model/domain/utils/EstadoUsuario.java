package com.laplataenbici.model.domain.utils;

public enum EstadoUsuario {
	
	HABILITADO("Habilitado"),SUSPENDIDO("Inhabilitado temporalmente"),BANEADO("Inhabilitado definitivamente");
	
	private final String value;
	
	
	EstadoUsuario(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
