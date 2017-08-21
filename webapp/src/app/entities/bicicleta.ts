import { Entity } from './entity';
import { Estacion } from './estacion';
import { Usuario } from './user';

export class Bicicleta extends Entity{
    fechaIngreso:Date;
    fechaDevolucion:Date;
    estado:String;
    usuario:Usuario;
    estacion:Estacion;
    detalle:String;
}

export class HistorialBicicleta extends Entity{
    fechaIngreso:Date;
    fechaDevolucion:Date;
    estado:String;
    tipo:String;
    alquiladaPor:Usuario;
    detalle:String;
}