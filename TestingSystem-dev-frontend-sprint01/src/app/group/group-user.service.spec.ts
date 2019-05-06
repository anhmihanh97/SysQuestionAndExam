import { TestBed } from '@angular/core/testing';

import { GroupUserService } from './group-user.service';

describe('GroupUserService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GroupUserService = TestBed.get(GroupUserService);
    expect(service).toBeTruthy();
  });
});
