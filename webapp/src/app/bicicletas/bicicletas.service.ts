
import { Bicicleta } from '../entities/bicicleta';
import { CrudService } from '../services/crud.service';
import { AppHttp } from '../services/app-http.service';
import { Observable } from 'rxjs/Rx';
import { Injectable } from '@angular/core';

@Injectable()
export class BicicletaService extends CrudService<Bicicleta>{

  constructor(http: AppHttp) {
    super(http,'bicicletas');
  }

  retirar(bici:Bicicleta):Observable<Bicicleta>{
      return this.http.put(this.URI+'/retirar',bici);
  }

  estacionar(bici:Bicicleta):Observable<Bicicleta>{
      return this.http.put(this.URI+'/estacionar',bici);
  }



}
