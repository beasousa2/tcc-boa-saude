import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MarcarConsultaComponent } from './marcar-consulta.component';

import { MarcarConsultaComponentsModule } from './components/marcar-consulta-components.module';
import { InputsModule } from 'src/app/shared/components/inputs/inputs.module';
import { SelectFormModule } from 'src/app/shared/components/select-form/select-form.module';

@NgModule({
  declarations: [
    MarcarConsultaComponent
    ],
  imports: [
    CommonModule,
    MarcarConsultaComponentsModule,
    InputsModule,
    SelectFormModule
  ],
  exports: [MarcarConsultaComponent]
})
export class MarcarConsultaModule { }
