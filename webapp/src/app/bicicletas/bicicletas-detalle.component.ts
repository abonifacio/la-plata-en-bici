import { Router,ActivatedRoute } from '@angular/router';
import { BicicletaService } from './bicicletas.service';
import { Bicicleta,HistorialBicicleta } from '../entities/bicicleta';
import { TablaService } from '../components/tabla/tabla.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bicicletas-detalle',
  templateUrl: './bicicletas-detalle.component.html',
  styleUrls: ['./bicicletas-detalle.component.less']
})
export class BicicletasDetalleComponent implements OnInit {

  vColumns: String[];
  bici : Bicicleta = new Bicicleta();
  
  constructor(private service : BicicletaService,route :ActivatedRoute,private router: Router,private tabla : TablaService) {
    this.vColumns = ['fechaIngreso','fechaDevolucion','estado','tipo','alquiladaPor','ver'];
    route.params.subscribe((params)=>{
      if(params['id']){

        this.service.get(params['id']).subscribe((bici)=>{
          this.bici = bici;
        });
        this.tabla.setService(this.service,'historial',{id:params['id']});

      }
    });
  }

  isAlquilada(bici:Bicicleta){
    return bici.usuario;
  }

  ngOnInit() {
  }

}
