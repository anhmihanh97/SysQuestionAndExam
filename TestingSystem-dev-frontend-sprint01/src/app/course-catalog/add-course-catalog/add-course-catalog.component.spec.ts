import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCourseCatalogComponent } from './add-course-catalog.component';

describe('AddCourseCatalogComponent', () => {
  let component: AddCourseCatalogComponent;
  let fixture: ComponentFixture<AddCourseCatalogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddCourseCatalogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCourseCatalogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
