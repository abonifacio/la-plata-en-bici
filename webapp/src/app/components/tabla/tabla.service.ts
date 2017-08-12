import { Observable } from 'rxjs/Rx';
import { Page, Pageable } from '../../entities/common';
import { CrudService } from '../../services/crud.service';
import { Injectable } from '@angular/core';
import { DataSource } from '@angular/cdk';
import { Sort,PageEvent } from '@angular/material';

@Injectable()
export class TablaService {

  service:CrudService<any>;
  private dataSource:TableDataSource;
  private pageable: Pageable = new Pageable();
  constructor() {

  }

  setService(service:CrudService<any>){
    this.service = service;
    this.refreshTable();
  }

  refreshTable(){
    this.dataSource = new TableDataSource(this.service,this.pageable);
  }

  sortData(sort:Sort){
    if(sort.active && sort.direction){
      this.pageable.sort = sort.active;
      this.pageable.ascending = sort.direction=='asc';
    }
    this.refreshTable();
  }

  render(col,row){
    return col.parse(row[col.name],row) || '';
  }

  pageChange(page:PageEvent){
    this.pageable.count = page.pageSize;
    this.pageable.page = page.pageIndex;
    this.refreshTable();
  }

}

class TableDataSource extends DataSource<any>{

  private numItems:Number;

  constructor(private service: CrudService<any>,private pageable:Pageable){
    super();
  }

  connect():Observable<any[]>{
    return this.service.query(this.pageable).map((page:Page<any>)=> {
      this.numItems = page.totalItems;
      this.pageable.page = page.currentPage;
      return page.items;
    });
  }

  currentPage():Number{
    return this.pageable.page;
  }

  totalItems(){
    return this.numItems;
  }
  
  disconnect(){

  }

}