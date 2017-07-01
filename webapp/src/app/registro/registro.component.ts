import { User } from '../entities/user';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.less']
})
export class RegistroComponent implements OnInit {

  user:User = new User();

  constructor() { }

  ngOnInit() {
  }

}
