import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlumneComponent } from './alumne.component';

describe('AlumneComponent', () => {
  let component: AlumneComponent;
  let fixture: ComponentFixture<AlumneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlumneComponent ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlumneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
