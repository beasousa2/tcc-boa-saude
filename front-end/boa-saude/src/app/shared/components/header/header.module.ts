import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header.component';
import { MatSelectModule } from '@angular/material/select'



@NgModule({
  declarations: [HeaderComponent],
  imports: [
    CommonModule,
    MatSelectModule

  ],
  exports: [HeaderComponent]
})
export class HeaderModule { }
