import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EstacionesComponent} from './estaciones/estaciones.component';
import {EstacionesListadoComponent} from './estaciones/estaciones.listado.component';
import {EstacionesMapaComponent} from './estaciones/estaciones.mapa.component';
import {RegistroComponent} from './registro/registro.component';

const routes: Routes = [
  {
    path: 'estaciones',
    component: EstacionesComponent,
    data: { title: 'Estaciones' },
    children: [
      {
        path:'listado',
        component: EstacionesListadoComponent,
      },
      {
        path:'mapa',
        component: EstacionesMapaComponent,
      }
    ]
  },
  {
    path: 'registro',
    component: RegistroComponent,
    data: { title: 'Registro'}
  },
  {
    path: '**',
    redirectTo: 'estaciones'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
