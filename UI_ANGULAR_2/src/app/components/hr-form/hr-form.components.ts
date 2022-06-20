
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import { Interview } from 'src/app/entities/interview.entity';
import { HrService } from 'src/app/services/hr.services';
//import { InterviewService } from 'src/app/services/interview.service';


@Component({
  selector: 'hr-form',
  templateUrl: './hr-form.components.html',
  styleUrls: ['./hr_form.components.css'],
})
export class HrForm {
  forms: any = [];
  interviewDetails: Array<Interview> = new Array();
  // interviewForm: FormGroup;



  constructor(private hrService: HrService, private formBuilder: FormBuilder) {

    this.hrService.viewInterviewMembers(HrForm).subscribe((serverResponse: any) => {
      console.log('constructor serverResponse ', serverResponse);
      this.forms = serverResponse;
    })
  }

  HrForm = new FormGroup({
    hrId: new FormControl(11, [Validators.required]),

    candidateId: new FormControl(111, [Validators.required]),
    finalStatus: new FormControl('fail', [Validators.required]),
    hrRating: new FormControl(3, [Validators.required]),
    techRating: new FormControl(4, [Validators.required]),
    date: new FormControl('2020-09-09', [Validators.required])
  })




  submithrForm = () => {

    var hr_form = {
      hrId: this.HrForm.value['interviewId'],

      candidateId: this.HrForm.value['candidateId'],
      techRating: this.HrForm.value['techRating'],
      hrRating: this.HrForm.value['hrRating'],

      finalStatus: this.HrForm.value['finalStatus']
      // date: this.interviewForm.value['date']
    };

    this.hrService.viewCandidatesById().subscribe((serverResponse: any) => {
        console.log('constructor serverResponse ', serverResponse);
        this.forms = serverResponse;
      })

    console.log(this.HrForm.value);
    this.hrService.giveRating(this.HrForm.value['hrRating']);

  }


//   deleteInterviewById(interviewId: number) {
//     console.log("delete method called");
//   }

}
