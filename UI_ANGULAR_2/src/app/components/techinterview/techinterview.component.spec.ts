import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TechinterviewComponent } from './techinterview.component';

describe('TechinterviewComponent', () => {
  let component: TechinterviewComponent;
  let fixture: ComponentFixture<TechinterviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TechinterviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TechinterviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
