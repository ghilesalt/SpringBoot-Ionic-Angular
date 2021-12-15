import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { DeleteUserPageRoutingModule } from './delete-user-routing.module';

import { DeleteUserPage } from './delete-user.page';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule.forRoot(),
    DeleteUserPageRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  declarations: [DeleteUserPage]
})
export class DeleteUserPageModule {}
