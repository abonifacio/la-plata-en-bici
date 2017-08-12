package com.laplataenbici.model.domain.tracking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.laplataenbici.model.domain.AbstractEntity;

@Entity
@Table(name="TrackingItem")
public class TrackingItem extends AbstractEntity{
	
	@Column
	private String atributo;
	
	@Column
	private String valor;
	
	@Column
	private String anterior;

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getAnterior() {
		return anterior;
	}

	public void setAnterior(String anterior) {
		this.anterior = anterior;
	}
	
	
}
