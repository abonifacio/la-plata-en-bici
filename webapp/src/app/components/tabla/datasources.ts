import { Observable } from 'rxjs/Rx';
import { Page, Pageable } from '../../entities/common';
import { CrudService } from '../../services/crud.service';
import { DataSource } from '@angular/cdk';

abstract class TableDataSource extends DataSource<any>{

  protected numItems:Number;

  constructor(protected service: CrudService<any>,protected pageable:Pageable,protected query:any){
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

     doRequest(): Observable<Page<any>> {
        return this.service.query(this.pageable,this.query);
    }
}

export class TrackingDataSource extends TableDataSource{

    doRequest(): Observable<Page<any>> {
        return this.service.query(this.pageable);
    }
}