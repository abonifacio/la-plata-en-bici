import { Entity } from './entity';
export class Localidad extends Entity{
    
    nombre: String;
    codigoPostal: Number;

    constructor(id?:Number){
        super();
        this.id = id;
    }

}