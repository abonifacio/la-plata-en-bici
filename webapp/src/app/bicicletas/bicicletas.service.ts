import { Page, Pageable } from '../entities/common';
import { Estacion } from '../entities/estacion';
import { HistorialBicicleta,Bicicleta } from '../entities/bicicleta';
import { CrudService } from '../services/crud.service';
import { AppHttp } from '../services/app-http.service';
import { Observable } from 'rxjs/Rx';
import { Injectable } from '@angular/core';

@Injectable()
export class BicicletaService extends CrudService<Bicicleta>{

  constructor(http: AppHttp) {
    super(http,'bicicletas');
  }

  retirar(estacion:Estacion):Observable<Bicicleta>{
      return this.http.put(this.URI+'/retirar',estacion);
  }

  estacionar(bici:Bicicleta):Observable<Bicicleta>{
      return this.http.put(this.URI+'/devolver',bici);
  }

  misBicicletas():Observable<Bicicleta[]>{
    return this.http.get(this.URI+'/mis-bicicletas');
  }

  estados():String[]{
    return ['APTA','REPARACION','DESUSO','DENUNCIADA'];
  }

  historial(id:number,pageable:Pageable):Observable<Page<HistorialBicicleta>>{
    let query = {};
    for(let key in pageable){
        query[key] = pageable[key];
    }
    let options = {
        search : query
    }
    return this.http.get(this.URI+'/'+id+'/historial',options);
  }



}
