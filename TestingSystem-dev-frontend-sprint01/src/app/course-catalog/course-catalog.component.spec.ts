import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseCatalogComponent } from './course-catalog.component';

describe('CourseCatalogComponent', () => {
  let component: CourseCatalogComponent;
  let fixture: ComponentFixture<CourseCatalogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseCatalogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseCatalogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
