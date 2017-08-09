import { Entity } from './entity';
import { Bicicleta } from './bicicleta';

export class Estacion extends Entity{
    nombre:String;
    capacidad:Number;
    estado:EstadoEstacion;
    direccion:String;
    bicicletas:Bicicleta[];
    ubicacion:Ubicacion;
    ocupacion:Number;
}

export enum EstadoEstacion{
    OPERATIVA,CERRADA,CONSTRUCCION
}

export class Ubicacion{
    longitud:Number;
    latitud:Number;
}