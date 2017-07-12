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

  columns: Column[];

  constructor(private service : UsuarioService, private router: Router) {
    this.columns = [
      new Column('id','ID'),
      new Column('nombre','Nombre'),
      new Column('apellido','Apellido'),
      new Column('username','Usuario')
    ];

  }

  irDetalle(id:Number){
    console.log(id);
    this.router.navigateByUrl('/usuarios/detalle/'+id);
  }

  ngOnInit() {
  }

}


