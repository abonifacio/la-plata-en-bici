package com.laplataenbici.model.repository.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;

public interface IEntityRepository<T> {
	
	public String getTableName();
	
	public T mapFromRS(ResultSet rs) throws SQLException;
	
	public Optional<T> findOneById(Long id);
	
	public Page<T> findAll(Pageable page);
	
	
}
