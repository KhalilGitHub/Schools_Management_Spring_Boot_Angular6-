import { Component, OnInit } from '@angular/core';
import { Inscriptions } from '../shared/inscriptions';
import { Eleve } from '../shared/eleve';

import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { InscriptionService } from '../home/inscription.service';


//import { ReplaySubject } from "rxjs/ReplaySubject";
//import { Observable } from "rxjs/Observable";


@Component({
  selector: 'app-form-inscription',
  templateUrl: './form-inscription.component.html',
  styleUrls: ['./form-inscription.component.css']
})
export class FormInscriptionComponent implements OnInit {

  inscriptions: Inscriptions[];

  inscriptionForm: FormGroup;

  public imageFile: any = File;

  

  constructor(private inscriptionService: InscriptionService, private fb: FormBuilder, private router: Router) {
    this.createForm();

  }

  /*/////Convert to base64
  readFile(fileToRead: File): Observable<any> {
    
    let base64Observable = new ReplaySubject<any>(0);

    let fileReader = new FileReader();
    fileReader.onload = event => {
      base64Observable.next(fileReader.result);
    };
    fileReader.readAsDataURL(fileToRead);

    return base64Observable;
  }
*/

  ngOnInit() {
    
  }

  createForm() {
    this.inscriptionForm = this.fb.group({
      matricule: ['', Validators.required],
      nom: '',
      prenom: '',
      genre: '',
      adresse: '',
      age: '',
      classe: '',
      frais: '',
      date: '',
      annee: '',
      image: ''

    });
  }


  onSelectFile(event) {
    const file = event.target.files[0];
    this.imageFile = file;
    
  } 


  loadInscriptions() {
    this.inscriptionService.getInscriptions().subscribe(data => {
      this.inscriptions = data
    }, error => { console.log('An error was occur!!!') },
      () => { console.log('Saving Inscription was done successfuly...') }
    );
  }

  saveInscription(){
    
      const inscrit = this.inscriptionForm.value;
      var e: Eleve;
      var ps: Inscriptions

      e = new Eleve(inscrit.nom, inscrit.prenom, inscrit.genre, inscrit.adresse, inscrit.age, inscrit.classe, inscrit.matricule);
      ps = new Inscriptions(inscrit.matricule, e, inscrit.frais, inscrit.date, inscrit.annee, inscrit.image);
   
      const inscriptionConst = ps;

    const formData = new FormData();
    formData.append('inscrit', JSON.stringify(inscriptionConst));
    formData.append('imageFile', this.imageFile);

    this.inscriptionService.addInscriptions(formData).subscribe(response => {
      console.log(response);
      this.goTo();
      });   
   
  }

 /* ///Form Field Validation
  validateFormFields(submitForm: FormGroup) {
    Object.keys(submitForm.controls).forEach(field => {
      const control = submitForm.get(field);
      if (control instanceof FormControl) {
        control.markAsTouched({ onlySelf: true });
      }
      else { //this.validateFormFields(control);
      }
    });
  }
  
*/

  goTo() {
    this.router.navigate(['home']);
  }
}

