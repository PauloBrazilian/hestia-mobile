import { TestBed } from '@angular/core/testing';

import { MsStoreService } from './ms-store.service';

describe('MsStoreService', () => {
  let service: MsStoreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MsStoreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
