import { Entity } from './entity';
import { Localidad } from './localidad';


export class Usuario extends Entity{

    DNI: Number;
    nombre: String;
    apellido: String;
    email:String;
    calle: String;
    numero: String;
    localidad:Localidad;
    fechaNacimiento:Date;
    estado: EstadoUsuario;
    sexo: Sexo;
    username: String;
    password:String;
    rol: Rol;
    
}

export enum EstadoUsuario{
    HABILITADO,SUSPENDIO,BANEADO
}

export enum Sexo{
    F,M
}

export enum Rol{
    ADMIN,USER
}