import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserTestingResultComponent } from './user-testing-result.component';

describe('UserTestingResultComponent', () => {
  let component: UserTestingResultComponent;
  let fixture: ComponentFixture<UserTestingResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserTestingResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserTestingResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
