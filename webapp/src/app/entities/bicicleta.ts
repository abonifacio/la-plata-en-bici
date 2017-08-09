import { Entity } from './entity';
import { Estacion } from './estacion';
import { Usuario } from './user';

export class Bicicleta extends Entity{
    fechaIngres:Date;
    fechaDevolucion:Date;
    estado:EstadoBicicleta;
    usuario:Usuario;
    estacion:Estacion;
    detalle:String;
}

export enum EstadoBicicleta{
    APTA,REPARACION,DESUSO,DENUNCIADA
}