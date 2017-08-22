import { EstadisticasService } from './estadisticas.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-estadisticas',
  templateUrl: './estadisticas.component.html',
  styleUrls: ['./estadisticas.component.less']
})
export class EstadisticasComponent implements OnInit {

  bicicletas  = [];
  usuarios = [];
  estaciones = [];
  total = {};
  constructor(private service : EstadisticasService) {
    this.service.get().subscribe(est=>{
      this.usuarios = est.usuariosPorEstado;
      this.estaciones = est.estacionesPorEstado;
      this.bicicletas = est.bicicletasPorEstado;
      
      console.log(est);

      this.total = {
        bicicletas : est.bicicletas,
        bicicletasAlquiladas : est.bicicletasAlquiladas,
        estaciones : est.estaciones,
        usuarios : est.usuarios,
      }
    });
  }

  pct(cant,total){
    if(!cant || !total) return 0;
    return cant / total * 100;
  }

  avg(sup,sub){
    if(!sup || !sub) return 0;
    return sup/sub;
  }

  test(){

  }

  ngOnInit() {
  }

}
