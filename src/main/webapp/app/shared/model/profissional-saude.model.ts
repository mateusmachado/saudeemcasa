import { Moment } from 'moment';

export interface IProfissionalSaude {
  id?: number;
  email?: string;
  nomeCompleto?: string;
  dataNascimento?: Moment;
  nomeMae?: string;
  nomePai?: string;
  nacionalidade?: string;
  rgRne?: string;
  orgaExpedidorUf?: string;
  cpf?: number;
  estadoCivil?: string;
  pisPasep?: number;
  profissaoAreaAtuacao?: string;
  numeroRegistroProfissional?: number;
  uf?: string;
  rqeComprovanteEspecializacao?: string;
  comprovanteResidenciaMedica?: string;
  numeroCartaoSus?: number;
  enderecoResidencialComercial?: string;
  numero?: number;
  complemento?: string;
  bairro?: string;
  cidade?: string;
  cep?: number;
  telefoneFixo?: number;
  celular?: number;
  dataCadastro?: Moment;
}

export class ProfissionalSaude implements IProfissionalSaude {
  constructor(
    public id?: number,
    public email?: string,
    public nomeCompleto?: string,
    public dataNascimento?: Moment,
    public nomeMae?: string,
    public nomePai?: string,
    public nacionalidade?: string,
    public rgRne?: string,
    public orgaExpedidorUf?: string,
    public cpf?: number,
    public estadoCivil?: string,
    public pisPasep?: number,
    public profissaoAreaAtuacao?: string,
    public numeroRegistroProfissional?: number,
    public uf?: string,
    public rqeComprovanteEspecializacao?: string,
    public comprovanteResidenciaMedica?: string,
    public numeroCartaoSus?: number,
    public enderecoResidencialComercial?: string,
    public numero?: number,
    public complemento?: string,
    public bairro?: string,
    public cidade?: string,
    public cep?: number,
    public telefoneFixo?: number,
    public celular?: number,
    public dataCadastro?: Moment
  ) {}
}
