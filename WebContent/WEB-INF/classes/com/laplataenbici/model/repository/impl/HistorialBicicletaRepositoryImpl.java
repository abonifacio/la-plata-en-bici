package com.laplataenbici.model.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.HistorialBicicleta;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.HistorialBicicletaRepository;
import com.laplataenbici.model.repository.utils.FindAllHelper;

public class HistorialBicicletaRepositoryImpl extends EntityRepositoryImpl<HistorialBicicleta> implements HistorialBicicletaRepository{

	@Override
	public Page<HistorialBicicleta> findAllFor(Pageable p, Bicicleta b) throws DBException {
		FindAllHelper<HistorialBicicleta> fh = new FindAllHelper<HistorialBicicleta>(tabla, allowedFields) {

			@Override
			protected List<HistorialBicicleta> afterResult(List<HistorialBicicleta> list) {
				return list;
			}

			
		};
		Map<String,Object> params = new HashMap<>();
		params.put("bici", b);
		return fh.go(p, "bicicleta = :bici", params);

	}

}
