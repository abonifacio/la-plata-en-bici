import { Localidad } from './entities/localidad';
import { AppHttp,HttpRequestSubscriber } from './services/app-http.service';
import { httpFactory } from './services/http-factory';
import { AccountService } from './services/account.service';
import { LocalidadService } from './services/localidad.service';
import { Http,RequestOptions,HttpModule, XHRBackend } from '@angular/http';
import { UsuarioService } from './usuarios/usuario.service';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
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
import { BicicletasEstacionarComponent } from './bicicletas/bicicletas-estacionar.component';
import { BicicletasDenunciarComponent } from './bicicletas/bicicletas-denunciar.component';
import { BicicletasAltaComponent } from './bicicletas/bicicletas-alta.component';
import { UsuariosDetalleComponent } from './usuarios/usuarios-detalle.component';
import { TablaComponent } from './components/tabla/tabla.component';
import { LoadingComponent } from './components/loading/loading.component';
import { AlertComponent } from './components/alert/alert.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { FlexLayoutModule } from '@angular/flex-layout';

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
    BicicletasEstacionarComponent,
    BicicletasDenunciarComponent,
    BicicletasAltaComponent,
    UsuariosDetalleComponent,
    TablaComponent,
    LoadingComponent,
    AlertComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    AppMaterialModule,
    FormsModule,
    HttpModule,
    FlexLayoutModule
  ],
  providers: [
    HttpRequestSubscriber,
    {
        provide: AppHttp,
        useFactory: httpFactory,
        deps: [XHRBackend, RequestOptions,HttpRequestSubscriber]
    },
    AccountService,
    LocalidadService,
    UsuarioService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
