import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SelectComponent } from './select.component';
import { MessagesModule } from '../messages/messages.module';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [SelectComponent],
  imports: [
    CommonModule,
    MessagesModule,
    FormsModule
  ],
  exports: [SelectComponent]
})
export class SelectModule { }
