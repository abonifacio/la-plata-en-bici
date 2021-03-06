package com.laplataenbici.model.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.laplataenbici.model.domain.utils.EstadoUsuario;
import com.laplataenbici.model.domain.utils.Rol;
import com.laplataenbici.model.domain.utils.Sexo;

@Entity
@Table(name="Usuario")
@JsonInclude(Include.NON_NULL)
public class Usuario extends AbstractEntity{
	
	@Column
	private Integer DNI;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column
	private String calle;
	
	@Column
	private String numero;
	
	@ManyToOne()
	@JoinColumn(name="localidad_id")
	private Localidad localidad; 
	
	@Column(name="fecha_nac")
	private Timestamp fechaNacimiento;
	
	@Column
	@Enumerated(EnumType.STRING)
	private EstadoUsuario estado;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Column
	private String email;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Rol rol;

	public Usuario(){
		super();
	}
	
	public Usuario(Long id){
		super();
		this.id = id;
	}

	public Integer getDNI() {
		return DNI;
	}
	public void setDNI(Integer dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public Timestamp getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Timestamp fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public EstadoUsuario getEstado() {
		return estado;
	}
	public void setEstado(EstadoUsuario estado) {
		this.estado = estado;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString(){
		return "{ id: "+this.id+", nombre: "+this.nombre+", apellido: "+this.apellido+", estado: "+this.estado.getValue()+" }";
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Usuario && super.equals(obj);
	}
	
	
	
}
