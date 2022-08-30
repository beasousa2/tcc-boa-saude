import { Injectable } from '@angular/core';
import { map, Observable, Subject, tap } from 'rxjs';
import { HttpService } from '../http.service';
import { Planos, PlanosApi } from './plano';

@Injectable({
  providedIn: 'root'
})
export class PlanoService {

  subject = new Subject<number>();

  constructor(private http: HttpService) { }

  setIdade(idade: number) {
    this.subject.next(idade);
  }

  getIdade(): Observable<number> {
    return this.subject.asObservable();
  }

  getPlanos() {
    return this.http.get<PlanosApi>('planos').pipe(
      map(x => x?.payload),
      tap((valor) => {console.log(valor)})
      );
  }

}
