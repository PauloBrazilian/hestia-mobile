import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrarListaComponent } from './cadastrar-lista.component';

describe('CadastrarListaComponent', () => {
  let component: CadastrarListaComponent;
  let fixture: ComponentFixture<CadastrarListaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CadastrarListaComponent]
    });
    fixture = TestBed.createComponent(CadastrarListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
