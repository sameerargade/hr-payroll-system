import { Component, OnInit, ViewChild } from '@angular/core';
import { EmployeeInfoModel } from '../model/employee-info.model';
import { ActivatedRoute, Router, NavigationExtras } from '@angular/router';
import { DataService } from '../shared/data-service';

@Component({
  selector: 'employee-info',
  templateUrl: './employee-info.component.html',
  styleUrls: ['./employee-info.component.css']
})
export class EmployeeInfoComponent implements OnInit {
  employee: EmployeeInfoModel = new EmployeeInfoModel();
  // @ViewChild('employeeForm',{static:false}) 
  // employeeForm : any;
  constructor(private router: Router,
    private route: ActivatedRoute, private dataService: DataService) {
    console.log('constructir');
  }

  ngOnInit() {
  }
  public generatePaySlip() {

    //console.log(JSON.stringify(this.employee));
    let navigationExtras: NavigationExtras = {
      queryParams: {
        state: {
          data: JSON.stringify(this.employee)
        }
      }
    };
    //this.router.navigate(['payslip',{state:{ data : JSON.stringify(this.employee)}}]);
    //this.router.navigate(['payslip' ,navigationExtras]);
    //this.dataService.storage = JSON.stringify(this.employee);
    this.dataService.storage = this.employee;
    //console.log( this.dataService.storage);
    // let route = this.router.config.find(r => r.path === 'payslip');
    // route.data = { entity: JSON.stringify(this.employee) };
    this.router.navigateByUrl('payslip');

  }

}
