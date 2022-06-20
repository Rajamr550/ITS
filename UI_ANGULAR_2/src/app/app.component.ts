import { Component } from '@angular/core';
import { Interview } from './entities/interview.entity';
import { Pannel } from './entities/pannel.entity';

import { Login } from './entities/login.entity';
import { Candidate } from './entities/candidate.entity';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'interview-tracking-system';
  public interviewDetails: Array<Interview> = new Array();
  public pannelMembersDetails: Array<Pannel> = new Array();
  public loginDetails: Array<Login> = new Array();
  public candidateDetails: Array<Candidate> = new Array();

}
