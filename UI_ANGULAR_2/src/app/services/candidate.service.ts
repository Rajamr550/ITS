import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable()
export class CandidateService {

    getUrl = 'http://localhost:8004/admin/candidate';
    postUrl = 'http://localhost:8004/admin/candidate';
    token: string = '';
    constructor(private httpClient: HttpClient, private loginService: LoginService) {

    }

    createNewCandidate(candidateForms: any): Observable<any> {
        this.token = this.loginService.getToken();
        console.log("this token in bearer ", this.token)
        let httpOptions = {
            headers: new HttpHeaders({
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json',
                // 'Authorization': 'Bearer ' + this.token.jwt.valueOf
                'Authorization': 'Bearer ' + this.token

            }),
        };
        // console.log("jwt value ", this.token.jwt.valueOf)
        // console.log("jwt value only jwt  ", this.token.jwt)

        return this.httpClient.post<any>(
            this.postUrl,
            JSON.stringify(candidateForms),
            httpOptions
        );
    }

    getAllCandidate(): Observable<any> {
        let httpOptions = {
            headers: new HttpHeaders({
                'Access-Control-Allow_origin': '*',
                'Authorization': 'Bearer' + this.token
            })
        };
        return this.httpClient.get<any>(this.getUrl, httpOptions);
    }
}
