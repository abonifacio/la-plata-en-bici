package com.laplataenbici.model.domain.utils;

public enum EstadoBicicleta {
	APTA("Apta para uso"),REPARACION("Cerrada"),DESUSO("En desuso"),DENUNCIADA("Denunciada");
	
	private final String value;
	
	
	EstadoBicicleta(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
