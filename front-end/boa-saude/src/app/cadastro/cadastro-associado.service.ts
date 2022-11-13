import { Injectable } from '@angular/core';
import { HttpService } from '../service/http.service';

@Injectable({
  providedIn: 'root'
})
export class CadastroAssociadoService {

  constructor(private http: HttpService) { }

  cadastroAssociado<CriarAssociado>(data: CriarAssociado) {
    const associado = JSON.stringify(data);
    this.http.post('associados', associado);
  }


}
