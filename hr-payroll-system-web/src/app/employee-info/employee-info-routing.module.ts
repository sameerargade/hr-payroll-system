import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { EmployeeInfoComponent } from './employee-info.component';


export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: EmployeeInfoComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class EmployeeInfoRoutingModule {
}