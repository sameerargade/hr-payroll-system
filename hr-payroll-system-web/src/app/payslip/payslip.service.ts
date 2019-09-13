import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Payslip } from '../model/payslip.model';
import { Observable } from "rxjs";
import URL_CONFIG from "../shared/url.config";
//import { catchError, map, tap, switchMap } from "rxjs/operators";
@Injectable({
    providedIn: 'root',
  })
  export class PayslipService{
    constructor(private httpClient: HttpClient) {}

    public savePayslip(request: Payslip) :Observable<any> {
        const url = URL_CONFIG.PAYSLIP_SAVE;
        const body = JSON.stringify(request);
        console.log('URL: ' + url + ' body: ' + body);
        const headers: HttpHeaders = new HttpHeaders({
            'Content-Type': 'application/json',
        });
        const options = { headers: headers};
    
        return this.httpClient.post(url, body, options);
    }
  }