import { Component, OnInit } from '@angular/core';
import { AssociadoService } from 'src/app/service/associado/associado.service';
import { map, Subscription, tap } from 'rxjs';
import { Associado } from 'src/app/models/associado.model';
import { HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  associado$ = this.service.getAssociado("6376866ad9712b0c0582d4d3");
  result!: Associado;

  constructor(private service: AssociadoService) { }

  ngOnInit(): void {
    this.associado$.subscribe((res) => (this.result = res.payload))
  }

  getAssociadoById(): void {
    this.service.getAssociado("6376866ad9712b0c0582d4d3").subscribe()
  }


}
