import { NgModule }             from '@angular/core';
import { BrowserModule }        from '@angular/platform-browser';
import { FormsModule, FormBuilder, FormGroup, ReactiveFormsModule }  from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule} from '@angular/common/http';

import { AuthGuard } from './auth.guard';
import { UserService } from './user.service';
import { LoginauthService } from './login-auth.service';

import { AppComponent }          from './app.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';

import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
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
  
  { path: 'admindashboard', component: AdmindashboardComponent, canActivate:[AuthGuard] },
  { path: 'userdashboard', component: UserdashboardComponent, canActivate:[AuthGuard] },

  {path: '**', pathMatch: 'full', redirectTo: '/login' }
];

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  providers:[
    UserService,
    AuthGuard,
    LoginauthService,
    FormBuilder
  ],
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    SignupComponent,
    AdmindashboardComponent,
    UserdashboardComponent,
    NavbarComponent,
    SidebarComponent,
    FormInscriptionComponent,
    InscriptionComponent,
    FormUpdateComponent,
    FormDeleteComponent,
    DiplayImagesComponent,
    DisplayImageComponent,
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
