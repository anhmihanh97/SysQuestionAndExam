import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SemesterCodeComponent } from './semester-code.component';

describe('SemesterCodeComponent', () => {
  let component: SemesterCodeComponent;
  let fixture: ComponentFixture<SemesterCodeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SemesterCodeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SemesterCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
