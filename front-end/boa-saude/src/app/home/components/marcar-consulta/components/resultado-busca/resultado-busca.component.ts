import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-resultado-busca',
  templateUrl: './resultado-busca.component.html',
  styleUrls: ['./resultado-busca.component.scss']
})
export class ResultadoBuscaComponent implements OnInit {
  @Input()
  rota!: String;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  add() {
    this.router.navigate(['/home/'+this.rota])
  }

}
