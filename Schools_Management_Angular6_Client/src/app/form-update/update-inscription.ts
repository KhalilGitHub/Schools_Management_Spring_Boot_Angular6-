import { UpdateEleve } from './update-eleve';

export class UpdateInscriptions {
    constructor(
        public idInscription?: number,
        public matricule?: string,
        public eleve?: UpdateEleve,
        public frais?: number,
        public date?: string,
        public annee?: string,
        public image?: string) { }
}