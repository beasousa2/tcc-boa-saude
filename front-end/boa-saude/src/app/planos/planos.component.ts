import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { map, Observable, Subscription, tap } from 'rxjs';
import { HttpService } from '../service/http.service';
import { FaixaValores, PlanosApi } from '../service/planos/plano';
import { PlanoService } from '../service/planos/plano.service';

@Component({
  selector: 'app-planos',
  templateUrl: './planos.component.html',
  styleUrls: ['./planos.component.scss']
})
export class PlanosComponent implements OnInit {

  valorFaixa = new FaixaValores();
  enfermariaI: number = 0;
  enfermariaII: number = 0;
  apartamentoI: number = 0;
  apartamentoII: number = 0;

  $subs!: Subscription;
  idade!: number;
  planos = this.planoService.getPlanos();


  constructor(private planoService: PlanoService, private route: ActivatedRoute, private http: HttpService) { }

  ngOnInit(): void {
   this.route.params.subscribe(params => {
      this.idade = +params['age']
    })
    this.enfermariaI = this.calculaPlanoI(this.idade);
    this.enfermariaII = this.calculaPlanoII(this.idade);
    this.apartamentoI = this.calculaPlanoIII(this.idade);
    this.apartamentoII = this.calculaPlanoIV(this.idade);


  }

  valores = [120, 150, 200, 250]

  calculaPlanoI(idade: number) {
    let precoIdade = this.valorFaixa.getFaixaValor(idade)
    return precoIdade + this.valores[0]
  }

  calculaPlanoII(idade: number) {
    let precoIdade = this.valorFaixa.getFaixaValor(idade)
    return precoIdade + this.valores[1]
  }

  calculaPlanoIII(idade: number) {
    let precoIdade = this.valorFaixa.getFaixaValor(idade)
    return precoIdade + this.valores[2]
  }

  calculaPlanoIV(idade: number) {
    let precoIdade = this.valorFaixa.getFaixaValor(idade)
    return precoIdade + this.valores[3]
  }

}
