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
    estado: String;
    sexo: String;
    username: String;
    password:String;
    rol: String;
    
}