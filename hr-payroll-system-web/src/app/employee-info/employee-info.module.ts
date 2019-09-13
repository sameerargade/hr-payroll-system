
import {NgModule} from '@angular/core';
import { EmployeeInfoComponent } from './employee-info.component';
import {CommonModule} from '@angular/common';
import { FormsModule } from '@angular/forms';
import {EmployeeInfoRoutingModule} from './employee-info-routing.module';


@NgModule({
  declarations: [EmployeeInfoComponent],
  imports: [CommonModule,FormsModule, EmployeeInfoRoutingModule]
})
export  class EmployeeInfoModule {
}