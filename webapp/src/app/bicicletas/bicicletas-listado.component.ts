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

  constructor(private service : BicicletaService, private router: Router,private datePipe: DatePipe) {
    
    let dateParse = (fecha)=> this.datePipe.transform(fecha,'dd-MM-yyyy HH:mm');
    this.vColumns = ['id','estado','estacion','fechaIngreso','usuario','fechaDevolucion'];

    this.columns = [
      new Column({name:'id',label:'ID'}),
      new Column({name:'estado',label:'Estado'}),
      new Column({
        name:'estacion',
        label:'Estacion',
        parse:(row)=>row['estacion'] && row['estacion'].nombre,
        sort:''
      }),
      new Column({
        name:'fechaIngreso',
        label:'Fecha de Ingreso / Egreso',
        parse: (row)=> dateParse(row['fechaIngreso'])}),
      new Column({
        name:'usuario',
        label:'Alquilada por',
        parse: (row)=>row['user'] && row['user'].username,
        sort:''
      }),
      new Column({
        name:'fechaDevolucion',
        label:'Fecha de Devolución',
        parse: (row)=> dateParse(row['fechaIngreso'])
      })
    ];

  }

  irDetalle(bici:Bicicleta){
    this.service.cache(bici);
    this.router.navigateByUrl('/bicicletas/detalle/'+bici.id);
  }
  

}
