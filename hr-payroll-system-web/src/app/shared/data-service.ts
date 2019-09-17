import { Injectable } from '@angular/core';
import { EmployeeInfoModel } from '../model/employee-info.model';

@Injectable({
    providedIn: 'root',
  })
export class DataService {

    public storage: EmployeeInfoModel;

    public constructor() { }

}