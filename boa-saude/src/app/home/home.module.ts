import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { HeaderModule } from './shared/components/header/header.module';
import { MenuModule } from './shared/components/menu/menu.module';

import { DashboardModule } from './components/dashboard/dashboard.module';
import { MarcarConsultaModule } from './components/marcar-consulta/marcar-consulta.module';
import { InputsModule } from '../shared/components/inputs/inputs.module';
import { SelectFormModule } from '../shared/components/select-form/select-form.module';
import { RouterModule } from '@angular/router';
import { PrestadorModule } from './components/prestador/prestador.module';


@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    HeaderModule,
    MenuModule,
    DashboardModule,
    MarcarConsultaModule,
    PrestadorModule,
    InputsModule,
    SelectFormModule,
    RouterModule
  ],
  exports: [
  ]
})
export class HomeModule { }
