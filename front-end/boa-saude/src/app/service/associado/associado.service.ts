import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Associado } from 'src/app/models/associado.model';
import { catchError, Observable, tap, throwError } from 'rxjs';

const ROUTE = 'http://localhost:8083/v1/api/associado';

@Injectable({
  providedIn: 'root'
})


export class AssociadoService {


  constructor(private httpClient: HttpClient) { }

  getAssociado(id: string): Observable<Associado> {
    const headers =  new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    headers.append('Access-Control-Allow-Origin', '*');
    headers.append('Access-Control-Allow-Methods', 'GET, POST, PUT, PATCH, DELETE, OPTIONS')
    headers.append('Access-Control-Allow-Headers',
    'Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers')
    return this.httpClient.get<Associado>(`http://localhost:8000/associado/${id}`, {headers: headers})
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Erro ocorreu no lado do client
      errorMessage = error.error.message;
    } else {
      // Erro ocorreu no lado do servidor
      errorMessage = `Código do erro: ${error.status}, ` + `menssagem: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  };
}
