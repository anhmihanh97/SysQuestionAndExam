import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UnregisterTestingComponent } from './unregister-testing.component';

describe('UnregisterTestingComponent', () => {
  let component: UnregisterTestingComponent;
  let fixture: ComponentFixture<UnregisterTestingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UnregisterTestingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UnregisterTestingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
