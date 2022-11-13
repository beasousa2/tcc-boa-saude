import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardInfoMedicalComponent } from './card-info-medical.component';

describe('CardInfoMedicalComponent', () => {
  let component: CardInfoMedicalComponent;
  let fixture: ComponentFixture<CardInfoMedicalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardInfoMedicalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardInfoMedicalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
