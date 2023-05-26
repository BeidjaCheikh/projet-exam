import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteradarComponent } from './deleteradar.component';

describe('DeleteradarComponent', () => {
  let component: DeleteradarComponent;
  let fixture: ComponentFixture<DeleteradarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteradarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeleteradarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
