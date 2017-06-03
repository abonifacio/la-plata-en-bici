package com.laplataenbici.model.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.laplataenbici.model.domain.tracking.TrackingUsuario;
import com.laplataenbici.model.domain.utils.EstadoUsuario;
import com.laplataenbici.model.domain.utils.Rol;
import com.laplataenbici.model.domain.utils.Sexo;

@Entity
@Table(name="Usuario")
public class Usuario extends AbstractTrackable<TrackingUsuario> {
	
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
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="localidad_id")
	private Localidad localidad; 
	
	@Column(name="fecha_nac")
	private Date fechaNacimiento;
	
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
	
	@OneToOne(mappedBy="usuario")
	private Bicicleta bicicleta;


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
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
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
	public Bicicleta getBicicleta() {
		return bicicleta;
	}
	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}

	
	@Override
	public String toString(){
		return "{ id: "+this.id+", nombre: "+this.nombre+", apellido: "+this.apellido+", estado: "+this.estado.getValue()+" }";
	}
	
	
	
	
	
}
