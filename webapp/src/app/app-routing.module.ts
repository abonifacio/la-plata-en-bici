import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EstacionesComponent} from './estaciones/estaciones.component';
import {EstacionesListadoComponent} from './estaciones/estaciones-listado.component';
import {EstacionesMapaComponent} from './estaciones/estaciones-mapa.component';
import {RegistroComponent} from './registro/registro.component';
import {BicicletasComponent} from './bicicletas/bicicletas.component';
import {BicicletasListadoComponent} from './bicicletas/bicicletas-listado.component';
import {BicicletasAltaComponent } from './bicicletas/bicicletas-alta.component';
import {BicicletasDenunciarComponent } from './bicicletas/bicicletas-denunciar.component';
import {BicicletasEstacionarComponent } from './bicicletas/bicicletas-estacionar.component';
import {BicicletasRetirarComponent } from './bicicletas/bicicletas-retirar.component';
import {UsuariosComponent } from './usuarios/usuarios.component';
import {UsuariosDetalleComponent } from './usuarios/usuarios-detalle.component';
import {UsuariosListadoComponent } from './usuarios/usuarios-listado.component';
import {HomeComponent } from './home/home.component';

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
    ],
  },
  {
    path: 'bicicletas',
    component: BicicletasComponent,
    data: {title: 'Bicicletas'},
    children:[
      {
        path: 'listado',
        component: BicicletasListadoComponent
      },
      {
        path: 'retirar',
        component: BicicletasRetirarComponent
      },
      {
        path: 'denunciar',
        component: BicicletasDenunciarComponent
      },
      {
        path: 'estacionar',
        component: BicicletasEstacionarComponent
      },
      {
        path: 'alta',
        component: BicicletasAltaComponent
      }
    ]
  },
  {
    path: 'usuarios',
    component: UsuariosComponent,
    data: {title: 'Usuarios'},
    children:[
      {
        path: 'listado',
        data: {title: 'Listado de Usuarios'},
        component: UsuariosListadoComponent
      },
      {
        path: 'detalle/:id',
        data: {title: 'Detalle de usuario'},
        component: UsuariosDetalleComponent
      }
    ]
  },
  {
    path: 'registro',
    component: RegistroComponent,
    data: { title: 'Registro'}
  },
  {
    path:'',
    component: HomeComponent,
    data: {title: 'Bienvenido a LaPlataEnBici'}
  },
  {
    path: '**',
    redirectTo: ''
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
