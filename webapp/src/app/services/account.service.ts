import { Observable } from 'rxjs/Rx';
import { Usuario } from '../entities/user';
import { AppHttp } from './app-http.service';
import { CrudService } from './crud.service';
import { Injectable,EventEmitter } from '@angular/core';

@Injectable()
export class AccountService{

  private URI = 'account';
  private cUser:Usuario = undefined;

  onAuthSucess:EventEmitter<Usuario> = new EventEmitter<Usuario>();

  
  constructor(private http: AppHttp) {
  }

  get():Observable<Usuario>{
    return this.http.get(this.URI).map(this.catchUser.bind(this));
  }

  register(user:Usuario):Observable<Usuario>{
    return this.http.post(this.URI,user);
  }

  login(user:Usuario){
      return this.http.put(this.URI,user).map(this.catchUser.bind(this));
  }

  checkUsername(username:String){
      return this.http.get(this.URI+'/check/username/'+username);
  }
  checkEmail(email:String){
      return this.http.get(this.URI+'/check/email/'+email);
  }

  isCurrentUserInRole(roles:String[]):Boolean{
    return this.getCurrentUser() && roles.includes(this.cUser.rol);
  }

  private catchUser(user):Usuario{
    this.cUser = user;
    localStorage.setItem('cUser',JSON.stringify(user));
    this.onAuthSucess.next(user);
    return user;
  }

  logout(){
    this.cUser = undefined;
    localStorage.removeItem('cUser');
    localStorage.removeItem('authToken');
    this.onAuthSucess.next(null);
  }

  getCurrentUser():Usuario{
    if(!this.cUser){
      this.cUser = JSON.parse(localStorage.getItem('cUser'));
    }
    return this.cUser;
  }

}
