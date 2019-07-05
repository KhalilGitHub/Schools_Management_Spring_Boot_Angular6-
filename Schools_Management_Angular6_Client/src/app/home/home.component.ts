import { Component, OnInit } from '@angular/core';
import { Inscriptions } from '../shared/inscriptions';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Eleve } from '../shared/eleve';
import { InscriptionService } from './inscription.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  inscriptions: Inscriptions[];

  inscriptionForm: FormGroup;

  operation: string = 'add';

  selectedInscription: Inscriptions;

  constructor(private inscriptionService: InscriptionService, private fb: FormBuilder) {
    this.createForm();
  }

  ngOnInit() {
    this.initInscription();
    this.loadInscriptions();
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

  loadInscriptions() {
    this.inscriptionService.getInscriptions().subscribe(data => {
      this.inscriptions = data
    }, error => { console.log('An error was occur!!!') },
      () => { console.log('Loading Inscription was done successfuly...') }
    );
  }

  initInscription() {
    this.selectedInscription = new Inscriptions();
    //this.createForm();
  }

/*
  addInscription() {
    const p = this.inscriptionForm.value;
    var e: Eleve;
    e = new Eleve(p.nom, p.prenom, p.genre, p.adresse, p.age, p.classe, p.matricule);
    var ps: Inscriptions
    ps = new Inscriptions(p.matricule, e, p.frais, p.date, p.annee, p.image);

    this.inscriptionService.addInscriptions(ps).subscribe(res => {
      console.log(ps);
      this.initInscription();
      this.loadInscriptions();
    });
  }

  
  updateInscription(){

    const p = this.inscriptionForm.value;
    const e= new Eleve(p.nom, p.prenom, p.genre, p.adresse, p.age, p.classe, p.matricule);
    //e = new Eleve(0, p.nom, p.prenom, p.genre, p.adresse, p.age, p.classe, p.matricule);
    const ps = new Inscriptions(p.matricule, e, p.frais, p.date, p.annee, p.image)
    //ps = new Inscriptions(0, p.matricule, e, p.frais, p.date, p.annee, p.image)

    this.inscriptionService.updateInscriptions(this.selectedInscription).subscribe(res => {
      this.initInscription()
      this.loadInscriptions();
    });
  }  

 

  deleteInscription() {
    this.inscriptionService.deleteInscriptions(this.selectedInscription.matricule).subscribe(res => {
      this.selectedInscription = new Inscriptions();
      this.loadInscriptions();
    });
  }
  */

}
