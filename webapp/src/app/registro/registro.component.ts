import { LocalidadService } from '../components/localidades/localidad.service';
import { FormControl,FormGroup,FormBuilder,AsyncValidatorFn,ValidationErrors,Validators,AbstractControl } from '@angular/forms';
import { Localidad } from '../entities/localidad';
import { Page } from '../entities/common';
import { Observable } from 'rxjs/Rx';
import { AccountService } from '../services/account.service';
import { Usuario } from '../entities/user';
import { Component, OnInit,ViewChild } from '@angular/core';

const EMAIL_REGEX = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.less']
})
export class RegistroComponent implements OnInit {

  user:Usuario = new Usuario();

  startDate = new Date(1995,4,9);
  maxDate = new Date();
  localidades :Localidad[] = [];

  valid = {
    username: false,
    email:false
  }

  stage = 0;

  checkForm : FormGroup;
  
  constructor(private service:AccountService,private fb : FormBuilder,private locService:LocalidadService) {
    this.checkForm = fb.group({
      username : new FormControl('', 
        [Validators.required,Validators.minLength(3)],
        [this.checkUsername()]
      ),
      email: new FormControl('', 
        [Validators.required,Validators.pattern(EMAIL_REGEX)],
        [this.checkEmail()]
      )
    });
    this.locService.list().subscribe((data)=>{
      this.localidades = data;
    });
  }

  private checkUsername():AsyncValidatorFn{
    let service = this.service;
    return (control:AbstractControl)=>{
      let q = new Promise((resolve,reject)=>{
        service.checkUsername(control.value).subscribe((valid)=>{
          if(!valid){
            return resolve({valid:true});
          }else{
            return resolve(null);
          }
        });
      });
      return q;
    }
  }

  private checkEmail():AsyncValidatorFn{
    let service = this.service;
    return (control:AbstractControl)=>{
      let q = new Promise((resolve,reject)=>{
        service.checkEmail(control.value).subscribe((valid)=>{
          if(!valid){
            return resolve({valid:true});
          }else{
            return resolve(null);
          }
        });
      });
      return q;
    }
  }
  

  ngOnInit() {
  }

  doNext(){
    this.stage++;
  }

  reset(){
    this.stage = 0;
    this.user = new Usuario();
  }

  doRegister(){
    this.service.register(this.user).subscribe((user)=>{
      this.user = user;
      this.stage++;
    });
  }



}
