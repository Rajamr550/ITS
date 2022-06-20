import { Injectable } from '@angular/core';
import { Login } from '../entities/login.entity';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

import { catchError, retry } from 'rxjs/operators';
import { Token } from '@angular/compiler';

import {
    HttpRequest,
    HttpHandler,
    HttpEvent,
    HttpInterceptor
} from '@angular/common/http';

@Injectable()
export class LoginService implements HttpInterceptor {
    authToken: any;
    apiToken: string = '';

    setToken(token: any) {
        this.authToken = token;
        this.apiToken = JSON.stringify(this.authToken);
        this.apiToken = this.apiToken.substring(8, 139);
    }

    getToken() {
        return this.apiToken;
    }

    postUrl = 'http://localhost:8003/its-login/user/authenticate';

    constructor(private httpClient: HttpClient) { }
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        throw new Error('Method not implemented.');
    }


    createNewLogin(loginForms: any): Observable<any> {
        let httpOptions = {
            headers: new HttpHeaders({
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json',
            }),
        };
        return this.httpClient.post<any>(
            this.postUrl,
            JSON.stringify(loginForms),
            httpOptions
        );
    }

    // deleteByLoginId(loginId: any): Observable<Boolean> {
    //     const headers = {
    //         'content-type': 'application/json',
    //         'Access-Control-Allow-Origin': '*',
    //     };
    //     return this.httpClient.delete<Boolean>(this.deleteUrl + '/' + loginId, {
    //         headers: headers,
    //     });
    // }

    // //create new service in rest api
    // getAllLogins(): Observable<any> {
    //     let httpOptions = {
    //         headers: new HttpHeaders({
    //             'Access-Control-Allow-Origin': '*',
    //         }),
    //     };
    //     return this.httpClient.get<any>(this.getUrl, httpOptions);
    // }

    // addLogins(loginObject: Login) {
    //     this.login.push(loginObject);
    // }
    // getAllLoginsLocal() {
    //     return this.login;
    // }


    // login = [
    //     {
    //         userName: '',
    //         password: ''
    //     },
    // ];



}
