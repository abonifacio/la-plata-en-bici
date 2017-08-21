import { CrudService } from '../services/crud.service';
import { AppHttp } from '../services/app-http.service';
import { Usuario } from '../entities/user';
import { Observable } from 'rxjs/Rx';
import { Injectable } from '@angular/core';

@Injectable()
export class UsuarioService extends CrudService<Usuario>{

  constructor(http: AppHttp) {
    super(http,'usuarios');
  }

  setActivo(id:Number,estado : String):Observable<Usuario>{
      return this.http.put(this.URI+'/activar/'+id,estado);
  }

  setRol(id:Number,rol : String):Observable<Usuario>{
      return this.http.put(this.URI+'/rol/'+id,rol);
  }

}
