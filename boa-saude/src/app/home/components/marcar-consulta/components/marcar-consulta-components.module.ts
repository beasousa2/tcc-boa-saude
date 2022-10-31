import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BuscaComponent } from './busca/busca.component';
import { EnderecoComponent } from './endereco/endereco.component';
import { ResultadoBuscaComponent } from './resultado-busca/resultado-busca.component';
import { InputsModule } from 'src/app/shared/components/inputs/inputs.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { SelectFormModule } from 'src/app/shared/components/select-form/select-form.module';



@NgModule({
  declarations: [
    BuscaComponent,
    EnderecoComponent,
    ResultadoBuscaComponent
  ],
  imports: [
    CommonModule,
    InputsModule,
    SelectFormModule
  ],
  exports: [
    BuscaComponent,
    EnderecoComponent,
    ResultadoBuscaComponent
  ]
})
export class MarcarConsultaComponentsModule { }
