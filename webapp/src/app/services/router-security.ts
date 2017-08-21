import { AccountService } from './account.service';
import { Router,CanActivate } from '@angular/router';
import { Injectable } from '@angular/core';


abstract class RolAllowed {
  constructor(private router: Router,private account: AccountService) {

  }
  protected _canActivate(userRole:String[]) {
    if(this.account.isCurrentUserInRole(userRole)){
        return true;
    }
    this.router.navigate(['/']);
    return false;

  }
}

@Injectable()
export class AdminAllowed extends RolAllowed implements CanActivate{
    constructor(router: Router,account:AccountService){
        super(router,account);
    }
    canActivate(){
        return this._canActivate(['ADMIN']);
    }
}
@Injectable()
export class UserAllowed extends RolAllowed implements CanActivate{
    constructor(router: Router,account:AccountService){
        super(router,account);
    }
    canActivate(){
        return this._canActivate(['USER']);
    }
}
@Injectable()
export class LoggedAllowed extends RolAllowed implements CanActivate{
    constructor(router: Router,account:AccountService){
        super(router,account);
    }
    canActivate(){
        return this._canActivate(['ADMIN','USER']);
    }
}