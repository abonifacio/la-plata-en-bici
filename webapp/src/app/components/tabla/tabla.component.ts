import { CrudService } from '../../services/crud.service';
import { Component, OnInit,Input,EventEmitter,Output } from '@angular/core';
import { DataSource } from '@angular/cdk';
import { Sort,PageEvent } from '@angular/material';
import { Observable } from 'rxjs/Rx';
import { Page, Pageable,Column } from '../../entities/common';

@Component({
  selector: 'app-tabla',
  templateUrl: './tabla.component.html',
  styleUrls: ['./tabla.component.less']
})


export class TablaComponent implements OnInit {
  
  @Input() service:CrudService<any>;
  @Input() columns:Column[];
  @Output() verMas:EventEmitter<Number> = new EventEmitter();
  private dataSource:TableDataSource;
  private pageable: Pageable = new Pageable;
  columnsSimple: string[];

  constructor() { 
  }

  ngOnInit() {
    this.columnsSimple = this.columns.map((c)=>c.name);
    this.columnsSimple.push('ver');
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

  emitVer(id:Number){
    this.verMas.emit(id);
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
