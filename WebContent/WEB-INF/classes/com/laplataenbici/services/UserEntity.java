package com.laplataenbici.services;

public class UserEntity {
	private String username;
	private String password;
	private Roles role;
	
	public UserEntity(String user,String pass){
		this.username = user;
		this.password = pass;
		this.role = Roles.USER;
	}
	
	public UserEntity(String user,String pass,Roles role){
		this.username = user;
		this.password = pass;
		this.role = role;
	}
	
	
	
	public boolean matches(String user, String pass){
		return this.username.equals(user) && this.password.equals(pass);
	}
	
	public boolean matches(String user){
		return this.username.equals(user);
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public boolean isAdmin(){
		return this.role.equals(Roles.ADMIN);
	}
	
	public enum Roles{
		ADMIN,USER;
	}

}
