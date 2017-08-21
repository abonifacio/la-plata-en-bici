import { Estacion } from '../entities/estacion';
import { Bicicleta } from '../entities/bicicleta';
import { BicicletaService } from './bicicletas.service';
import { EstacionService } from '../estaciones/estacion.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mis-bicicletas',
  templateUrl: './mis-bicicletas.component.html',
  styleUrls: ['./mis-bicicletas.component.less']
})
export class MisBicicletasComponent implements OnInit {

  alquiladas : Bicicleta[];
  conCapacidad : Estacion[] = [];

  porDevolver : Bicicleta = undefined;

  constructor(private estacionesService: EstacionService,private service:BicicletaService) {
    this.updateConCapacidad();
    this.service.misBicicletas().subscribe((bicicletas)=>{
      this.alquiladas = bicicletas;
    });
   }

  ngOnInit() {
  }

  doDevolver(){
    this.service.estacionar(this.porDevolver).subscribe((bici)=>{
      this.alquiladas = this.alquiladas.filter((b)=>b.id!=bici.id);
      this.updateConCapacidad();
      this.porDevolver = undefined;
    });
  }

  private updateConCapacidad(){
    this.estacionesService.conCapacidad().subscribe(data =>{
      this.conCapacidad = data;
    });
  }

  preDevolver(bicicleta:Bicicleta){
    this.porDevolver = bicicleta;
  }

  setDenuncia(event){
    if(event.checked){
      this.porDevolver.estado = 'DENUNCIADA';
    }else{
      this.porDevolver.estado = 'APTA';
    }
  }

}
