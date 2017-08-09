package com.laplataenbici.model.domain.tracking;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.laplataenbici.model.domain.Usuario;

@Entity
@Table(name="TrackingUsuario")
public class TrackingUsuario extends AbstractTracking<Usuario> {

}
