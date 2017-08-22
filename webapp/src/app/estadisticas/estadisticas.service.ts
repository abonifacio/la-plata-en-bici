import { Observable } from 'rxjs/Rx';
import { AppHttp } from '../services/app-http.service';
import { Injectable } from '@angular/core';

@Injectable()
export class EstadisticasService {

    constructor(protected http: AppHttp) {

    }

    get():Observable<any>{
        return this.http.get('estadisticas');
    }


}