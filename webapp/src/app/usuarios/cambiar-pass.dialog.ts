import { AccountService } from '../services/account.service';
import { Component } from '@angular/core';
import {MdDialog,MdDialogRef} from '@angular/material';

@Component({
  selector: 'cambiar-pass-dialog',
  template: `
    <form (ngSubmit)="doCambiar()" #passF="ngForm">
        <div class="row">
            <div class="col-xs">
                <md-input-container>
                    <input mdInput type="password" [(ngModel)]="pass.anterior" name="anterior" placeholder="Contraseña actual" required="true">
                </md-input-container>
            </div>
        </div>
        <div class="row">
            <div class="col-xs">
                <md-input-container>
                    <input mdInput type="password" [(ngModel)]="pass.nueva" name="nueva" placeholder="Contraseña nueva" required="true">
                </md-input-container>
            </div>
            <div class="col-xs">
                <md-input-container>
                    <input mdInput type="password" [(ngModel)]="pass.confirmacion" name="confirmacion" placeholder="Contraseña de confirmación" required="true">
                </md-input-container>
            </div>
        </div>
        <div class="row around-xs">
            <div class="col-xs-4">
                <button type="submit" [disabled]="passF.invalid || pass.confirmacion!=pass.nueva" md-button color="primary">CAMBIAR</button>
            </div>
            <div class="col-xs-4">
                <button type="button" md-button (click)="cancelar()">CANCELAR</button>
            </div>
        </div>
    </form>
  `,
})
export class CambiarPassDialog {
  pass = {
    anterior: '',
    nueva: '',
    confirmacion: ''
  };
  constructor(private dialogRef: MdDialogRef<CambiarPassDialog>,private account:AccountService) {}

  cancelar(){
    this.dialogRef.close();
  }

  doCambiar(){
    this.account.changePassword(this.pass).subscribe(u=>{
      this.dialogRef.close();
    });
  }
}