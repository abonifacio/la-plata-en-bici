import { AdminAllowed,UserAllowed,LoggedAllowed } from './services/router-security';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EstacionesComponent} from './estaciones/estaciones.component';
import {EstacionesListadoComponent} from './estaciones/estaciones-listado.component';
import {EstacionesMapaComponent} from './estaciones/estaciones-mapa.component';
import {RegistroComponent} from './registro/registro.component';
import {BicicletasComponent} from './bicicletas/bicicletas.component';
import {BicicletasListadoComponent} from './bicicletas/bicicletas-listado.component';
import {BicicletasAltaComponent } from './bicicletas/bicicletas-alta.component';
import { BicicletasRetirarComponent } from './bicicletas/bicicletas-retirar.component';
import {UsuariosComponent } from './usuarios/usuarios.component';
import {UsuariosDetalleComponent } from './usuarios/usuarios-detalle.component';
import {UsuariosListadoComponent } from './usuarios/usuarios-listado.component';
import {HomeComponent } from './home/home.component';
import {EstacionesDetalleComponent} from './estaciones/estaciones-detalle.component';
import {BicicletasDetalleComponent} from './bicicletas/bicicletas-detalle.component';
import {MisBicicletasComponent} from './bicicletas/mis-bicicletas.component';

const routes: Routes = [
  {
    path: 'estaciones',
    component: EstacionesComponent,
    data: { title: 'Estaciones' },
    canActivate: [LoggedAllowed],
    children: [
      {
        path:'listado',
        component: EstacionesListadoComponent,
      },
      {
        path:'mapa',
        component: EstacionesMapaComponent,
      },
      {
        path: 'detalle/:id',
        data: {title: 'Detalle de estacion'},
        component: EstacionesDetalleComponent
      }
    ],
  },
  {
    path: 'bicicletas',
    component: BicicletasComponent,
    data: {title: 'Bicicletas'},
    canActivate: [LoggedAllowed],
    children:[
      {
        path: 'listado',
        component: BicicletasListadoComponent,
        canActivate: [AdminAllowed],
      },
      {
        path:'mis-bicicletas',
        canActivate: [UserAllowed],
        component: MisBicicletasComponent
      },
      {
        path: 'retirar',
        canActivate: [UserAllowed],
        component: BicicletasRetirarComponent
      },
      {
        path: 'alta',
        canActivate: [AdminAllowed],
        component: BicicletasAltaComponent
      },
      {
        path: 'detalle/:id',
        data: {title: 'Detalle de bicicleta'},
        component: BicicletasDetalleComponent
      },
      {
        path: 'editar/:id',
        data: {title: 'Editar bicicleta'},
        component: BicicletasAltaComponent
      }
    ]
  },
  {
    path: 'usuarios',
    component: UsuariosComponent,
    data: {title: 'Usuarios'},
    canActivate: [AdminAllowed],
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
    path: 'perfil',
    component: UsuariosDetalleComponent,
    data: {title: 'Su perfil'}
  },
  {
    path: 'registro',
    component: RegistroComponent,
    data: { title: 'Registro'}
  },
  {
    path:'login',
    component: LoginComponent,
    data: {title: 'Login'}
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
