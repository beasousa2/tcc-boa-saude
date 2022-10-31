import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarPrestadorComponent } from './buscar-prestador.component';

describe('BuscarPrestadorComponent', () => {
  let component: BuscarPrestadorComponent;
  let fixture: ComponentFixture<BuscarPrestadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuscarPrestadorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BuscarPrestadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
