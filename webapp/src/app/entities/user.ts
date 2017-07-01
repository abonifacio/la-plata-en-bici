import { Localidad } from './localidad';


export class User{

    DNI: Number;
    nombre: String;
    apellido: String;
    calle: String;
    numero: String;
    localidad:Localidad;
    fechaNacimiento:Date;
    estado: EstadoUsuario;
    sexo: Sexo;
    username: String;
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