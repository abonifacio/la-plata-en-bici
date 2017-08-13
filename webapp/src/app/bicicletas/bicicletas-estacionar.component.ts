import { Localidad } from '../entities/localidad';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bicicletas-estacionar',
  templateUrl: './bicicletas-estacionar.component.html',
  styleUrls: ['./bicicletas-estacionar.component.less']
})
export class BicicletasEstacionarComponent implements OnInit {

  tmp:Localidad;
  constructor() { }

  ngOnInit() {
  }

}
