import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, NavigationStart } from '@angular/router';
import { EmployeeInfoModel } from '../model/employee-info.model';
import { Observable } from 'rxjs';
import { catchError, map,filter, tap, switchMap } from "rxjs/operators";
import { DataService } from '../shared/data-service';
import { Payslip } from '../model/payslip.model';
import { PayslipService } from './payslip.service';
import {Location} from '@angular/common';
import {TAX_BRACKETS } from '../shared/constants'

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
       console.log("calculateTax2");
    if(this.annualSalary<=TAX_BRACKETS.BRACKET_1.maxTaxable){
      this.incomeTax= 0.0;
    }else if (this.annualSalary>=TAX_BRACKETS.BRACKET_2.minTaxable && this.annualSalary <= TAX_BRACKETS.BRACKET_2.maxTaxable ){
      this.incomeTax = (this.annualSalary * TAX_BRACKETS.BRACKET_2.taxPercent)/100;
    }else if (this.annualSalary>=TAX_BRACKETS.BRACKET_3.minTaxable && this.annualSalary <= TAX_BRACKETS.BRACKET_3.maxTaxable ){
      this.incomeTax = TAX_BRACKETS.BRACKET_3.minTax + ((this.annualSalary - TAX_BRACKETS.BRACKET_2.maxTaxable)* TAX_BRACKETS.BRACKET_3.taxPercent)/100;
    }else if (this.annualSalary>=TAX_BRACKETS.BRACKET_4.minTaxable && this.annualSalary <= TAX_BRACKETS.BRACKET_4.maxTaxable ){
      this.incomeTax = TAX_BRACKETS.BRACKET_4.minTax  + (((this.annualSalary - TAX_BRACKETS.BRACKET_3.maxTaxable)*TAX_BRACKETS.BRACKET_4.taxPercent)/100);
    }else if (this.annualSalary>=TAX_BRACKETS.BRACKET_5.minTaxable ){
      this.incomeTax = TAX_BRACKETS.BRACKET_5.minTax  + ((this.annualSalary - TAX_BRACKETS.BRACKET_4.maxTaxable)*TAX_BRACKETS.BRACKET_5.taxPercent)/100;
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
