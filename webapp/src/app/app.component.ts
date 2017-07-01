import { Observable } from 'rxjs/Rx';
import { NavigationEnd,ActivatedRouteSnapshot, Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [
    './app.component.less'
  ]
})
export class AppComponent{
  
  private title:Observable<String>;;

  constructor(private router:Router){
    this.title = this.router.events
    .filter((event)=> event instanceof NavigationEnd)
    .map(()=> this.getTitle(this.router.routerState.snapshot.root));
    
  }

  private getTitle(routeSnapshot: ActivatedRouteSnapshot) {
    var title = routeSnapshot.data ? routeSnapshot.data['title'] : '';
    if (routeSnapshot.firstChild) {
      title = this.getTitle(routeSnapshot.firstChild) || title;
    }
    return title;
  }
  


}
