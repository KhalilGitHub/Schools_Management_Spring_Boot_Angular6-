package com.objis.cmr.sge.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//ctrl+shift+O - shortcut for dependencies import

@Entity
@Table(name="Eleve")
@EntityListeners(AuditingEntityListener.class)

public class Eleve extends Personne implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8443158109664012147L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idEleve;
	
	private int age;
	private String classe;
	private String matricule;
	
	public Eleve() {
		super();
	}


	public Eleve(long idEleve, int age, String classe) {
		super();
		this.idEleve = idEleve;
		this.age = age;
		
	}
	
	public Eleve(long idEleve, String matricule, String nom, String prenom, String genre, String adresse, int age, String classe) {
		super(nom, prenom, genre, adresse);
		this.idEleve = idEleve;
		this.age = age;
		this.classe = classe;
		this.matricule = matricule;
	}

	


	public Eleve(String matricule, String nom, String prenom, String genre, String adresse, int age, String classe) {
		super(nom, prenom, genre, adresse);
		this.age = age;
		this.classe = classe;
		this.matricule = matricule;
	}

	
	
	
	public Long getIdEleve() {
		return idEleve;
	}


	public void setIdEleve(Long idEleve) {
		this.idEleve = idEleve;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	
	
	public String getClasse() {
		return classe;
	}


	public void setClasse(String classe) {
		this.classe = classe;
	}


	@Override
	public String toString() {
		return "Eleve [idEleve=" + idEleve + ", age=" + age + ", nom=" + nom + ", prenom=" + prenom
				+ ", genre=" + genre + ", adresse=" + adresse + "]";
	}
			
}
