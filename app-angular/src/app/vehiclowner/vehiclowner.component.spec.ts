import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehiclownerComponent } from './vehiclowner.component';

describe('VehiclownerComponent', () => {
  let component: VehiclownerComponent;
  let fixture: ComponentFixture<VehiclownerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VehiclownerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VehiclownerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
