import { HttpClient, HttpHeaders, HttpParams, HttpStatusCode } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable, Subscription } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private httpClient: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  get<T>(route: string, value?: any, object?: any): Observable<any> {
    const params = value ? new HttpParams().append('value', value) : undefined;
    return this.httpClient.get<T>(`http://localhost:3000/${route}/`, { params });
  }

  post<T>(route: string, data: any): Subscription {
    return this.httpClient.post<T>(`http://localhost:3000/${route}/`, data, this.httpOptions).subscribe(() => {
      HttpStatusCode.Created
    });
    ;
  }

  delete() {

  }

  update() {

  }
}
