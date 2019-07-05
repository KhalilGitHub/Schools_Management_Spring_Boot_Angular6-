import { Component, OnInit } from '@angular/core';
import { Inscriptions } from '../shared/inscriptions';
import { Eleve } from '../shared/eleve';

import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { InscriptionService } from '../home/inscription.service';
import { UpdateEleve } from './update-eleve';
import { UpdateInscriptions } from './update-inscription';

@Component({
  selector: 'app-form-update',
  templateUrl: './form-update.component.html',
  styleUrls: ['./form-update.component.css']
})
export class FormUpdateComponent implements OnInit {

  inscriptions: Inscriptions[];
  matricule: string;
  inscription: Inscriptions;
  selectedInscription: UpdateInscriptions;
  eleve: Eleve;
  inscriptionForm: FormGroup;

  operation: string = 'add';

  location: Location;

  constructor(private inscriptionService: InscriptionService, private fb: FormBuilder, private router: Router) {
    

  }

  ngOnInit() {
    this.matricule = null;
    this.selectedInscription = new  UpdateInscriptions();
    this.createForm();
  }

  createForm() {
    this.inscriptionForm = this.fb.group({
      matricule:[''],
      idInscription:[''],
      idEleve:[''],
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
      console.log(this.inscriptionForm.value);
    }, error => { console.log('An error was occur!!!') },
      () => { console.log('Saving Inscription was done successfuly...') }
    );
  }

  
  updateInscription() {
    const p = this.inscriptionForm.value;
    var e: UpdateEleve;
    e = new UpdateEleve(p.idEleve, p.nom, p.prenom, p.genre, p.adresse, p.age, p.classe, p.matricule);
    var ps: UpdateInscriptions
    ps = new UpdateInscriptions(p.idInscription, p.matricule, e, p.frais, p.date, p.annee, p.image);
    console.log(ps);
    this.inscriptionService.updateInscriptions(p.idInscription, ps).subscribe(res => {
      this.goTo();
    });
    
  }


  private searchCustomers() {
    this.inscriptionService.getUserByMatricule(this.matricule)
      .subscribe(inscription => this.inscription = inscription);
   
    
  }

  onSubmit() {
    this.searchCustomers();
  }

  goTo() {
    this.router.navigate(['home']);
  }
}

