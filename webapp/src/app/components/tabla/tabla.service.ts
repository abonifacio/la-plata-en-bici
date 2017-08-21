import { TableDataSource, QueryDataSource,HistorialDataSource } from './datasources';
import { Observable } from 'rxjs/Rx';
import { Page, Pageable } from '../../entities/common';
import { CrudService } from '../../services/crud.service';
import { Injectable } from '@angular/core';
import { Sort,PageEvent } from '@angular/material';

@Injectable()
export class TablaService {

  service:any;
  private dataSource:TableDataSource;
  private pageable: Pageable = new Pageable();
  private query :any = {};
  private type: String;
  private params:any;
  constructor() {

  }

  setService(service:CrudService<any>,type?:String,params?:any){
    this.service = service;
    this.type = type || 'listado';
    this.params = params;
    this.refreshTable();
  }

  refreshTable(){
    switch(this.type){
      case 'listado':
        this.dataSource = new QueryDataSource(this.service,this.pageable,this.query);
      break;
      case 'historial':
        this.dataSource = new HistorialDataSource(this.service,this.params,this.pageable,this.query);
      break;
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
