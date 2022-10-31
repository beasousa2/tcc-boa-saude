import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardExameComponent } from './card-exame.component';

describe('CardExameComponent', () => {
  let component: CardExameComponent;
  let fixture: ComponentFixture<CardExameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardExameComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardExameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
