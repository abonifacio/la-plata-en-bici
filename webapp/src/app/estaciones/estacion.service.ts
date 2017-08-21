import { Estacion } from '../entities/estacion';
import { CrudService } from '../services/crud.service';
import { AppHttp } from '../services/app-http.service';
import { Observable } from 'rxjs/Rx';
import { Injectable } from '@angular/core';

@Injectable()
export class EstacionService extends CrudService<Estacion>{

  constructor(http: AppHttp) {
    super(http,'estaciones');
  }

  retirables():Observable<Estacion[]>{
      return this.http.get(this.URI+'/disponibles');
  }

  conCapacidad():Observable<Estacion[]>{
    return this.http.get(this.URI+'/con-capacidad');
  }

}
