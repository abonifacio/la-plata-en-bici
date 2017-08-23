package com.laplataenbici.model.repository.utils;


import java.sql.Connection;
import java.sql.DriverManager;


public class DBHelper {
	
	public static Connection getConntecion() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/la_plata_en_bici","root","5642");
	}
}
