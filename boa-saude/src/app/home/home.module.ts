import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { HeaderModule } from './shared/components/header/header.module';
import { MenuModule } from './shared/components/menu/menu.module';


@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    HeaderModule,
    MenuModule
  ],
  exports: [
  ]
})
export class HomeModule { }
