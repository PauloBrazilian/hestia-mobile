import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExplorarPageComponent } from './explorar-page.component';

describe('ExplorarPageComponent', () => {
  let component: ExplorarPageComponent;
  let fixture: ComponentFixture<ExplorarPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ExplorarPageComponent]
    });
    fixture = TestBed.createComponent(ExplorarPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
