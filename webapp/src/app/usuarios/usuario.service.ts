import { CrudService } from '../services/crud.service';
import { AppHttp } from '../services/app-http.service';
import { EstadoUsuario, Usuario } from '../entities/user';
import { Observable } from 'rxjs/Rx';
import { Injectable } from '@angular/core';

@Injectable()
export class UsuarioService extends CrudService<Usuario>{

  constructor(http: AppHttp) {
    super(http,'usuarios');
  }

  setActivo(id:Number,estado : EstadoUsuario):Observable<Usuario>{
      return this.http.put(this.URI+'/activar/'+id,estado);
  }

}
