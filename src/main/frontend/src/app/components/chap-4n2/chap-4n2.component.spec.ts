import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Chap4n2Component } from './chap-4n2.component';

describe('Chap4n2Component', () => {
  let component: Chap4n2Component;
  let fixture: ComponentFixture<Chap4n2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Chap4n2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Chap4n2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
