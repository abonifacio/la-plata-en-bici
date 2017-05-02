package com.laplataenbici.model.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.utils.EstadoBicicleta;
import com.laplataenbici.model.repository.interfaces.IBicicletaRepository;

public class BicicletaRepository extends EntityRepository<Bicicleta> implements IBicicletaRepository{



	@Override
	public String getTableName() {
		return "bicicleta";
	}

	
	@Override
	public Bicicleta mapFromRS(ResultSet rs) throws SQLException {
		Bicicleta b = new Bicicleta();
		b.setId(rs.getLong("id"));
		b.setEstado(EstadoBicicleta.valueOf(rs.getString("estado")));
		//b.setFechaDevolucion(rs.getDate("fecha_devolucion"));
		//b.setFechaIngreso(rs.getDate("fecha_ingreso"));
		Long userId = rs.getLong("usuario_id");
		//buscar usuario
		return b;
	}
	
	

}
