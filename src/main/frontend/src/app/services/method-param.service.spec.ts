import { TestBed, inject } from '@angular/core/testing';

import { MethodParamService } from './method-param.service';

describe('MethodParamService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MethodParamService]
    });
  });

  it('should be created', inject([MethodParamService], (service: MethodParamService) => {
    expect(service).toBeTruthy();
  }));
});
