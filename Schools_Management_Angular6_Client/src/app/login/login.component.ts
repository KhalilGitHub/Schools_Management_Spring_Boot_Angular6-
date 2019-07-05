import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { UserService } from '../user.service';
import { LoginauthService } from '../login-auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user: any = {};

  constructor(private userService: UserService, private router: Router) {
    //this.authservice.isLoggedIn();, private authservice: LoginauthService
  }

  ngOnInit() {
  }

  loginUser(user){
    this.userService.loginUser(user).subscribe((response) =>{
      if(response){
        if(response.token){
          localStorage.setItem('currentUser', JSON.stringify(response));
          if(response.user.role === 'ADMIN'){
            this.router.navigate(["/admindashboard"]);
          }else{
            this.router.navigate(["/userdashboard"]);
          }
        }
      }
    });

  }

}
