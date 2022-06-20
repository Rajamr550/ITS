import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TechModel } from '../model/tech-model';

@Injectable({
  providedIn: 'root'
})
export class TechServiceService {


  constructor(private httpClient: HttpClient) { 

    
  }

  getData(): Observable<any>{
   return this.httpClient.get("http://localhost:8005/tech/interview");
  }

}
