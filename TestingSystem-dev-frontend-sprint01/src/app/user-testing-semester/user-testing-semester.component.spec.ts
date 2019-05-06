import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserTestingSemesterComponent } from './user-testing-semester.component';

describe('UserTestingSemesterComponent', () => {
  let component: UserTestingSemesterComponent;
  let fixture: ComponentFixture<UserTestingSemesterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserTestingSemesterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserTestingSemesterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
