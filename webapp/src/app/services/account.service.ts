import { Observable } from 'rxjs/Rx';
import { Rol, Usuario } from '../entities/user';
import { AppHttp } from './app-http.service';
import { CrudService } from './crud.service';
import { Injectable } from '@angular/core';

@Injectable()
export class AccountService{

  private URI = 'account';
  private cUser:Usuario = undefined;
  constructor(private http: AppHttp) {
  }

  get():Observable<Usuario>{
    return this.http.get(this.URI).map(this.catchUser);
  }

  register(user:Usuario):Observable<Usuario>{
    return this.http.post(this.URI,user);
  }

  login(user:Usuario){
      return this.http.put(this.URI,user).map(this.catchUser);
  }

  isCurrentUserInRole(roles:Rol[]):Boolean{
    return true;
    // return this.cUser && roles.includes(this.cUser.rol);
  }

  private catchUser(user):Usuario{
    this.cUser = user;
    return user;
  }

}
