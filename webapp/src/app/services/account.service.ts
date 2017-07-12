import { Observable } from 'rxjs/Rx';
import { Usuario } from '../entities/user';
import { AppHttp } from './app-http.service';
import { CrudService } from './crud.service';
import { Injectable } from '@angular/core';

@Injectable()
export class AccountService{

  private URI = 'account';
  constructor(private http: AppHttp) {
  }

  get():Observable<Usuario>{
    return this.http.get(this.URI);
  }

  register(user:Usuario):Observable<Usuario>{
    return this.http.post(this.URI,user);
  }

  login(user:Usuario){
      return this.http.put(this.URI,user);
  }

}
