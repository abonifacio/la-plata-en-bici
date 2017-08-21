import { DatePipe } from '@angular/common';
import { Pipe,PipeTransform } from '@angular/core';
@Pipe({name: 'cDate'})
export class CustomDatePipe implements PipeTransform {

    constructor(private datePipe: DatePipe) {

    }

    transform(val: Date): string {
        let now = new Date();
        if(!val) return '';
        if(!val.getDate) val = new Date(val);
         
        if(now.getDate()==val.getDate()){
            return 'Hoy a las '+this.datePipe.transform(val,'HH:mm');
        }else{
            if(now.getFullYear()==val.getFullYear()){
                return this.datePipe.transform(val,'dd-MM HH:mm');
            }else{
                return this.datePipe.transform(val,'dd-MM-yyyy HH:mm');
            }
        }
    }
}