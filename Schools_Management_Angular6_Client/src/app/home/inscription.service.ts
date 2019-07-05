import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_URLS } from '../config/api.url.config';
import { Inscriptions } from '../shared/inscriptions';
import { UpdateInscriptions } from '../form-update/update-inscription';
import { FormGroup } from '@angular/forms';


@Injectable({
  providedIn: 'root'
})
export class InscriptionService {
  
  constructor(private http: HttpClient) { }

  getUserByMatricule(matricule: string): Observable<any> {
    return this.http.get(API_URLS.GET_ONE_INSCRIPTIONS_URL + "/" + matricule);
  }


  getInscriptions(): Observable<any> {
    return this.http.get(API_URLS.GET_INSCRIPTIONS_URL);
  }

  
  addInscriptions(formData: FormData): Observable<any> {
    return this.http.post(API_URLS.SAVE_INSCRIPTIONS_URL, formData);
  }

  
  /*
  addInscriptions(inscription: Inscriptions): Observable<any> {
    return this.http.post(API_URLS.SAVE_INSCRIPTIONS_URL, inscription);
  }
  */
  
  getImagesService(): Observable<any> {
    return this.http.get(API_URLS.GET_IMAGES_URL);
  }

  getImageService(image: string): Observable<any> {
    return this.http.get(API_URLS.GET_IMAGE_URL + "/" + image);
  }

 
  deleteInscriptions(id: number): Observable<any> {
    return this.http.delete(`${API_URLS.DELETE_INSCRIPTIONS_URL}/${id}`, { responseType: 'text' });
  }
  

  updateInscriptions(id:number, inscription: UpdateInscriptions): Observable<any> {
    return this.http.put(API_URLS.UPDATE_INSCRIPTIONS_URL + "/" + id, inscription);
  } 

  /*
  deleteInscriptions(ref: string): Observable<any> {
    return this.http.delete(API_URLS.DELETE_INSCRIPTIONS_URL + `/${ref}`);
  }  */
}

