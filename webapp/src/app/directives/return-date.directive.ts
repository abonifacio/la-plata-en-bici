import { CustomDatePipe } from './cdate.pipe';
import { AccountService } from '../services/account.service';
import { ElementRef, Directive, Renderer2,Input,OnInit } from '@angular/core';

@Directive({
  selector: '[returnDate]'
})
export class ReturnDateDirective implements OnInit{

  @Input() returnDate: Date;

  constructor(private el:ElementRef,private renderer:Renderer2,private datePipe :CustomDatePipe) {
  }

  ngOnInit(){
    if(!this.returnDate) return;
    if(!this.returnDate.getDate){
        this.returnDate = new Date(this.returnDate);
    }
    let now  = new Date();

    this.el.nativeElement.innerHTML = this.datePipe.transform(this.returnDate);
    
    if(now.getTime()<this.returnDate.getTime()){
        this.renderer.addClass(this.el.nativeElement,'text-success');
    }else{
        this.renderer.addClass(this.el.nativeElement,'text-danger');
    }

  }


}
