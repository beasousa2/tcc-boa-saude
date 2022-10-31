import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { BuscarPrestadorComponent } from "./buscar-prestador/buscar-prestador.component";
import { MarcarConsultaComponent } from "./marcar-consulta.component";
import { PrestadorComponent } from "./prestador/prestador.component";

const routes: Routes = [
  {
    path: '', component: MarcarConsultaComponent, children: [
      {
        path:'nova',
        title: 'Nova Consulta',
        component: BuscarPrestadorComponent
      },
      {
        path:'prestador',
        title: 'Prestador',
        component: PrestadorComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MarcarConsultaRoutingModule { }
