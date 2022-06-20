import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import { Interview } from 'src/app/entities/interview.entity';

import { InterviewService } from 'src/app/services/interview.service';


@Component({
  selector: 'interview-form',
  templateUrl: './interview-form.component.html',
  styleUrls: ['./interview-form.component.css'],
})
export class InterviewFormComponent {
  forms: any = [];



  constructor() {


  }

  interviewForm = new FormGroup({
    firstName: new FormControl('tom', [Validators.required]),
    lastName: new FormControl('jerry', [Validators.required]),
    city: new FormControl('chennai', [Validators.required]),
    street: new FormControl('m.k.nagar', [Validators.required]),
    state: new FormControl('TN', [Validators.required]),
    zipCode: new FormControl('600999', [Validators.required]),
    aliases: new FormControl('xyz', [Validators.required])
  })




  submitInterviewForm = () => {

    var interview_form = {
      firstName: this.interviewForm.value['firstName'],
      lastName: this.interviewForm.value['lastName'],
      city: this.interviewForm.value['city'],
      street: this.interviewForm.value['street'],
      state: this.interviewForm.value['state'],
      zipCode: this.interviewForm.value['zipCode'],
      aliases: this.interviewForm.value['aliases'],
    };



  }




}