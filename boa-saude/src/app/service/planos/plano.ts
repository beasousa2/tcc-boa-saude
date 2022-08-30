export class FaixaValores {

  getFaixaValor(idade: number) {
    let valor: number = 0;

    if(idade <= 18) {
      valor = 100;
    }
    if(idade >= 19 && idade < 24) {
      valor = 110;
    }

    if(idade >= 24 && idade < 29) {
      valor = 121;
    }
    if(idade >= 29 && idade < 34) {
      valor = 133 ;
    }
    if(idade >= 34 && idade < 39) {
      valor = 146 ;
    }

    if(idade >= 39 && idade < 44) {
      valor = 160 ;
    }

    if(idade >= 44 && idade < 49) {
      valor = 176 ;
    }

    if(idade >= 49 && idade < 54) {
      valor = 187 ;
    }

    if(idade >= 54 && idade < 59) {
      valor = 206;
    }

    if(idade >= 59) {
      valor = 227;
    }

    return valor;

  }


  faixas = [
    {
      minIdade: 0,
      maxIdade: 18
    },
    {
      minIdade: 19,
      maxIdade: 23
    },
    {

      minIdade: 24,
      maxIdade: 28
    },
    {

      minIdade: 29,
      maxIdade: 33
    },
    {

      minIdade: 34,
      maxIdade: 38
    },
    {

      minIdade: 39,
      maxIdade: 43
    },
    {

      minIdade: 44,
      maxIdade: 48
    },
    {

      minIdade: 49,
      maxIdade: 53
    },
    {

      minIdade: 54,
      maxIdade: 58
    },
    {
      minIdade: 59,
      maxIdade: 100
    }
  ]
}

export interface Plano {
  id: number;
  descricao: string,
  odontologico: boolean,
  enfermaria: boolean,
  apartamento: boolean,
  precoMensalidade: number
}

export interface Planos extends Array<Plano>{}

export interface PlanosApi {
  payload: Planos
}
