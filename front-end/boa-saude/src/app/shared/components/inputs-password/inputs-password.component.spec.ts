import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InputsPasswordComponent } from './inputs-password.component';

describe('InputsPasswordComponent', () => {
  let component: InputsPasswordComponent;
  let fixture: ComponentFixture<InputsPasswordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InputsPasswordComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InputsPasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
