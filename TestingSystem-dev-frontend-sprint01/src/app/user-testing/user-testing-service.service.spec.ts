import { TestBed } from '@angular/core/testing';

import { UserTestingServiceService } from './user-testing-service.service';

describe('UserTestingServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserTestingServiceService = TestBed.get(UserTestingServiceService);
    expect(service).toBeTruthy();
  });
});
