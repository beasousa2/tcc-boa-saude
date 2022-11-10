import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { PrestadorComponent } from './components/prestador/prestador.component';
import { MarcarConsultaComponent } from './components/marcar-consulta/marcar-consulta.component';

const routes: Routes = [
  {
    path: 'home', component: HomeComponent, children: [
      {
        path: 'dashboard',
        title: 'Dashboard',
        component: DashboardComponent
      },
      {
        path: 'consulta',
        title: 'Consulta',
        children: [
          {
            path: 'nova',
            title: 'Nova Consulta',
            component: MarcarConsultaComponent
          },
        ]
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
export class HomeRoutingModule { }
