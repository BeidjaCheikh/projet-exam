import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleOwnerComponent } from './dele-owner.component';

describe('DeleOwnerComponent', () => {
  let component: DeleOwnerComponent;
  let fixture: ComponentFixture<DeleOwnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleOwnerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeleOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
