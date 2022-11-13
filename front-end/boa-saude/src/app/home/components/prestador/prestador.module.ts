import { NgModule } from "@angular/core";
import { PrestadorComponent } from "./prestador.component";
import { DataComponent } from './components/data/data.component';
import { HoraComponent } from './components/hora/hora.component';
import { SwiperModule } from "swiper/angular";
import { CommonModule } from "@angular/common";

@NgModule({
  declarations: [
    PrestadorComponent,
    DataComponent,
    HoraComponent
  ],
  imports: [
    SwiperModule,
    CommonModule
  ],
  exports: [
    PrestadorComponent,
    DataComponent,
    HoraComponent
  ]
})
export class PrestadorModule { }
