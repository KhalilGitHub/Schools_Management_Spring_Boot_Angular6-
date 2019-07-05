import { Component, OnInit } from '@angular/core';

import { UserService } from '../user.service';
import { LoginauthService } from '../login-auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

public user: any = {};

  constructor(private userService: UserService, private authservice: LoginauthService,
    private route: Router) {
    this.authservice.isLoggedIn();
   }

  ngOnInit() {
  }

saveUser(user: any, userForm: any){
  this.userService.saveUser(user).subscribe((response) =>{
    if(response){
      this.goTo();
      //console.log(response);
     // userForm.reset();
    }
  });

}

  goTo() {
    this.route.navigate(['login']);
  }

}
