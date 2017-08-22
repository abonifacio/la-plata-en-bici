import { AccountService } from '../services/account.service';
import { TablaService } from '../components/tabla/tabla.service';
import { Estacion } from '../entities/estacion';
import { EstacionService } from './estacion.service';
import { Column } from '../entities/common';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-estaciones-listado',
  templateUrl: './estaciones-listado.component.html',
  styleUrls: ['./estaciones-listado.component.less']
})
export class EstacionesListadoComponent implements OnInit {
  vColumns: String[];

  constructor(private service : EstacionService, private router: Router,
  private tabla:TablaService,private account:AccountService) {
    this.tabla.setService(service);
    if(account.isCurrentUserInRole(['ADMIN'])){
      this.vColumns = ['id','nombre','direccion','estado','capacidad','ocupacion','ver'];
    }else{
      this.vColumns = ['nombre','direccion','estado','disponibles','ver'];
    }
  }

  irDetalle(est:Estacion){
    this.service.cache(est);
    this.router.navigateByUrl('/estaciones/detalle/'+est.id);
  }

  calcOcupacion(row){
    return row['ocupacion']/row['capacidad']*100;
  }

  ngOnInit() {
      

  }

  

}
