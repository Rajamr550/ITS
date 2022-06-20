import { Component, OnInit } from '@angular/core';
import { TechModel } from 'src/app/model/tech-model';
import { TechServiceService } from 'src/app/services/tech-service.service';

@Component({
  selector: 'app-techinterview',
  templateUrl: './techinterview.component.html',
  styleUrls: ['./techinterview.component.css']
})
export class TechinterviewComponent implements OnInit {

  constructor(private service: TechServiceService) { }
  public techData: TechModel[] = []
  ngOnInit(): void {

    this.service.getData().subscribe((data: TechModel[]) =>{
      
      this.techData = data;
      console.log('data ',this.techData);
    });

  }

  saveTechData(index: number){
    this.techData[index].isEdit = false;
  }

}
