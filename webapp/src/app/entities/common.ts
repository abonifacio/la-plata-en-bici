export class Page<T>{
    items:T[];
    pages:Number;
    pageSize:Number;
    currentPage:Number;
    totalItems:Number;
}

export class Pageable{
    sort:string;
    ascending:boolean;
    page:Number;
    count:Number;
}

export class Column{
    name:string;
    label:string;
    type:string;
    parse:Function;
    sort:string;
    constructor(obj:any){
        if(obj){
        this.name = obj.name;
        this.label = obj.label;
        this.type = obj.type || 'text';
        this.parse = obj.parse || ( (row)=> row[this.name] || '');
        this.sort = obj.sort===undefined? this.name : obj.sort;
        }
    }
}
