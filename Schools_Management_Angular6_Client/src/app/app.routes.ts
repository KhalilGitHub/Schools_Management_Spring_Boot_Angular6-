import { NgModule }             from '@angular/core';
import { BrowserModule }        from '@angular/platform-browser';
import { FormsModule }          from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent }          from './app.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { FormInscriptionComponent } from './form-inscription/form-inscription.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { FormUpdateComponent } from './form-update/form-update.component';
import { FormDeleteComponent } from './form-delete/form-delete.component';
import { DiplayImagesComponent } from './diplay-images/diplay-images.component';
import { DisplayImageComponent } from './display-image/display-image.component';


const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'formIncription', component: FormInscriptionComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'update', component: FormUpdateComponent },
  { path: 'delete', component: FormDeleteComponent },
  { path: 'images', component: DiplayImagesComponent },
  { path: 'image', component: DisplayImageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },

  {path: '', pathMatch: 'full', redirectTo: '/home' }
];

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    SignupComponent

  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
