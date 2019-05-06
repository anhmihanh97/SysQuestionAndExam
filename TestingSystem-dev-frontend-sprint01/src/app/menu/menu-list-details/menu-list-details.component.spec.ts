import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuListDetailsComponent } from './menu-list-details.component';

describe('MenuListDetailsComponent', () => {
  let component: MenuListDetailsComponent;
  let fixture: ComponentFixture<MenuListDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuListDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuListDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
