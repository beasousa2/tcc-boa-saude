import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CriarAssociado, Endereco, Plano } from '../models/associado.model';
import { CadastroAssociadoService } from './cadastro-associado.service';

const CPF = '([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.scss']
})
export class CadastroComponent implements OnInit {

  cadastroAssociado!: FormGroup;

  planoAssociado = {
    descricao: 'Apartamento II',
    odontologico: true,
    enfermaria: true,
    apartamento: true,
    precoMensalidade: 500.00
  }

  genero: string = '';
  estadoCivil: string = '';
  buttonDisabled: boolean = true;

  generoOptions = [{value: 'Feminino'}, {value: 'Masculino'}];
  estadoCivilOptions = [
    {value: 'Solteiro'},
    {value: 'Casado'},
    {value: 'União Estável'},
    {value: 'Divorciado'},
    {value: 'Viúvo'}]

  constructor(private formBuilder: FormBuilder, private service: CadastroAssociadoService) { }

  ngOnInit(): void {

    this.cadastroAssociado = this.formBuilder.group({
      nomeCompleto: ['', [
        Validators.required,
        Validators.maxLength(100),
        Validators.minLength(10)
      ]],
      dataNascimento: ['', [
        Validators.required
      ]],
      cpf: ['', [
        Validators.required,
        Validators.pattern(CPF)
      ]],
      rg: ['', [
        Validators.required
      ]],
      dataEmissao: ['', [
        Validators.required
      ]],
      orgaoEmissor: ['', [
        Validators.required
      ]],
      genero: ['', [
        Validators.required
      ]],
      estadoCivil: ['', [
        Validators.required
      ]],
      cep: ['', [
        Validators.required
      ]],
      endereco: ['', [
        Validators.required
      ]],
      numero: ['', [
        Validators.required
      ]],
      complemento: [],
      bairro: ['', [
        Validators.required
      ]],
      cidade: ['', [
        Validators.required
      ]],
      uf: ['', [
        Validators.required
      ]],
      telefone: ['', [
        Validators.required
      ]],
      email: ['', [
        Validators.required,
        Validators.email
      ]],
      confirmarEmail: ['', [
        Validators.required,
        Validators.email
      ]]

    });
  }

  selectGenero(value: string): any {
    return this.genero = value;
  }

  selectEstadoCivil(value: string): any {
    return this.estadoCivil = value;
  }

  onCheckboxChange(event: any) {
    if(event.target.checked) {
      this.buttonDisabled = false;
    } else {
      this.buttonDisabled = true;
    }

  }

  register() {
    this.cadastroAssociado.valid ? this.cadastroAssociado : false;
    const endereco: Endereco = {
      logradouro: this.cadastroAssociado.get('endereco')?.value,
      cep: this.cadastroAssociado.get('cep')?.value,
      numero: this.cadastroAssociado.get('numero')?.value,
      complemento: this.cadastroAssociado.get('complemento')?.value,
      bairro: this.cadastroAssociado.get('bairro')?.value,
      cidade: this.cadastroAssociado.get('cidade')?.value,
      uf: this.cadastroAssociado.get('uf')?.value
    }
    const plano: Plano = {
      descricao: this.planoAssociado.descricao,
      odontologico: this.planoAssociado.odontologico,
      enfermaria: this.planoAssociado.enfermaria,
      apartamento: this.planoAssociado.apartamento,
      precoMensalidade: this.planoAssociado.precoMensalidade
    }

    const user: CriarAssociado = {
      nome: this.cadastroAssociado.get('nomeCompleto')?.value,
      dataNascimento: this.cadastroAssociado.get('dataNascimento')?.value,
      cpf: this.cadastroAssociado.get('cpf')?.value,
      rg: this.cadastroAssociado.get('rg')?.value,
      orgaoEmissor: this.cadastroAssociado.get('orgaoEmissor')?.value,
      dataEmissao: this.cadastroAssociado.get('dataEmissao')?.value,
      telefone: this.cadastroAssociado.get('telefone')?.value,
      email: this.cadastroAssociado.get('email')?.value,
      estadoCivil: this.estadoCivil,
      genero: this.genero,
      plano: plano,
      endereco: endereco
    }

    console.log(user)
    this.service.cadastroAssociado(user);
  }



}
