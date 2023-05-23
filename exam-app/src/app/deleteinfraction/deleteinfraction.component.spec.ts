import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteinfractionComponent } from './deleteinfraction.component';

describe('DeleteinfractionComponent', () => {
  let component: DeleteinfractionComponent;
  let fixture: ComponentFixture<DeleteinfractionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteinfractionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeleteinfractionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
