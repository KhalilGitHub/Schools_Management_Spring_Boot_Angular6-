import { UpdatePersonne } from './update-personne';

export class UpdateEleve extends UpdatePersonne {

    constructor(
        public idEleve?: number,
        public nom?: string,
        public prenom?: string,
        public genre?: string,
        public adresse?: string,
        public age?: number,
        public classe?: string,
        public matricule?: string) {
        super(nom, prenom, genre, adresse);

    }
} 