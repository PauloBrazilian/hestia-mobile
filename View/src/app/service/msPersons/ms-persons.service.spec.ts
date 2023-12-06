import { TestBed } from '@angular/core/testing';

import { MsPersonsService } from './ms-persons.service';

describe('MsPersonsService', () => {
  let service: MsPersonsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MsPersonsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
