import { TestBed, inject } from '@angular/core/testing';

import { RequestMappingService } from './request-mapping.service';

describe('RequestMappingService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RequestMappingService]
    });
  });

  it('should be created', inject([RequestMappingService], (service: RequestMappingService) => {
    expect(service).toBeTruthy();
  }));
});
