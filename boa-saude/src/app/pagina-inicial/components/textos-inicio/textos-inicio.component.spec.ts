import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TextosInicioComponent } from './textos-inicio.component';

describe('TextosInicioComponent', () => {
  let component: TextosInicioComponent;
  let fixture: ComponentFixture<TextosInicioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TextosInicioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TextosInicioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
