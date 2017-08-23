import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.less']
})
export class HomeComponent implements OnInit {

  usuarios:any[] = [];
  constructor() { 
    this.usuarios = [
      {username:'admin',password:'admin',rol:'ADMIN'},
      {username:'abonifacio',password:'secreta',rol:'USER'},
      {username:'jperez',password:'secreta',rol:'USER'}
    ]
  }

  ngOnInit() {
  }

}
