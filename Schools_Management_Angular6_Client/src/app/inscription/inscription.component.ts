import { Component, OnInit, Input } from '@angular/core';
import { Inscriptions } from '../shared/inscriptions';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { InscriptionService } from '../home/inscription.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  matricule: string;
  inscription: Inscriptions;

  inscriptionForm: FormGroup;

  constructor(private dataService: InscriptionService, private fb: FormBuilder) {
    this.createForm();
   }

  ngOnInit() {
    this.matricule = null;
  }

  createForm() {
    this.inscriptionForm = this.fb.group({ matricule: ['', Validators.required] });
  }

  private searchInscriptions() {
    this.dataService.getUserByMatricule(this.matricule)
      .subscribe(inscription => this.inscription = inscription);
    console.log(this.inscription);
  }

  onSubmit() {
    this.searchInscriptions();
  }
}
