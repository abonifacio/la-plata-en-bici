import { NgModule } from '@angular/core';

import {
  MdButtonModule, MdToolbarModule,MdIconModule,MdTabsModule,
  MdCardModule,MdInputModule,MdRadioModule,MdGridListModule,
  MdTableModule,MdSortModule,MdPaginatorModule,MdProgressSpinnerModule,MdChipsModule,
  MdListModule,MdCheckboxModule,MdMenuModule,MdTooltipModule,MdDialogModule,
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
    MdListModule,MdCheckboxModule,MdMenuModule,MdTooltipModule,MdDialogModule

  ],
  exports: [
    MdButtonModule, MdToolbarModule,MdIconModule,MdTabsModule,
    MdCardModule,MdInputModule,MdRadioModule,MdGridListModule,
    MdTableModule,CdkTableModule,MdSortModule,MdPaginatorModule,
    MdProgressSpinnerModule,MdSnackBarModule,MdDatepickerModule,
    MdNativeDateModule,MdSelectModule,MdProgressBarModule,MdChipsModule,
    MdListModule,MdCheckboxModule,MdMenuModule,MdTooltipModule,MdDialogModule
  ]
})
export class AppMaterialModule { }
