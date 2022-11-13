import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderModule } from './components/header/header.module';
import { FooterModule } from './components/footer/footer.module';
import { InputsModule } from './components/inputs/inputs.module';
import { InputsPasswordModule } from './components/inputs-password/inputs-password.module';
import { CardsModule } from './components/cards/cards.module';
import { MessagesModule } from './components/messages/messages.module';
import { SelectModule } from './components/select/select.module';
import { SelectFormModule } from './components/select-form/select-form.module';



@NgModule({
  declarations: [

  ],
  imports: [
    CommonModule
  ],
  exports: [
    HeaderModule,
    FooterModule,
    InputsModule,
    InputsPasswordModule,
    CardsModule,
    MessagesModule,
    SelectModule,
    SelectFormModule
  ]
})
export class SharedModule { }
