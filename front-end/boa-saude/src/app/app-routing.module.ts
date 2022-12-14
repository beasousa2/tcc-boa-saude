import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  {
    path: '', pathMatch: 'full', redirectTo: 'pagina-inicial'
  },
  {
    path: 'pagina-inicial',
    loadChildren: () => import('../app/pagina-inicial/pagina-inicial.module')
    .then((m) => m.PaginaInicialModule)
  },
  {
    path: 'login',
    loadChildren: () => import('../app/login/login.module')
    .then((m) => m.LoginModule)
  },
  {
    path: 'planos/:age',
    loadChildren: () => import('../app/planos/planos.module')
    .then((m) => m.PlanosModule)
  },
  {
    path: 'cadastro',
    loadChildren: () => import('../app/cadastro/cadastro.module')
    .then((m)=> m.CadastroModule)
  },
  {
    path: 'home',
    component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
