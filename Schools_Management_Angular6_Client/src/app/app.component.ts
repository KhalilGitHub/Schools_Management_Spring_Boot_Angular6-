import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { LoginauthService } from './login-auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'ClientSpringSecurity';
  public currentStatus: any;

  constructor(private authservice: LoginauthService, private router: Router) {
    this.currentStatus = this.authservice.getStatus().subscribe(currentStatus => {
      this.currentStatus = this.currentStatus;
    });
  }

 logout(){
   localStorage.removeItem('currentStatus');
   this.router.navigate(['/login']);
 }

}
