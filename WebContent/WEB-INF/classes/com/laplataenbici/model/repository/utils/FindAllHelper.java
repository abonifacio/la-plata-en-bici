package com.laplataenbici.model.repository.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laplataenbici.model.domain.utils.Page;

public abstract class FindAllHelper<T> extends QueryWrapper<Page<T>> {

	@Override
	protected Page<T> onResultSet(ResultSet rs) {
		try{
			Page<T> p = new Page<T>();
			List<T> tmp = new ArrayList<T>();
			while(rs.next()){
				tmp.add(this.map(rs));
			}
			p.setCurrent(0);
			p.setItems(tmp);
			p.setPages(10);
			p.setSize(120);
			
			return p;
		}catch(Exception e){			
			return this.onFail();
		}
	}

	@Override
	protected Page<T> onFail() {
		return new Page<T>(null);
	}

	@Override
	protected abstract PreparedStatement prepare(Connection db) throws SQLException;
	
	protected abstract T map(ResultSet rs) throws SQLException;

}
