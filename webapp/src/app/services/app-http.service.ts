import { Options } from 'iconv-lite/lib';
import { stringify } from 'querystring';
import { ObservableInput } from 'rxjs/Observable';
import { Observable, Observer, Subject } from 'rxjs/Rx';
import { Http,ConnectionBackend,RequestOptions,Headers,RequestOptionsArgs, Request,Response } from '@angular/http';
import { Injectable } from '@angular/core';

@Injectable()
export class AppHttp extends Http{

  private API: string = '/rest/';

  constructor(backend: ConnectionBackend, defaultOptions: RequestOptions,private reqSub: HttpRequestSubscriber) {
      super(backend, defaultOptions);
  }

  get(url: string, options?: RequestOptionsArgs): Observable<any> {
      return this.intercept(super.get(this.API+url, this.addToken(options)));
  }

  post(url: string, body: any, options?: RequestOptionsArgs): Observable<any> {
    return this.intercept(super.post(this.API+url,this.stringify(body), this.addJsonHeader(options)));
  }

  put(url: string, body: any, options?: RequestOptionsArgs): Observable<any> {
      return this.intercept(super.put(this.API+url,this.stringify(body), this.addJsonHeader(options)));
  }

  delete(url: string, options?: RequestOptionsArgs): Observable<any> {
      return this.intercept(super.delete(this.API+url, this.addToken(options)));
  }

  private addJsonHeader(opt:RequestOptionsArgs):RequestOptionsArgs{
    opt = this.addToken(opt);
    opt.headers.append('Content-Type','application/json');
    return opt;
  }

  private addToken(opt:RequestOptionsArgs):RequestOptionsArgs{
    if(!opt){
      opt = new RequestOptions();
    }
    if(!opt.headers){
      opt.headers = new Headers();
    }
    let token = localStorage.getItem('authToken');
    opt.headers.append('Authorization',token);
    return opt;
  }

  private intercept(obs:Observable<any>):Observable<any>{
    this.reqSub.request.next('req');

    return obs.map((res:Response)=>{
      let ret = res.json();
      this.reqSub.response.next(res);
      let authToken = res.headers.get('Authorization');
      localStorage.setItem('authToken',authToken);
      return ret;
    })
    .catch((res :Response, obs : Observable<any>)=>{
      this.reqSub.response.next(res);
      return Observable.throw('Server error');
    });
  }

  private stringify(object : any){
    return JSON.stringify(object);
  }

}

@Injectable()
export class HttpRequestSubscriber{
  request:Subject<String> = new Subject<String>();
  response:Subject<Response> = new Subject<Response>();
}
