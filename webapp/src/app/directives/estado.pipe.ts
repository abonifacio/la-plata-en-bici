import { Pipe,PipeTransform } from '@angular/core';
@Pipe({name: 'estado'})
export class EstadoPipe implements PipeTransform {

    constructor() {

    }

    transform(val: String): String {
        switch(val){
            case 'APTA': return "Apta para uso";
            
            case 'REPARACION': return 'En reparación';
            
            case 'DESUSO': return 'En desuso';

            case 'DENUNCIADA': return 'Denunciada';
            
            case 'OPERATIVA': return 'Operativa';
            
            case 'CERRADA': return 'Cerrada';
            
            case 'CONSTRUCCION': return 'En construcción';
            
            case 'HABILITADO': return 'Habilitado';
            
            case 'SUSPENDIDO': return 'Inhabilitado temporalmente';

            case 'BANEADO': return 'Inhabilitado definitivamente';

            default: return val;
        }
    }
}