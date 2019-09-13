
import {NgModule} from '@angular/core';
import { PayslipComponent } from './payslip.component';
import {CommonModule} from '@angular/common';
import { FormsModule } from '@angular/forms';
import {PayslipRoutingModule} from './payslip-routing.module';

@NgModule({
  declarations: [PayslipComponent],
  imports: [CommonModule,FormsModule, PayslipRoutingModule]
})
export  class PayslipModule {
}