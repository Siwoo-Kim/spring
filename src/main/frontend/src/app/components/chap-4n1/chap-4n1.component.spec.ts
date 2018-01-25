import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Chap4n1Component } from './chap-4n1.component';

describe('Chap4n1Component', () => {
  let component: Chap4n1Component;
  let fixture: ComponentFixture<Chap4n1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Chap4n1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Chap4n1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
