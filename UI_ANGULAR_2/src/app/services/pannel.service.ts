import { Injectable } from '@angular/core';
import { Pannel } from '../entities/pannel.entity';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { LoginService } from './login.service';


@Injectable()
export class PannelService {

    getUrl = 'http://localhost:8004/admin/panel';
    deleteUrl = 'http://localhost:8004/admin/panel/tech';
    postUrl = 'http://localhost:8004/admin/panel';
    deleteUrl1 = 'http://localhost:8004/admin/panel/hr';
    pannel: any;
    token: string = '';
    constructor(private httpClient: HttpClient, private loginService: LoginService) { }

    createNewPannel(pannelForms: any): Observable<any> {
        this.token = this.loginService.getToken();
        console.log("this token in bearer ", this.token)
        let httpOptions = {
            headers: new HttpHeaders({
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json',
                //'Authorization': 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY1MzE3MTA3NSwiaWF0IjoxNjUzMTM1MDc1fQ.cGqasa2aAt0j056h7NaZNtDv7Z-ARrD6SnEeAcptONo'
                'Authorization': 'Bearer ' + this.token
            }),
        };
        return this.httpClient.post<any>(
            this.postUrl,
            JSON.stringify(pannelForms),
            httpOptions
        );
    }
    addPannels(pannelObject: Pannel) {
        this.pannel.push(pannelObject);
    }

    deleteBypannelId(employeeId: any): Observable<Boolean> {
        const headers = {
            'content-type': 'application/json',
            'Access-Control-Allow-Origin': '*',
        };
        return this.httpClient.delete<Boolean>(this.deleteUrl + '/' + employeeId, {
            headers: headers,
        });

    }


    // deleteBypannelhrId(employeeId: any): Observable<Boolean> {
    //      const headers = {
    //           'content-type': 'application/json',
    //            'Access-Control-Allow-Origin': '*',
    //          };
    //          return this.httpClient.delete<Boolean>(this.deleteUrl + '/' + employeeId, {
    //             headers: headers,
    //         });

    //     }



    getAllPannelMembers(): Observable<any> {
        this.token = this.loginService.getToken();
        console.log("this token in bearer ", this.token)
        let httpOptions = {
            headers: new HttpHeaders({
                'Access-Control-Allow-Origin': '*',
                'Authorization': 'Bearer ' + this.token

            }),
        };
        return this.httpClient.get<any>(this.getUrl, httpOptions);
    }

    deleteBypannelhrId(employeeId: any): Observable<Boolean> {
        const headers = {
            'content-type': 'application/json',

            'Access-Control-Allow-Origin': '*',
        };
        return this.httpClient.delete<Boolean>(this.deleteUrl1 + '/' + employeeId, {
            headers: headers,
        });
    }
}
