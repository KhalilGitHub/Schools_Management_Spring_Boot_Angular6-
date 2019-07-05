import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Subject} from 'rxjs/Subject';

@Injectable({
  providedIn: 'root'
})
export class LoginauthService {

  private subject = new Subject<any>();

isLoggedIn(){
  if(localStorage.getItem('current')){
    this.subject.next({status: true});
  }else{
    this.subject.next({status: false});
  }
}

clearStatus(){
  this.subject.next();
}

getStatus(): Observable<any>{
  return this.subject.asObservable();

}

  constructor() { }
}
