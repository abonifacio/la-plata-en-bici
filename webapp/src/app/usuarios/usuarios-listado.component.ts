import { Router } from '@angular/router';
import { Usuario } from '../entities/user';
import { UsuarioService } from './usuario.service';
import { Component, OnInit } from '@angular/core';
import { Column } from '../entities/common';

@Component({
  selector: 'app-usuarios-listado',
  templateUrl: './usuarios-listado.component.html',
  styleUrls: ['./usuarios-listado.component.less']
})
export class UsuariosListadoComponent implements OnInit {

  vColumns: String[];

  constructor(private service : UsuarioService, private router: Router) {
    this.vColumns = ['id','nombre','apellido','username'];

  }

  irDetalle(entity:Usuario){
    console.log(entity);
    this.service.cache(entity);
    this.router.navigateByUrl('/usuarios/detalle/'+entity.id);
  }

  ngOnInit() {
  }

}


