import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Chap4n3Component } from './chap-4n3.component';

describe('Chap4n3Component', () => {
  let component: Chap4n3Component;
  let fixture: ComponentFixture<Chap4n3Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Chap4n3Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Chap4n3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
