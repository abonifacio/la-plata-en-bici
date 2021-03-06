import { Router } from '@angular/router';
import { ConditionFunc } from 'rxjs/observable/GenerateObservable';
import { Component, OnInit } from '@angular/core';
import { Response } from '@angular/http';
import {HttpRequestSubscriber} from '../../services/app-http.service';
import { MdSnackBar,MdSnackBarConfig } from '@angular/material';

@Component({
  selector: 'app-loading',
  templateUrl: './loading.component.html',
  styleUrls: ['./loading.component.less']
})
export class LoadingComponent implements OnInit {

  pending: String[] = [];
  constructor(private reqSub: HttpRequestSubscriber,private snackbar: MdSnackBar,private router:Router) { }

  ngOnInit() {
    this.reqSub.request.subscribe((url)=>{
      this.pending.push(url);
    });
    this.reqSub.response.subscribe((res:Response)=>{
      this.pending.pop();
      this.evaluate(res);
    });
  }

  private evaluate(res:Response){
    let message = res.headers.get('LPB-Message');
    if(!message) return;
    
    let classes = [];
    if(res.status<300){ //ok
      classes.push('success');
    }else if(res.status==401){ // unauthorized
      classes.push('warning');
      this.router.navigate(['/login']);
    }else if(res.status==403){ // fordibben
      // ir a fordibben
      classes.push('danger');
      this.router.navigate(['/']);
    }else if(res.status<500){ // bad request
      classes.push('warning');
    }else{ // server error
      classes.push('danger');
    }

    let config = new MdSnackBarConfig();
    config.duration = 3000;
    config.extraClasses = classes;
    this.snackbar.open(message,'Cerrar',config);
    
  }

}
