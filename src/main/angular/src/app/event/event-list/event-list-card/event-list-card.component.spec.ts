import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { EventListCardComponent } from './event-list-card.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { FormsModule } from '@angular/forms';
import { MatCardModule, MatTooltipModule } from '@angular/material';
import { RouterModule } from '@angular/router';
import { Event } from '../../event';

describe('EventListCardComponent', () => {
  let component: EventListCardComponent;
  let fixture: ComponentFixture<EventListCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        EventListCardComponent
       ],
       imports: [
         SharedModule,
         MaterialModule,
         FormsModule,
         MatCardModule,
         RouterModule.forRoot([]),
         MatTooltipModule
       ],
       providers: [
         { provide: Event, useValue: {}}
       ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventListCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
