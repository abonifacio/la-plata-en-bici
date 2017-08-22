import { AdminAllowed,UserAllowed,LoggedAllowed,NotLoggedAllowed } from './services/router-security';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EstacionesComponent} from './estaciones/estaciones.component';
import {EstacionesAltaComponent} from './estaciones/estaciones-alta.component';
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
import {EstadisticasComponent} from './estadisticas/estadisticas.component';

const routes: Routes = [
  {
    path: 'estaciones',
    component: EstacionesComponent,
    data: { title: 'Estaciones' },
    canActivate: [LoggedAllowed],
    children: [
      {
        path:'listado',
        canActivate: [LoggedAllowed],
        component: EstacionesListadoComponent,
      },
      {
        path:'mapa',
        data: {title: 'Mapa de estaciones'},
        canActivate: [LoggedAllowed],
        component: EstacionesMapaComponent,
      },
      {
        path: 'detalle/:id',
        canActivate: [LoggedAllowed],
        data: {title: 'Detalle de estacion'},
        component: EstacionesDetalleComponent
      },
      {
        path: 'editar/:id',
        canActivate: [AdminAllowed],
        data: {title: 'Editar estación'},
        component: EstacionesAltaComponent
      },
      {
        path: 'alta',
        canActivate: [AdminAllowed],
        data: {title: 'Nueva estación'},
        component: EstacionesAltaComponent
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
        data: {title: 'Bicicletas alquiladas por mi'},
        canActivate: [UserAllowed],
        component: MisBicicletasComponent
      },
      {
        path: 'retirar',
        canActivate: [UserAllowed],
        data: {title: 'Retirar bicicleta disponible'},
        component: BicicletasRetirarComponent
      },
      {
        path: 'alta',
        canActivate: [AdminAllowed],
        data: {title: 'Nueva bicicleta'},
        component: BicicletasAltaComponent
      },
      {
        path: 'detalle/:id',
        data: {title: 'Detalle de bicicleta'},
        canActivate: [AdminAllowed],
        component: BicicletasDetalleComponent
      },
      {
        path: 'editar/:id',
        canActivate: [AdminAllowed],
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
    path: 'estadisticas',
    component: EstadisticasComponent,
    data: {title: 'Estadísticas'},
    canActivate: [AdminAllowed]
  },
  {
    path: 'perfil',
    component: UsuariosDetalleComponent,
    canActivate: [LoggedAllowed],
    data: {title: 'Su perfil'}
  },
  {
    path: 'registro',
    component: RegistroComponent,
    canActivate: [NotLoggedAllowed],
    data: { title: 'Registro'}
  },
  {
    path:'login',
    canActivate: [NotLoggedAllowed],
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
