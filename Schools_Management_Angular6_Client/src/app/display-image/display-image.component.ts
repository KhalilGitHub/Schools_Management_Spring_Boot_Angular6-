import { Component, OnInit } from '@angular/core';
import { InscriptionService } from '../home/inscription.service';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators} from '@angular/forms';

@Component({
  selector: 'app-display-image',
  templateUrl: './display-image.component.html',
  styleUrls: ['./display-image.component.css']
})
export class DisplayImageComponent implements OnInit {

  image: any; 
  
  imageFind: any[];

  inscriptionForm: FormGroup;

  constructor(private inscriptionService: InscriptionService, private router: Router, private fb: FormBuilder) {
    this.createForm();
   }

  ngOnInit() {
    this.image = null;
  }

  createForm() {
    this.inscriptionForm = this.fb.group({ image: ['', Validators.required]});
  }
 
  private searchImage() {
    this.inscriptionService.getImageService(this.image)
      .subscribe(response => this.imageFind = response);
    console.log(this.image);
  }

  onSubmit() {
    this.searchImage();
  }

  goTo() {
    this.router.navigate(['home']);
  }

}
