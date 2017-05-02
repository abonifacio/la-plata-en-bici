package com.laplataenbici.model.repository.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class QueryWrapper<T> {
	
	private Connection db;
	protected ResultSet rs;


	
	private boolean connect(){		
		try{
			db = DBHelper.getConntecion();
			PreparedStatement ps = this.prepare(db);
			rs = ps.executeQuery();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean disconnect(){
		try {
			db.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	protected abstract T onResultSet(ResultSet rs);
	protected abstract T onFail();
	protected abstract PreparedStatement prepare(Connection db) throws SQLException;
	
	public T run(){
		
		if(this.connect()){
			try{
				return this.onResultSet(rs);
			}finally{				
				this.disconnect();
			}
		}else{
			return this.onFail();
		}
	}
	
}
