import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, NavigationStart } from '@angular/router';
import { EmployeeInfoModel } from '../model/employee-info.model';
import { Observable } from 'rxjs';
import { catchError, map,filter, tap, switchMap } from "rxjs/operators";
import { DataService } from '../shared/data-service';
import { Payslip } from '../model/payslip.model';
import { PayslipService } from './payslip.service';
import {Location} from '@angular/common';

@Component({
  selector: 'payslip',
  templateUrl: './payslip.component.html',
  styleUrls: ['./payslip.component.css']
})
export class PayslipComponent implements OnInit {
employeeInfo: EmployeeInfoModel = new EmployeeInfoModel();
payslip:Payslip = new Payslip();
firstName:string;
baseRate:number = 0.0;
annualSalary:number;
incomeTax:number = 0.0;
netIncome:number = 0.0;
private state$: Observable<object>;
  constructor(private router: Router, 
    private route: ActivatedRoute,private dataService:DataService,
    private payslipService: PayslipService,
    private location:Location)  {
      this.employeeInfo = JSON.parse(this.dataService.storage); //as EmployeeInfoModel;
      this.payslip.employee = this.employeeInfo;
      console.log(this.employeeInfo);
      this.annualSalary = this.payslip.employee.annualSalary;
}

  ngOnInit() {
    
   
    //console.log(this.dataService.storage);
    this.employeeInfo = this.dataService.storage as EmployeeInfoModel;
    //console.log(this.employeeInfo);
   // console.log(window.history.state.data);
   this.calculate();
  }
  
  calculate(){
    let date = new Date(), y = date.getFullYear(), m = date.getMonth();
    this.payslip.payFrequency = 'Monthly';
    this.payslip.payDate = new Date(y, m + 1, 0);
    this.payslip.grossIncome = this.payslip.employee.annualSalary/12;
    this.calculateTax();
  }
  calculateTax(){
    if(this.annualSalary<=18200){
      this.incomeTax= 0.0;
    }else if (this.annualSalary>=18201 && this.annualSalary <= 37000 ){
      this.incomeTax = (this.annualSalary *19)/100;
    }else if (this.annualSalary>=37001 && this.annualSalary <= 80000 ){
      this.incomeTax = 3572 + ((this.annualSalary - 37000)*32.5)/100;
    }else if (this.annualSalary>=80001 && this.annualSalary <= 180000 ){
      this.incomeTax = 17547 + (((this.annualSalary - 80000)*37)/100);
    }else if (this.annualSalary>=180001 ){
      this.incomeTax = 54547 + ((this.annualSalary - 180000)*45)/100;
    }
    //console.log(this.incomeTax);
    this.payslip.incomeTax=this.incomeTax/12;
    this.payslip.netIncome=this.payslip.grossIncome - this.payslip.incomeTax;
    this.payslip.superPay = (this.payslip.grossIncome * this.payslip.employee.superRate)/100;
    console.log(this.payslip.superPay);
    this.payslip.pay = this.payslip.netIncome - this.payslip.superPay;
    
  }

  pay(){
    console.log(this.payslip);
    this.payslipService.savePayslip(this.payslip).subscribe( data =>{
      console.log(' returned data' + JSON.stringify(data));   
   });
  }
  navigateBack(){
    this.location.back();
  }
}
