import { CachedResourceLoader } from '@angular/platform-browser-dynamic/src/resource_loader/resource_loader_cache';
import { Entity } from '../entities/entity';
import { isEntityName, isEntityNameExpression } from 'tsutils';
import { AppHttp } from '../services/app-http.service';
import { Observable } from 'rxjs/Rx';
import { Page, Pageable } from '../entities/common';

export class CrudService<T extends Entity> {

    private cached:T = undefined;

    constructor(protected http: AppHttp,protected URI:string) {

    }

    query(pageable?:Pageable):Observable<Page<T>>{
        let options = {
            search : pageable
        }
        return this.http.get(this.URI,options);
    }

    list():Observable<T[]>{
        return this.http.get(this.URI+'/list');
    }

    get(id:number):Observable<T>{
        if(this.cached && this.cached.id==id){
            return Observable.of(this.cached);
        }
        return this.http.get(this.URI+'/'+id);
    }

    private create(entity:T):Observable<T>{
        return this.http.post(this.URI,entity);
    }

    private update(entity:T):Observable<T>{
        return this.http.put(this.URI,entity);
    }

    save(entity:T):Observable<T>{
        if(entity.id){
            return this.update(entity);
        }else{
            return this.create(entity);
        }
    }

    cache(entity:T){
        this.cached = entity;
    }

    delete(id:number):Observable<T>{
        return this.http.delete(this.URI+'/'+id);
    }

}