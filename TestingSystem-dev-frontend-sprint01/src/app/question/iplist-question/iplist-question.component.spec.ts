import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IplistQuestionComponent } from './iplist-question.component';

describe('IplistQuestionComponent', () => {
  let component: IplistQuestionComponent;
  let fixture: ComponentFixture<IplistQuestionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IplistQuestionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IplistQuestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
