import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { PlanoService } from 'src/app/service/planos/plano.service';

@Component({
  selector: 'app-textos-inicio',
  templateUrl: './textos-inicio.component.html',
  styleUrls: ['./textos-inicio.component.scss'],

})
export class TextosInicioComponent implements OnInit {

  idadeForm!: FormGroup;
  constructor(private formBuilder: FormBuilder, private router: Router, private planoService: PlanoService) { }

  ngOnInit(): void {
    this.idadeForm = this.formBuilder.group({
      idade: []
    })
  }

  setIdade() {
    console.log(this.idadeForm.get('idade')?.value)
    let idade = this.idadeForm.get('idade')?.value
    this.planoService.setIdade(idade);
    this.router.navigate(['planos', idade])
  }

}
