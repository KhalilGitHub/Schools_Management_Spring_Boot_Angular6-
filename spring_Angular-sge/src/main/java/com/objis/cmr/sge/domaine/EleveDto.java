package com.objis.cmr.sge.domaine;

import java.io.Serializable;


public class EleveDto extends PersonneDto implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private Long idEleve;
	
	private int age;
	private String classe;
	private String matricule;
	
	public EleveDto() {
		super();
	}


	public EleveDto(long idEleve, int age, String classe) {
		super();
		this.idEleve = idEleve;
		this.age = age;
		
	}
	
	public EleveDto(long idEleve, String matricule, String nom, String prenom, String genre, String adresse, int age, String classe) {
		super(nom, prenom, genre, adresse);
		this.idEleve = idEleve;
		this.age = age;
		this.classe = classe;
		this.matricule = matricule;
	}

	


	public EleveDto(String matricule, String nom, String prenom, String genre, String adresse, int age, String classe) {
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
