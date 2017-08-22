import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.less']
})
export class ChartComponent implements OnInit {

  @Input('values') values:{label:string,value:number,pct:number,css:string}[];

  total = 0;
  constructor() { }

  ngOnInit() {
    let classes = ['success','warning','danger','default'];
    this.values.forEach(val=>{
      this.total = this.total + val.value;
    });
    this.values.map(val=>{
      val.pct = val.value / this.total * 100;
      val.css = classes.shift();
      return val;
    });

  }

}
