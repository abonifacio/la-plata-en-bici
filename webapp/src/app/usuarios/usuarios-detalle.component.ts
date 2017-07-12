import { EstadoUsuario, Usuario } from '../entities/user';
import { UsuarioService } from './usuario.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-usuarios-detalle',
  templateUrl: './usuarios-detalle.component.html',
  styleUrls: ['./usuarios-detalle.component.less']
})
export class UsuariosDetalleComponent implements OnInit {

  user : Usuario;
  constructor(private service: UsuarioService,private route:ActivatedRoute) {
    route.params.subscribe((params)=>{
      if(params['id']){
        this.service.get(params['id']).subscribe((user)=>{
          this.user = user;
        });
      }
    });
   }

  setEstado(estado: EstadoUsuario){
    this.service.setActivo(this.user.id,estado).subscribe((user)=>{
      this.user.estado = user.estado;
    });
  }

  ngOnInit() {
  }

}
