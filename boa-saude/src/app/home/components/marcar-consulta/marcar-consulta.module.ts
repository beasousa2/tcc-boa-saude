import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MarcarConsultaComponent } from './marcar-consulta.component';

import { MarcarConsultaComponentsModule } from './components/marcar-consulta-components.module';
import { InputsModule } from 'src/app/shared/components/inputs/inputs.module';
import { SelectFormModule } from 'src/app/shared/components/select-form/select-form.module';
import { PrestadorComponent } from './prestador/prestador.component';
import { MarcarConsultaRoutingModule } from './marcar-consulta-routing.module';
import { BuscarPrestadorComponent } from './buscar-prestador/buscar-prestador.component';



@NgModule({
  declarations: [
    MarcarConsultaComponent,
    PrestadorComponent,
    BuscarPrestadorComponent
    ],
  imports: [
    CommonModule,
    MarcarConsultaComponentsModule,
    InputsModule,
    SelectFormModule,
    MarcarConsultaRoutingModule
  ],
  exports: [MarcarConsultaComponent,PrestadorComponent, BuscarPrestadorComponent]
})
export class MarcarConsultaModule { }
