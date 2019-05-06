import { TestBed } from '@angular/core/testing';

import { CourseCatalogService } from './course-catalog.service';

describe('CourseCatalogService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CourseCatalogService = TestBed.get(CourseCatalogService);
    expect(service).toBeTruthy();
  });
});
