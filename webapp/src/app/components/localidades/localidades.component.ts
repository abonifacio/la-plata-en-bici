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

  hide(){
    this.showAgregar = false;
  }

  get seleccionada(){
    return this._seleccionada;
  }

  set seleccionada(val){
    this._seleccionada = val;
    this.seleccionadaChange.emit(this._seleccionada);
  }

  agregar(){
    if(!this.showAgregar){
      this.showAgregar = true;
      return;
    }
    this.service.save(this.nueva).subscribe((localidad)=>{
      this.localidades.push(localidad);
      this.seleccionada = localidad;
      this.showAgregar = false;
    });
  }

}
