import { Component, OnInit } from '@angular/core';
import { InscriptionComponent } from '../inscription/inscription.component';
import { InscriptionService } from '../home/inscription.service';
import { Response } from 'selenium-webdriver/http';

@Component({
  selector: 'app-diplay-images',
  templateUrl: './diplay-images.component.html',
  styleUrls: ['./diplay-images.component.css']
})
export class DiplayImagesComponent implements OnInit {

  images: any = [];

  constructor(private inscriptionService: InscriptionService) { }

  ngOnInit() {
    this.getImages()
  }

  getImages(){
    this.inscriptionService.getImagesService().subscribe(Response => {
      this.images = Response;
      console.log(Response)
      console.log('Images loaded successfuly...')
    });
  }

}
