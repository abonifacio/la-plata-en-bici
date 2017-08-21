import { AdminAllowed,UserAllowed,LoggedAllowed } from './services/router-security';
import { ReturnDateDirective } from './directives/return-date.directive';
import { CustomDatePipe } from './directives/cdate.pipe';
import { TablaService } from './components/tabla/tabla.service';
import { BicicletaService } from './bicicletas/bicicletas.service';
import { EstacionService } from './estaciones/estacion.service';
import { Localidad } from './entities/localidad';
import { AppHttp,HttpRequestSubscriber } from './services/app-http.service';
import { httpFactory } from './services/http-factory';
import { AccountService } from './services/account.service';
import { LocalidadService } from './components/localidades/localidad.service';
import { Http,RequestOptions,HttpModule, XHRBackend } from '@angular/http';
import { UsuarioService } from './usuarios/usuario.service';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule }   from '@angular/forms';
import { DatePipe } from '@angular/common';
import {AppMaterialModule } from './material-module';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EstacionesComponent } from './estaciones/estaciones.component';
import {EstacionesListadoComponent} from './estaciones/estaciones-listado.component';
import {EstacionesMapaComponent} from './estaciones/estaciones-mapa.component';
import { RegistroComponent } from './registro/registro.component';
import { BicicletasComponent } from './bicicletas/bicicletas.component';
import { BicicletasListadoComponent } from './bicicletas/bicicletas-listado.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { UsuariosListadoComponent } from './usuarios/usuarios-listado.component';
import { BicicletasRetirarComponent } from './bicicletas/bicicletas-retirar.component';
import { BicicletasAltaComponent } from './bicicletas/bicicletas-alta.component';
import { UsuariosDetalleComponent } from './usuarios/usuarios-detalle.component';
import { TablaComponent } from './components/tabla/tabla.component';
import { LoadingComponent } from './components/loading/loading.component';
import { AlertComponent } from './components/alert/alert.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { HasAuthorityDirective } from './directives/has-authority.directive';
import { EstacionesDetalleComponent } from './estaciones/estaciones-detalle.component';
import { BicicletasDetalleComponent } from './bicicletas/bicicletas-detalle.component';
import { PaginatorComponent } from './components/tabla/paginator.component';
import { LocalidadesComponent } from './components/localidades/localidades.component';
import { MisBicicletasComponent } from './bicicletas/mis-bicicletas.component';

@NgModule({
  declarations: [
    AppComponent,
    EstacionesComponent,
    EstacionesListadoComponent,
    EstacionesMapaComponent,
    RegistroComponent,
    BicicletasComponent,
    BicicletasListadoComponent,
    UsuariosComponent,
    UsuariosListadoComponent,
    BicicletasRetirarComponent,
    BicicletasAltaComponent,
    UsuariosDetalleComponent,
    TablaComponent,
    LoadingComponent,
    AlertComponent,
    HomeComponent,
    LoginComponent,
    HasAuthorityDirective,
    ReturnDateDirective,
    EstacionesDetalleComponent,
    BicicletasDetalleComponent,
    PaginatorComponent,
    LocalidadesComponent,
    MisBicicletasComponent,
    CustomDatePipe
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    AppMaterialModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule
  ],
  providers: [
    HttpRequestSubscriber,
    {
        provide: AppHttp,
        useFactory: httpFactory,
        deps: [XHRBackend, RequestOptions,HttpRequestSubscriber]
    },
    AdminAllowed,
    UserAllowed,
    LoggedAllowed,
    DatePipe,
    CustomDatePipe,
    TablaService,
    AccountService,
    LocalidadService,
    UsuarioService,
    BicicletaService,
    EstacionService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
