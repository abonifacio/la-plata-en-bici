import { Router,ActivatedRoute } from '@angular/router';
import { EstacionService } from './estacion.service';
import { Estacion } from '../entities/estacion';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-estaciones-alta',
  templateUrl: './estaciones-alta.component.html',
  styleUrls: ['./estaciones-alta.component.less']
})
export class EstacionesAltaComponent implements OnInit {

  est : Estacion = new Estacion();
  estados : String[] = [];
  isEdit = false;

  constructor(private service:EstacionService,private router:Router,private route:ActivatedRoute) {
    this.est.latitud = -34.9209066;
    this.est.longitud = -57.957052;
    this.estados = this.service.estados();

    this.route.params.subscribe(params=>{
      if(params['id']){
        this.isEdit = true;
        this.service.get(params['id']).subscribe(est=>{
          this.est = est;
        })
      }
    });
  }

  ngOnInit() {
  }

  updateCoords(event){
    this.est.latitud = event.coords.lat;
    this.est.longitud = event.coords.lng;
  } 

  doAlta(){
    this.service.save(this.est).subscribe(est=>{
      this.service.cache(est);
      if(this.isEdit){
        this.router.navigate(['/estaciones/detalle',est.id]);
      }else{
        this.router.navigate(['/estaciones/listado']);
      }
    });
  }
}
