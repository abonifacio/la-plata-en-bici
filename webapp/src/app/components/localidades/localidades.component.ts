import { LocalidadService } from './localidad.service';
import { Localidad } from '../../entities/localidad';
import { Component, OnInit,Input,EventEmitter,Output } from '@angular/core';

@Component({
  selector: 'app-localidades',
  templateUrl: './localidades.component.html',
  styleUrls: ['./localidades.component.less']
})
export class LocalidadesComponent implements OnInit {
  @Input('seleccionada') _seleccionada:Localidad = undefined;
  @Input() disabled = false;
  @Output() seleccionadaChange = new EventEmitter<Localidad>();
  showAgregar = false;
  nueva: Localidad = new Localidad();
  localidades: Localidad[];

  constructor(private service:LocalidadService) {
    this.service.list().subscribe((data)=>{
      this.localidades = data;
    });
  }

  ngOnInit() {
  }


  agregar(){
    let isEdit = this.nueva.id!=undefined;
    this.service.save(this.nueva).subscribe(loc=>{
      if(!isEdit){
        this.localidades.push(loc);
      }else{
        this.localidades.filter(l=>l.id==loc.id).map(l=> {
          l.id = loc.id;
          l.nombre = loc.nombre;
          l.codigoPostal = loc.codigoPostal;
          return l;
        });
        console.log(loc);
      }
      this.cancelar();
    });
  }

  editar(loc:Localidad){
    this.nueva = this.clone(loc);
  }

  cancelar(){
    this.nueva = new Localidad();
  }

  private clone(loc:Localidad):Localidad{
      let tmp = new Localidad();
      tmp.id = loc.id;
      tmp.nombre = loc.nombre;
      tmp.codigoPostal = loc.codigoPostal;
      return tmp;
  }

}
