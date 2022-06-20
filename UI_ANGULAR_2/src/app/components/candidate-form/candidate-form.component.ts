import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Candidate } from 'src/app/entities/candidate.entity';
import { CandidateService } from 'src/app/services/candidate.service';

@Component({
  selector: 'app-candidate-form',
  templateUrl: './candidate-form.component.html',
  styleUrls: ['./candidate-form.component.css']
})
export class CandidateFormComponent {

  constructor(private candidateService: CandidateService) {
    this.candidateService.getAllCandidate().subscribe((serverResponse: any) => {

      console.log('constrcutor serverResponse ', serverResponse);
      this.candidates = serverResponse;

    })
  }

  candidates: any = [];
  candidateDetails: Array<Candidate> = new Array();

  candidateForm = new FormGroup({

    candidateName: new FormControl('Satyam', [Validators.required, Validators.minLength(3)]),
    primarySkills: new FormControl('Java', [Validators.required, Validators.minLength(3)]),
    secondarySkills: new FormControl('', [Validators.required, Validators.minLength(3)]),
    experience: new FormControl('', [Validators.required]),
    qualification: new FormControl('', [Validators.required]),
    designation: new FormControl('', [Validators.required]),
    noticePeriod: new FormControl('', [Validators.required]),
    location: new FormControl('', [Validators.required])
  })

  submitCandidateForm = () => {

    var candidate_form = {
      // candidateId:
      candidateName: this.candidateForm.value['candidateName'],
      primarySkills: this.candidateForm.value['primarySkills'],
      secondarySkills: this.candidateForm.value['secondarySkills'],
      experience: this.candidateForm.value['experience'],
      qualification: this.candidateForm.value['qualification'],
      designation: this.candidateForm.value['designation'],
      noticePeriod: this.candidateForm.value['noticePeriod'],
      location: this.candidateForm.value['location']
    };

    this.candidateService.createNewCandidate(candidate_form).subscribe((serverResponse: any) => {
      console.log('createNewCandidate - serviceResponse : ', serverResponse);

      this.candidates.push(serverResponse);
    })

    console.log(this.candidateForm.value);
  }
}
