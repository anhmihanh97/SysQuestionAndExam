import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MatrixUserroleComponent } from './matrix-userrole.component';

describe('MatrixUserroleComponent', () => {
  let component: MatrixUserroleComponent;
  let fixture: ComponentFixture<MatrixUserroleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MatrixUserroleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MatrixUserroleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
