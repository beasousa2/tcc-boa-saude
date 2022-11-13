import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { TextosInicioComponent } from "./textos-inicio.component";

@NgModule({
  declarations: [TextosInicioComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [TextosInicioComponent]
})
export class TextoInicioModule{}
