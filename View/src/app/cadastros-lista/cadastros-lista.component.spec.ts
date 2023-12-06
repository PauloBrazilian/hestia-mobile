import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrosListaComponent } from './cadastros-lista.component';

describe('CadastrosListaComponent', () => {
  let component: CadastrosListaComponent;
  let fixture: ComponentFixture<CadastrosListaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CadastrosListaComponent]
    });
    fixture = TestBed.createComponent(CadastrosListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
