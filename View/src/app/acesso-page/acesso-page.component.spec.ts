import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcessoPageComponent } from './acesso-page.component';

describe('AcessoPageComponent', () => {
  let component: AcessoPageComponent;
  let fixture: ComponentFixture<AcessoPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AcessoPageComponent]
    });
    fixture = TestBed.createComponent(AcessoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
