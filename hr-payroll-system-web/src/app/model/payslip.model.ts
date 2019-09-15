import { EmployeeInfoModel } from "./employee-info.model";

export class Payslip{
    employee : EmployeeInfoModel;
    payDate: Date;
    payFrequency: string;
    grossIncome: number;
    incomeTax:number;
    netIncome: number;
    superPay:number;
    pay:number;
}