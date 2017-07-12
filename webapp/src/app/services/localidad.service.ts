import { Page } from '../entities/common';
import { CrudService } from '../services/crud.service';
import { AppHttp } from '../services/app-http.service';
import { Localidad } from '../entities/localidad';
import { Observable } from 'rxjs/Rx';
import { Injectable } from '@angular/core';

@Injectable()
export class LocalidadService extends CrudService<Localidad>{

  constructor(http: AppHttp) {
    super(http,'localidades');
  }

}
