import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CardInfoMedicalComponent } from './card-info-medical/card-info-medical.component';
import { CardEventoComponent } from './card-evento/card-evento.component';
import { CardRetornoComponent } from './card-retorno/card-retorno.component';
import { CardExameComponent } from './card-exame/card-exame.component';



@NgModule({
  declarations: [
    CardInfoMedicalComponent,
    CardEventoComponent,
    CardRetornoComponent,
    CardExameComponent],
  imports: [
    CommonModule
  ],
  exports: [
    CardInfoMedicalComponent,
    CardEventoComponent,
    CardRetornoComponent,
    CardExameComponent
  ]
})
export class DashComponentsModule { }
