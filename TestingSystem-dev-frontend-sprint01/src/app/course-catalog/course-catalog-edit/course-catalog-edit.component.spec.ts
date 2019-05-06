import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseCatalogEditComponent } from './course-catalog-edit.component';

describe('CourseCatalogEditComponent', () => {
  let component: CourseCatalogEditComponent;
  let fixture: ComponentFixture<CourseCatalogEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseCatalogEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseCatalogEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
