
import {NgModule} from '@angular/core';
import { EmployeeInfoComponent } from './employee-info.component';
import {CommonModule} from '@angular/common';
import { FormsModule } from '@angular/forms';
import {EmployeeInfoRoutingModule} from './employee-info-routing.module';
import {TranslateLoader, TranslateModule} from '@ngx-translate/core';
//import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MatFormFieldModule, MatInputModule } from '@angular/material';
@NgModule({
  declarations: [EmployeeInfoComponent],
  imports: [CommonModule,FormsModule, EmployeeInfoRoutingModule,
    TranslateModule,MatInputModule,
    MatFormFieldModule]
})
export  class EmployeeInfoModule {
}