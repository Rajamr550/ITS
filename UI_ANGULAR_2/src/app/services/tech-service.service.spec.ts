import { TestBed } from '@angular/core/testing';

import { TechServiceService } from './tech-service.service';

describe('TechServiceService', () => {
  let service: TechServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TechServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
