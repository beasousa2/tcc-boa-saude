import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashComponentsModule } from './components/dash-components.module';
import { DashboardComponent } from './dashboard.component';
import { InputsModule } from 'src/app/shared/components/inputs/inputs.module';



@NgModule({
  declarations: [
    DashboardComponent
  ],
  imports: [
    CommonModule,
    DashComponentsModule,
    InputsModule
  ],
  exports: [
    DashboardComponent
  ]
})
export class DashboardModule { }
