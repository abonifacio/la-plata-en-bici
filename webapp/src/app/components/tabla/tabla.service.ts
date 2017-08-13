import { QueryDataSource, TrackingDataSource } from './datasources';
import { Observable } from 'rxjs/Rx';
import { Page, Pageable } from '../../entities/common';
import { CrudService } from '../../services/crud.service';
import { Injectable } from '@angular/core';
import { Sort,PageEvent } from '@angular/material';

@Injectable()
export class TablaService {

  service:CrudService<any>;
  private dataSource:QueryDataSource;
  private pageable: Pageable = new Pageable();
  private query :any = {};
  constructor() {

  }

  setService(service:CrudService<any>){
    this.service = service;
    this.refreshTable();
  }

  refreshTable(){
    if(this.service instanceof CrudService){
      this.dataSource = new QueryDataSource(this.service,this.pageable,this.query);
    }else{
      this.dataSource = new TrackingDataSource(this.service,this.pageable,this.query);
    }
  }

  sortData(sort:Sort){
    if(sort.active && sort.direction){
      this.pageable.sort = sort.active;
      this.pageable.ascending = sort.direction=='asc';
    }
    this.refreshTable();
  }

  updateQuery(query:any){
    this.query = query;
    this.refreshTable();
  }

  pageChange(page:PageEvent){
    this.pageable.count = page.pageSize;
    this.pageable.page = page.pageIndex;
    this.refreshTable();
  }

}
