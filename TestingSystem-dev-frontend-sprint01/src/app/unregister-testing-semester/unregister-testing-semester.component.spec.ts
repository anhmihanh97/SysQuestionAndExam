import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UnregisterTestingSemesterComponent } from './unregister-testing-semester.component';

describe('UnregisterTestingSemesterComponent', () => {
  let component: UnregisterTestingSemesterComponent;
  let fixture: ComponentFixture<UnregisterTestingSemesterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UnregisterTestingSemesterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UnregisterTestingSemesterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
