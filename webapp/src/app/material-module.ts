import { NgModule } from '@angular/core';

import {MdButtonModule, MdToolbarModule,MdIconModule,MdTabsModule,MdCardModule,MdInputModule,MdRadioModule,MdGridListModule} from '@angular/material';
@NgModule({
  imports: [MdButtonModule, MdToolbarModule,MdIconModule,MdTabsModule,MdCardModule,MdInputModule,MdRadioModule,MdGridListModule],
  exports: [MdButtonModule, MdToolbarModule,MdIconModule,MdTabsModule,MdCardModule,MdInputModule,MdRadioModule,MdGridListModule]
})
export class AppMaterialModule { }
