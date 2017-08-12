import { TablaService } from '../../services/tabla.service';
import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-paginator',
  templateUrl: './paginator.component.html'
})
export class PaginatorComponent implements OnInit {
  @Input() tabla:TablaService;

  constructor() { }

  ngOnInit() {
  }

}
