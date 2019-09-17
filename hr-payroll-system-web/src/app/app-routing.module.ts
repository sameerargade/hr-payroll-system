import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [ {
  path: '',
  redirectTo: 'employee-info',
  pathMatch: 'full'
},
{
  path: 'employee-info',
  pathMatch: 'prefix',
  //loadChildren: './dashboard/dashboard.module'
  loadChildren: () => import('./employee-info/employee-info.module').then(m => m.EmployeeInfoModule)

},
{
    path: 'payslip',
    pathMatch: 'prefix',
    //loadChildren: './dashboard/dashboard.module'
    loadChildren: () => import('./payslip/payslip.module').then(m => m.PayslipModule)
  
  }
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule {
    }