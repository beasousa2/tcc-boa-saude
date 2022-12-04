export interface CriarAssociado {
  nome: string;
  dataNascimento: string;
  cpf: string;
  rg: string;
  orgaoEmissor: string;
  dataEmissao: string;
  telefone: string;
  email: string;
  estadoCivil: string;
  genero: string;
  plano: Plano;
  endereco: Endereco;
}

export interface Plano {
  descricao: string;
  odontologico: boolean;
  enfermaria: boolean;
  apartamento: boolean;
  precoMensalidade: number;
}

export interface Endereco {
  logradouro: string;
  cep: string;
  numero: string;
  complemento: string;
  bairro: string;
  cidade: string;
  uf: string;
}

export interface Associado {
  id: string;
  nome: string;
  email: string;
  matricula: string;
  status: string;
}



