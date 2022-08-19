import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlanosRoutingModule } from './planos-routing.module';
import { HeaderModule } from '../shared/components/header/header.module';
import { FooterModule } from '../shared/components/footer/footer.module';
import { CardsModule } from '../shared/components/cards/cards.module';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    PlanosRoutingModule,
    HeaderModule,
    FooterModule,
    CardsModule
  ]
})
export class PlanosModule { }
