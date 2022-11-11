import { NgModule } from "@angular/core";
import { PrestadorComponent } from "./prestador.component";
import { DataComponent } from './components/data/data.component';
import { HoraComponent } from './components/hora/hora.component';

@NgModule({
  declarations: [
    PrestadorComponent,
    DataComponent,
    HoraComponent
  ],
  imports: [

  ],
  exports: [
    PrestadorComponent,
    DataComponent,
    HoraComponent
  ]
})
export class PrestadorModule { }
