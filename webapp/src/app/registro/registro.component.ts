import { NgForm } from '@angular/forms/src/directives';
import { Localidad } from '../entities/localidad';
import { Page } from '../entities/common';
import { Observable } from 'rxjs/Rx';
import { AccountService } from '../services/account.service';
import { LocalidadService } from '../services/localidad.service';
import { Usuario } from '../entities/user';
import { Component, OnInit,ViewChild } from '@angular/core';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.less']
})
export class RegistroComponent implements OnInit {

  user:Usuario = new Usuario();

  startDate = new Date(1995,4,9);
  localidades = [];
  maxDate = new Date();

  registrado = false;
  
  
  constructor(private service:AccountService,private locService: LocalidadService) {

  }

  ngOnInit() {
    this.locService.list().subscribe((locs:Localidad[])=>{
      this.localidades = locs;
    });
  }

  doRegister(){
    this.service.register(this.user).subscribe((user)=>{
      this.user = user;
      this.registrado = true;
    });
  }



}
