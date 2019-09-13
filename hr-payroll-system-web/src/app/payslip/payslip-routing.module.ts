import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { PayslipComponent } from './payslip.component';


export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: PayslipComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class PayslipRoutingModule {
}