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
    constructor(public name:string,public label:string){
    }
}
