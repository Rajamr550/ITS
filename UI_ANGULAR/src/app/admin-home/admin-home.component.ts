import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  gotoCandidate() {
    this.router.navigate(['/candidate']);
  }

  gotoInterview() {
    this.router.navigate(['/interview']);
  }
  gotoPanel() {
    this.router.navigate(['/panel']);
  }
  gotoLogin() {
    this.router.navigate(['/login']);
  }

  gotoTech() {
    this.router.navigate(['/tech']);
  }

  gotoHr() {
    this.router.navigate(['/hr']);
  }

}
