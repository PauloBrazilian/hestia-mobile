import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManutencaoListaPageComponent } from './manutencao-lista-page.component';

describe('ManutencaoListaPageComponent', () => {
  let component: ManutencaoListaPageComponent;
  let fixture: ComponentFixture<ManutencaoListaPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManutencaoListaPageComponent]
    });
    fixture = TestBed.createComponent(ManutencaoListaPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
