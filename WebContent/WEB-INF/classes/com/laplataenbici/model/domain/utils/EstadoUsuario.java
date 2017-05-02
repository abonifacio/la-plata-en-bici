package com.laplataenbici.model.domain.utils;

public enum EstadoUsuario {
	
	HABILITADO("Habilitado"),SUSPENDIO("Inhabilitado temporalmente"),BANEADO("Inhabilitado definitivamente");
	
	private final String value;
	
	
	EstadoUsuario(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
