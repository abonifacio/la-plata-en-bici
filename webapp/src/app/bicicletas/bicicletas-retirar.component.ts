import { BicicletaService } from './bicicletas.service';
import { Observable } from 'rxjs/Rx';
import { EstacionService } from '../estaciones/estacion.service';
import { Resolve } from '@angular/router';
import { Estacion } from '../entities/estacion';
import { Injectable,Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-bicicletas-retirar',
  templateUrl: './bicicletas-retirar.component.html',
  styleUrls: ['./bicicletas-retirar.component.less']
})
export class BicicletasRetirarComponent implements OnInit {

  selected : Estacion = undefined;
  estaciones : Estacion[] = [];
  constructor(private estacionesService: EstacionService,private service:BicicletaService) {
    this.estacionesService.retirables().subscribe(data =>{
      this.estaciones = data;
    });
   }

  ngOnInit() {
  }

  doRetirar(){
    
  }

}
