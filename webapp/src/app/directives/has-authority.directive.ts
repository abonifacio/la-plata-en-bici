import { Rol } from '../entities/user';
import { AccountService } from '../services/account.service';
import { ElementRef, Directive, Renderer2,Input,OnInit } from '@angular/core';

@Directive({
  selector: '[hasAuthority]'
})
export class HasAuthorityDirective implements OnInit{

  @Input() hasAuthority: string;

  constructor(private el:ElementRef,private renderer:Renderer2,private account:AccountService) {
  }

  ngOnInit(){
    if(!this.hasAuthority){
      this.hasAuthority="USER,ADMIN";
    }
    let roles:Rol[] = this.hasAuthority.split(',').map(this.mapRol);
    if(!this.account.isCurrentUserInRole(roles)){
      this.renderer.addClass(this.el.nativeElement,'hide');
    }

  }


  private mapRol(rol:String):Rol{
    switch(rol){
      case "USER":
        return Rol.USER;
      case "ADMIN":
        return Rol.ADMIN;
    }
  }

}
