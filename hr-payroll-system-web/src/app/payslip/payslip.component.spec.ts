import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PayslipComponent } from './payslip.component';
import { FormsModule } from '@angular/forms';
import { AlertModule, AlertConfig } from 'ngx-alerts';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { MatFormFieldModule, MatInputModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AlertService } from 'ngx-alerts';
import { TranslateModule, TranslateLoader, TranslateFakeLoader } from '@ngx-translate/core';
import { DataService } from '../shared/data-service';
describe('PayslipComponent', () => {
  let component: PayslipComponent;
  let fixture: ComponentFixture<PayslipComponent>;
  let dataService: DataService; 
  //const newLocal:AlertConfig = { maxMessages: 5, timeout: 5000, position: 'right' };
  const newLocal = { maxMessages: 5, timeout: 5000, position: newFunction() };
  beforeEach(async(() => {
      TestBed.configureTestingModule({
      imports: [ FormsModule,RouterTestingModule,HttpClientTestingModule ,
        MatFormFieldModule,
        MatInputModule,
        BrowserAnimationsModule,
         AlertModule.forRoot(),
        TranslateModule.forRoot({
          loader: { provide: TranslateLoader, useClass: TranslateFakeLoader }})
         ],
      declarations: [ PayslipComponent ],
      providers :[AlertService, DataService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    dataService = TestBed.get(DataService); 
    dataService.storage = {"firstName":"john","lastName":"smith","annualSalary":120000,"superRate":9.5};
  
    fixture = TestBed.createComponent(PayslipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
function newFunction(): "right" | "left" {
  return 'right';
}

describe('DataService', () => {
  let dataService: DataService; 

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DataService]
    });

    dataService = TestBed.get(DataService); 
  });

  it('should be created', () => { 
    expect(dataService).toBeTruthy();
  });
});

describe('GeneratePayslip',() =>{
  let dataService: DataService; 
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DataService]
    });

    dataService = TestBed.get(DataService); 
  })
})