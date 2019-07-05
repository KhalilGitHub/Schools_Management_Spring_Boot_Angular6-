import { Eleve } from './eleve';

export class Inscriptions{
    constructor(
        //public idInscription?: number,
        public matricule?: string,
        public eleve?: Eleve,
        public frais?: number,
        public date?: string,
        public annee?: string,
        public image?: string,
        ){}
}