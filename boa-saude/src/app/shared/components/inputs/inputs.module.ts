import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputsComponent } from './inputs.component';
import { FormsModule } from '@angular/forms';
import { MessagesModule } from '../messages/messages.module';



@NgModule({
  declarations: [InputsComponent],
  imports: [
    CommonModule,
    FormsModule,
    MessagesModule
  ],
  exports: [InputsComponent]
})
export class InputsModule { }
