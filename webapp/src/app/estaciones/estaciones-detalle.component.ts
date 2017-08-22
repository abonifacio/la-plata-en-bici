import { EstacionService } from './estacion.service';
import { ActivatedRoute } from '@angular/router';
import { Estacion } from '../entities/estacion';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-estaciones-detalle',
  templateUrl: './estaciones-detalle.component.html',
  styleUrls: ['./estaciones-detalle.component.less']
})
export class EstacionesDetalleComponent implements OnInit {

  est : Estacion = new Estacion();
  
  constructor(private service : EstacionService,route :ActivatedRoute) {
    route.params.subscribe((params)=>{
      if(params['id']){
        this.service.get(params['id']).subscribe((est)=>{
          this.est = est;
        });
      }
    });
  }
  

  ngOnInit() {
  }

}
