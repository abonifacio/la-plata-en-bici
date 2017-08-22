import { EstacionesComponent } from '../estaciones/estaciones.component';
import { Router,ActivatedRoute } from '@angular/router';
import { EstacionService } from '../estaciones/estacion.service';
import { Estacion } from '../entities/estacion';
import { BicicletaService } from './bicicletas.service';
import { Bicicleta } from '../entities/bicicleta';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bicicletas-alta',
  templateUrl: './bicicletas-alta.component.html',
  styleUrls: ['./bicicletas-alta.component.less']
})
export class BicicletasAltaComponent implements OnInit {

  bici: Bicicleta = new Bicicleta();
  estaciones: Estacion[] = [];
  estados: String[];
  isEdit = false;
  constructor(private service : BicicletaService,private estService:EstacionService,
  private router: Router,private route : ActivatedRoute) { 
    this.estados = service.estados();
    this.estService.conCapacidad().subscribe((estaciones)=>{
      this.estaciones = estaciones;
    });
    this.route.params.subscribe(params=>{
      if(params['id']){
        this.isEdit = true;
        this.service.get(params['id']).subscribe(b=>{
          this.bici = b;
        });
      }
    })
  }

  ngOnInit() {
  }

  doAlta(){
    this.service.save(this.bici).subscribe((bici)=>{
      if(this.isEdit){
        this.service.cache(bici);
        this.router.navigate(['/bicicletas/detalle',bici.id]);
      }else{
        this.router.navigate(['/bicicletas/listado']);
      }
    });
  }

}
