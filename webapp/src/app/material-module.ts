import { NgModule } from '@angular/core';

import {
  MdButtonModule, MdToolbarModule,MdIconModule,MdTabsModule,
  MdCardModule,MdInputModule,MdRadioModule,MdGridListModule,
  MdTableModule,MdSortModule,MdPaginatorModule,MdProgressSpinnerModule,
  MdSnackBarModule,MdDatepickerModule,MdNativeDateModule,MdSelectModule
} from '@angular/material';
import {CdkTableModule} from '@angular/cdk';
@NgModule({
  imports: [
    MdButtonModule, MdToolbarModule,MdIconModule,MdTabsModule,
    MdCardModule,MdInputModule,MdRadioModule,MdGridListModule,
    MdTableModule,CdkTableModule,MdSortModule,MdPaginatorModule,
    MdProgressSpinnerModule,MdSnackBarModule,MdDatepickerModule,
    MdNativeDateModule,MdSelectModule
  ],
  exports: [
    MdButtonModule, MdToolbarModule,MdIconModule,MdTabsModule,
    MdCardModule,MdInputModule,MdRadioModule,MdGridListModule,
    MdTableModule,CdkTableModule,MdSortModule,MdPaginatorModule,
    MdProgressSpinnerModule,MdSnackBarModule,MdDatepickerModule,
    MdNativeDateModule,MdSelectModule
  ]
})
export class AppMaterialModule { }
