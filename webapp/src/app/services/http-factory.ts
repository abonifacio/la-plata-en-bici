import {XHRBackend, Http, RequestOptions} from "@angular/http";
import {AppHttp,HttpRequestSubscriber} from "./app-http.service";

export function httpFactory(xhrBackend: XHRBackend, requestOptions: RequestOptions,requestSub : HttpRequestSubscriber): Http {
    return new AppHttp(xhrBackend, requestOptions,requestSub);
}