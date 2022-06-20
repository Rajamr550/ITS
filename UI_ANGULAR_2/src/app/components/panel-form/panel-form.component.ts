import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Pannel } from 'src/app/entities/pannel.entity';
import { PannelService } from 'src/app/services/pannel.service';

@Component({
  selector: 'app-panel-form',
  templateUrl: './panel-form.component.html',
  styleUrls: ['./panel-form.component.css']
})
export class PanelFormComponent {

  forms: any = [];
  pannelMembersDetails: Array<Pannel> = new Array();



  constructor(private pannelService: PannelService, private formBuilder: FormBuilder) {

    this.pannelService.getAllPannelMembers().subscribe((serverResponse: any) => {
      console.log('constrcutor serverResponse ', serverResponse);
      this.forms = serverResponse;
    })
  }



  panelForm = new FormGroup({
    employeeId: new FormControl('', [Validators.required]),
    name: new FormControl('nag', [Validators.required]),
    type: new FormControl('', [Validators.required]),
    location: new FormControl('Hyd', [Validators.required]),
  })

  submitPanelForm = () => {

    var pannel_form = {
      employeeId: this.panelForm.value['employeeId'],
      name: this.panelForm.value['name'],
      type: this.panelForm.value['type'],

      location: this.panelForm.value['location']
      // date: this.interviewForm.value['date']
    };

    this.pannelService.createNewPannel(pannel_form).subscribe((serverResponse: any) => {
      console.log('createNewPannel - serviceResponse : ', serverResponse);

      this.forms.push(serverResponse);
    })

  console.log(this.panelForm.value);
  this.pannelService.addPannels(pannel_form);

}
deleteBypannelId(employeeId: number,type:string) {
  console.log("typevalue",type);
  if(type == 'Hr'){
      this.pannelService.deleteBypannelhrId(employeeId).subscribe((serverResponse: any) => {
        console.log('deletepannelid - serviceResponse : ', serverResponse);
    
      console.log("delete method called");
    })
  }
  this.pannelService.deleteBypannelId(employeeId).subscribe((serverResponse: any) => {
    console.log('deletepannelid - serviceResponse : ', serverResponse);

  console.log("delete method called");
})
}
}


