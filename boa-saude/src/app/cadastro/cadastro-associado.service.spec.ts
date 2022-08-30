import { TestBed } from '@angular/core/testing';

import { CadastroAssociadoService } from './cadastro-associado.service';

describe('CadastroAssociadoService', () => {
  let service: CadastroAssociadoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CadastroAssociadoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
