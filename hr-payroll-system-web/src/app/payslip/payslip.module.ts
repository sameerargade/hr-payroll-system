
import {NgModule} from '@angular/core';
import { PayslipComponent } from './payslip.component';
import {CommonModule} from '@angular/common';
import { FormsModule } from '@angular/forms';
import {PayslipRoutingModule} from './payslip-routing.module';
import {TranslateLoader, TranslateModule} from '@ngx-translate/core';
@NgModule({
  declarations: [PayslipComponent],
  imports: [CommonModule,FormsModule, PayslipRoutingModule,TranslateModule]
})
export  class PayslipModule {
}