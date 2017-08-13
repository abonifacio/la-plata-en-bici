import { Page, Pageable } from '../entities/common';
import { Observable } from 'rxjs/Rx';
import { CrudService } from './crud.service';
import { Entity } from '../entities/entity';
export class TrackingService<T extends Entity> extends CrudService<T>{
    
    query(pageable?:Pageable,query?:any):Observable<Page<T>>{
        if(!query) query = {};
        for(let key in pageable){
            query[key] = pageable[key];
        }
        let options = {
            search : query
        }
        return this.http.get(this.URI,options);
    }
}