import { AccountService } from '../services/account.service';
import { ElementRef, Directive, Renderer2,Input,OnInit } from '@angular/core';

@Directive({
  selector: '[hasRole]'
})
export class HasAuthorityDirective implements OnInit{

  @Input() hasRole: string;

  constructor(private el:ElementRef,private renderer:Renderer2,private account:AccountService) {
  }

  ngOnInit(){
    if(!this.hasRole){
      this.hasRole="USER,ADMIN";
    }
    let roles:String[] = this.hasRole.split(',');
    this.check(roles);
    this.account.onAuthSucess.subscribe((user)=>{
      this.check(roles);
    });

  }

  private check(roles){
      if(!this.account.isCurrentUserInRole(roles)){
        this.renderer.addClass(this.el.nativeElement,'hide');
      }else{
        this.renderer.removeClass(this.el.nativeElement,'hide');
      }
  }

}

@Directive({
  selector: '[notLogged]'
})
export class NotLoggedDirective implements OnInit{


  constructor(private el:ElementRef,private renderer:Renderer2,private account:AccountService) {
  }

  ngOnInit(){

    this.check();
    this.account.onAuthSucess.subscribe((user)=>{
      this.check();
    });

  }

  private check(){
      if(this.account.getCurrentUser()){
        this.renderer.addClass(this.el.nativeElement,'hide');
      }else{
        this.renderer.removeClass(this.el.nativeElement,'hide');
      }
  }

}
