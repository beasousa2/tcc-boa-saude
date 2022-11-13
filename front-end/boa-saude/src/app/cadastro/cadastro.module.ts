import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastroRoutingModule } from './cadastro-routing.module';
import { HeaderModule } from '../shared/components/header/header.module';
import { FooterModule } from '../shared/components/footer/footer.module';
import { InputsModule } from '../shared/components/inputs/inputs.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MessagesModule } from '../shared/components/messages/messages.module';
import { SelectModule } from '../shared/components/select/select.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    CadastroRoutingModule,
    HeaderModule,
    FooterModule,
    InputsModule,
    FormsModule,
    ReactiveFormsModule,
    MessagesModule,
    SelectModule
  ]
})
export class CadastroModule { }
