import { Component, OnInit } from '@angular/core';
import { Inscriptions } from '../shared/inscriptions';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { InscriptionService } from '../home/inscription.service';
import { Router } from '@angular/router';
import { UpdateInscriptions } from '../form-update/update-inscription';

@Component({
  selector: 'app-form-delete',
  templateUrl: './form-delete.component.html',
  styleUrls: ['./form-delete.component.css']
})
export class FormDeleteComponent implements OnInit {

  matricule: string;
  //idInscription: number;
  inscription: UpdateInscriptions;

  inscriptionForm: FormGroup;

  constructor(private inscriptionService: InscriptionService, private fb: FormBuilder, private router: Router) {
    this.createForm();
  }

  ngOnInit() {
    this.matricule = null;
    //this.idInscription = 0;
  }

  createForm() {
    this.inscriptionForm = this.fb.group({ matricule: ['', Validators.required]});
  }

  private searchInscription() {
    this.inscriptionService.getUserByMatricule(this.matricule)
      .subscribe(inscription => this.inscription = inscription);
    console.log(this.inscription);
  }

  deleteInscription() {

    this.inscriptionService.getUserByMatricule(this.matricule)
      .subscribe(inscription => this.inscription = inscription);

    this.inscriptionService.deleteInscriptions(this.inscription.idInscription)
      .subscribe(
        data => {
          console.log(data);
          this.goTo();
        },
        error => console.log(error));
  }

  goTo() {
    this.router.navigate(['home']);
  }

  onSubmit() {
    this.searchInscription();
  }
}
