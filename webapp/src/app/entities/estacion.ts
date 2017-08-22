import { Entity } from './entity';
import { Bicicleta } from './bicicleta';

export class Estacion extends Entity{
    nombre:String;
    capacidad:Number;
    estado:String;
    direccion:String;
    longitud:Number;
    latitud:Number;
    ocupacion:Number;
}