package com.laplataenbici.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.interfaces.IEntityRepository;
import com.laplataenbici.model.repository.utils.FindAllHelper;
import com.laplataenbici.model.repository.utils.FindOneHelper;

public abstract class EntityRepository<T> implements IEntityRepository<T>{

	@Override
	public Optional<T> findOneById(Long id) {
		FindOneHelper<T> fh = new FindOneHelper<T>(){

			@Override
			protected PreparedStatement prepare(Connection db) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement ps = db.prepareStatement("SELECT * FROM "+getTableName()+" WHERE id = ?;");
//				ps.setString(1, getTableName());
				ps.setLong(1, id);
				return ps;
			}

			@Override
			protected T map(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				return mapFromRS(rs);
				
			}
			
			
		};
		return fh.run();
	}

	@Override
	public Page<T> findAll(Pageable page) {
		FindAllHelper<T> fh = new FindAllHelper<T>(){

			@Override
			protected PreparedStatement prepare(Connection db) throws SQLException {
				// TODO Auto-generated method stub
				int offset = (page.getPage()-1)*page.getCount();
				int limit = offset+page.getCount();
				PreparedStatement ps = db.prepareStatement("SELECT * FROM ? LIMIT ?,?;");
				ps.setString(1, getTableName());
				ps.setInt(2, offset);
				ps.setInt(3, limit);
				return ps;
			}

			@Override
			protected T map(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				return mapFromRS(rs);
				
			}
			
			
		};
		return fh.run();
	}

}
