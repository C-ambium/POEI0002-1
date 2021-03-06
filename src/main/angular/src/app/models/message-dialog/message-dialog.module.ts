import { NgModule, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MessageDialogComponent } from './message-dialog.component';
import { MatToolbarModule, MatSelectModule } from '@angular/material';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { OvgFormsModule } from 'src/app/shared/forms/ovg-forms.module';

@NgModule({
  declarations: [ MessageDialogComponent ],
  imports: [
    CommonModule,
    MatToolbarModule,
    MaterialModule,
    MatSelectModule,
    OvgFormsModule
  ],
  exports: [ MessageDialogComponent ]
})
export class MessageDialogModule {}
