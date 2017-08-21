import { BicicletaService } from '../../bicicletas/bicicletas.service';
import { Observable } from 'rxjs/Rx';
import { Page, Pageable } from '../../entities/common';
import { CrudService } from '../../services/crud.service';
import { DataSource } from '@angular/cdk';

export abstract class TableDataSource extends DataSource<any>{

  protected numItems:Number;

  constructor(protected pageable:Pageable,protected query:any){
    super();
  }

  connect():Observable<any[]>{
    return this.doRequest().map((page:Page<any>)=> {
      this.numItems = page.totalItems;
      this.pageable.page = page.currentPage;
      return page.items;
    });
  }

  abstract doRequest():Observable<Page<any>>;

  currentPage():Number{
    return this.pageable.page;
  }

  totalItems(){
    return this.numItems;
  }
  
  disconnect(){

  }

}


export class QueryDataSource extends TableDataSource{

    constructor(private service:CrudService<any>,pageable:Pageable,query:any){
      super(pageable,query);
    }
     doRequest(): Observable<Page<any>> {
        return this.service.query(this.pageable,this.query);
    }
}


export class HistorialDataSource extends TableDataSource{

    constructor(private service: BicicletaService,private params:any,pageable:Pageable,query:any){
      super(pageable,query);
    }

     doRequest(): Observable<Page<any>> {
       return this.service.historial(this.params.id,this.pageable);
    }
}