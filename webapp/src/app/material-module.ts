import { NgModule } from '@angular/core';

import {
  MdButtonModule, MdToolbarModule,MdIconModule,MdTabsModule,
  MdCardModule,MdInputModule,MdRadioModule,MdGridListModule,
  MdTableModule,MdSortModule,MdPaginatorModule,MdProgressSpinnerModule,MdChipsModule,
  MdSnackBarModule,MdDatepickerModule,MdNativeDateModule,MdSelectModule,MdProgressBarModule
} from '@angular/material';
import {CdkTableModule} from '@angular/cdk';
@NgModule({
  imports: [
    MdButtonModule, MdToolbarModule,MdIconModule,MdTabsModule,
    MdCardModule,MdInputModule,MdRadioModule,MdGridListModule,
    MdTableModule,CdkTableModule,MdSortModule,MdPaginatorModule,
    MdProgressSpinnerModule,MdSnackBarModule,MdDatepickerModule,
    MdNativeDateModule,MdSelectModule,MdProgressBarModule,MdChipsModule
  ],
  exports: [
    MdButtonModule, MdToolbarModule,MdIconModule,MdTabsModule,
    MdCardModule,MdInputModule,MdRadioModule,MdGridListModule,
    MdTableModule,CdkTableModule,MdSortModule,MdPaginatorModule,
    MdProgressSpinnerModule,MdSnackBarModule,MdDatepickerModule,
    MdNativeDateModule,MdSelectModule,MdProgressBarModule,MdChipsModule
  ]
})
export class AppMaterialModule { }
