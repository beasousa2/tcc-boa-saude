import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

const CPF = '([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.scss']
})
export class CadastroComponent implements OnInit {

  cadastroAssociado!: FormGroup;

  constructor(private formBuilder: FormBuilder) { }

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



  register() {
    console.log(this.cadastroAssociado.get('nomeCompleto')?.value)
    console.log(this.cadastroAssociado.get('nomeCompleto')?.touched)
    console.log(this.cadastroAssociado.get('nomeCompleto')?.errors?.['minLength(10)'])
  }

}
