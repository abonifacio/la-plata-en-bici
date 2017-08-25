import { TablaService } from '../components/tabla/tabla.service';
import { Bicicleta } from '../entities/bicicleta';
import { DatePipe } from '@angular/common';
import { BicicletaService } from './bicicletas.service';
import { Router } from '@angular/router';
import { Column } from '../entities/common';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bicicletas-listado',
  templateUrl: './bicicletas-listado.component.html',
  styleUrls: ['./bicicletas-listado.component.less']
})
export class BicicletasListadoComponent {

  columns: Column[];
  vColumns: String[];

  constructor(private service : BicicletaService, private router: Router,public tabla: TablaService) {
    this.tabla.setService(service);
    this.vColumns = ['id','estado','estacion','fechaIngreso','usuario','fechaDevolucion','ver'];

  }

  irDetalle(bici:Bicicleta){
    this.service.cache(bici);
    this.router.navigateByUrl('/bicicletas/detalle/'+bici.id);
  }
  

}
