import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { HeaderModule } from '../shared/components/header/header.module';
import { PaginaInicialRoutingModule } from './pagina-inicial-routing.module';
import { PaginaInicialComponent } from './pagina-inicial.component';
import { TextosInicioComponent } from './components/textos-inicio/textos-inicio.component';
import { BeneficiosComponent } from './components/beneficios/beneficios.component';
import { MaterialModule } from '../shared/modules/material/material.module';
import { SharedModule } from '../shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TextoInicioModule } from './components/textos-inicio/textos-inicio.module';



@NgModule({
  declarations: [PaginaInicialComponent, BeneficiosComponent],
  imports: [
    CommonModule,
    PaginaInicialRoutingModule,
    HeaderModule,
    MaterialModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
    TextoInicioModule
  ]
})
export class PaginaInicialModule { }
