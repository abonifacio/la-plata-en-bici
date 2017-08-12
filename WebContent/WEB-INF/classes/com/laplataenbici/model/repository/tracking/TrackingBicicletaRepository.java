package com.laplataenbici.model.repository.tracking;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.tracking.TrackingBicicleta;
import com.laplataenbici.model.domain.utils.Page;

public interface TrackingBicicletaRepository extends TrackingRepository<TrackingBicicleta> {
	Page<Bicicleta> alquiladasPor(Usuario u);
}
