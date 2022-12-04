import { Component, OnInit } from '@angular/core';
import { AssociadoService } from 'src/app/service/associado/associado.service';
import { Subscription, tap } from 'rxjs';
import { Associado } from 'src/app/models/associado.model';
import { HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  associado!: Subscription;



  constructor(private service: AssociadoService) { }

  ngOnInit(): void {
    console.log("Dashboard")
    this.service.getAssociado("6376866ad9712b0c0582d4d3").subscribe(res => console.log(res.nome))

  }

  getAssociado(){

  }
}
