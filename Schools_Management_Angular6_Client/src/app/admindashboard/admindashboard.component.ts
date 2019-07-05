import { Component, OnInit } from '@angular/core';

import { LoginauthService } from '../login-auth.service';
import { UserService } from '../user.service';


@Component({
  selector: 'app-admindashboard',
  templateUrl: './admindashboard.component.html',
  styleUrls: ['./admindashboard.component.css']
})
export class AdmindashboardComponent implements OnInit {

 // public loginuser: any = {};
  //public users: any = [];

  constructor(private authservice: LoginauthService, private userService: UserService) {
    this.authservice.isLoggedIn();
    //this.loginuser = JSON.parse(localStorage.getItem('currentUser'));
   }

  ngOnInit() {
    //this.userService.getAllUsers(this.loginuser.token).subscribe(users => {
     // this.users = users;
    //});
  }

}
