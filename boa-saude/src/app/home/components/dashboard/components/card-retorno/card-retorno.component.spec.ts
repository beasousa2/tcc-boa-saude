import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardRetornoComponent } from './card-retorno.component';

describe('CardRetornoComponent', () => {
  let component: CardRetornoComponent;
  let fixture: ComponentFixture<CardRetornoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardRetornoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardRetornoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
