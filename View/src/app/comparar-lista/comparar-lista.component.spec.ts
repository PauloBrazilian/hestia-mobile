import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompararListaComponent } from './comparar-lista.component';

describe('CompararListaComponent', () => {
  let component: CompararListaComponent;
  let fixture: ComponentFixture<CompararListaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CompararListaComponent]
    });
    fixture = TestBed.createComponent(CompararListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
