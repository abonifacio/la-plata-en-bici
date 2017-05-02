package com.laplataenbici.model.repository.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public abstract class FindOneHelper<T> extends QueryWrapper<Optional<T>>{

	
	
	@Override
	protected Optional<T> onFail() {
		return Optional.empty();
	}

	@Override
	protected Optional<T> onResultSet(ResultSet rs) {
		try{
			if(rs.first()){
				return Optional.ofNullable(this.map(rs));
			}else{
				throw new Exception();
			}
		}catch(Exception e){			
			return Optional.empty();
		}
	}

	@Override
	protected abstract PreparedStatement prepare(Connection db) throws SQLException;
	
	protected abstract T map(ResultSet rs) throws SQLException;
	
}
