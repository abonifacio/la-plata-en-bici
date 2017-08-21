import { Router } from '@angular/router';
import { Usuario } from '../entities/user';
import { AccountService } from '../services/account.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less']
})
export class LoginComponent implements OnInit {

  private user : Usuario = new Usuario();

  constructor(private account:AccountService,private router:Router) { }

  ngOnInit() {
  }

  doLogin(){
    this.account.login(this.user).subscribe((user)=>{
      this.router.navigate(['/']);
    },(error)=>{
      this.user.password = '';      
    });
  }

}
