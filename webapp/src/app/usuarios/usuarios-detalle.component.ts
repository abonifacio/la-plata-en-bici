import { AccountService } from '../services/account.service';
import { Usuario } from '../entities/user';
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
  lockEdit = false;
  constructor(private service: UsuarioService,private route:ActivatedRoute,private account:AccountService) {
    route.params.subscribe((params)=>{
      if(params['id']){
        this.service.get(params['id']).subscribe((user)=>{
          this.user = user;
        });
      }else{
        this.user = account.getCurrentUser();
        this.lockEdit = true;
      }
    });
   }

  estado(estado: String){
    this.service.setActivo(this.user.id,estado).subscribe((user)=>{
      this.user.estado = user.estado;
    });
  }

  rol(rol: String){
    this.service.setRol(this.user.id,rol).subscribe((user)=>{
      this.user.rol = user.rol;
    });
  }


  ngOnInit() {
  }

}
