import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputsPasswordComponent } from './inputs-password.component';
import { MatIconModule } from '@angular/material/icon';



@NgModule({
  declarations: [InputsPasswordComponent],
  imports: [
    CommonModule,
    MatIconModule
  ],
  exports: [InputsPasswordComponent]
})
export class InputsPasswordModule { }
