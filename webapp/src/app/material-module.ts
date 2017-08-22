import { NgModule } from '@angular/core';

import {
  MdButtonModule, MdToolbarModule,MdIconModule,MdTabsModule,
  MdCardModule,MdInputModule,MdRadioModule,MdGridListModule,
  MdTableModule,MdSortModule,MdPaginatorModule,MdProgressSpinnerModule,MdChipsModule,
  MdListModule,MdCheckboxModule,MdMenuModule,MdTooltipModule,
  MdSnackBarModule,MdDatepickerModule,MdNativeDateModule,MdSelectModule,MdProgressBarModule
} from '@angular/material';
import {CdkTableModule} from '@angular/cdk';
@NgModule({
  imports: [
    MdButtonModule, MdToolbarModule,MdIconModule,MdTabsModule,
    MdCardModule,MdInputModule,MdRadioModule,MdGridListModule,
    MdTableModule,CdkTableModule,MdSortModule,MdPaginatorModule,
    MdProgressSpinnerModule,MdSnackBarModule,MdDatepickerModule,
    MdNativeDateModule,MdSelectModule,MdProgressBarModule,MdChipsModule,
    MdListModule,MdCheckboxModule,MdMenuModule,MdTooltipModule

  ],
  exports: [
    MdButtonModule, MdToolbarModule,MdIconModule,MdTabsModule,
    MdCardModule,MdInputModule,MdRadioModule,MdGridListModule,
    MdTableModule,CdkTableModule,MdSortModule,MdPaginatorModule,
    MdProgressSpinnerModule,MdSnackBarModule,MdDatepickerModule,
    MdNativeDateModule,MdSelectModule,MdProgressBarModule,MdChipsModule,
    MdListModule,MdCheckboxModule,MdMenuModule,MdTooltipModule
  ]
})
export class AppMaterialModule { }
