import { Router } from '@angular/router';
import { Estacion } from '../entities/estacion';
import { EstacionService } from './estacion.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-estaciones-mapa',
  templateUrl: './estaciones-mapa.component.html',
  styleUrls: ['./estaciones-mapa.component.less']
})
export class EstacionesMapaComponent implements OnInit {

  initLong = -57.957052;
  initLat = -34.9209066;
  estaciones:Estacion[] = [];

  constructor(private service: EstacionService,private router:Router) {
    this.service.list().subscribe(estaciones=>{
      this.estaciones = estaciones;
    })
   }

  ngOnInit() {
  }

  irDetalle(est:Estacion){
    this.service.cache(est);
    this.router.navigateByUrl('/estaciones/detalle/'+est.id);
  }

}
