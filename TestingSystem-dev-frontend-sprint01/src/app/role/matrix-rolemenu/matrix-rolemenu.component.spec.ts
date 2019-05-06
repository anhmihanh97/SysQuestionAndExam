import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MatrixRolemenuComponent } from './matrix-rolemenu.component';

describe('MatrixRolemenuComponent', () => {
  let component: MatrixRolemenuComponent;
  let fixture: ComponentFixture<MatrixRolemenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MatrixRolemenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MatrixRolemenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
