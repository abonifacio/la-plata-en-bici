package com.laplataenbici.services;

import com.laplataenbici.services.UserEntity.Roles;

public class AuthService {
	
	private static UserEntity[] users = { 
			(new UserEntity("augusto","bonifacio",Roles.USER)), 
			new UserEntity("admin","admin",Roles.ADMIN)
	};
	
	
	public static UserEntity getRegisteredUser(String user, String pass) throws Exception{
		for(UserEntity tmp : users){
			if(tmp.matches(user,pass)) return tmp;
		}
		throw new Exception();
	}
	
	public static UserEntity getRegisteredUser(String user) throws Exception{
		for(UserEntity tmp : users){
			if(tmp.matches(user)) return tmp;
		}
		throw new Exception();
	}
	
	
	
	

}
