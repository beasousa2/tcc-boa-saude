export interface Consulta {
id: number;
dataHora: string;
codigoMedico?: string;
codigoConveniado?: string;
descricao: string;
}

export interface Consultas extends Array<Consulta>{}

export interface ConsultasAPI {
  payload: Consultas;
}

export interface ConsultaAPI {
  payload: Consulta;
}
