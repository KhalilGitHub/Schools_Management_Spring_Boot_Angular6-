package com.objis.cmr.sge.model;

import java.util.Date;
import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Inscription implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idInscription;
	@NotEmpty
	private String matricule;
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Eleve eleve;
    private BigDecimal frais;
    @DateTimeFormat(pattern="dd-mm-yyyy")
    private Date date;
    private String annee;
    private String image;
    private byte[] photo;
   
    
    public Inscription() {
		super();
	}
    
    

	public Inscription(long idInscription) {
		super();
		this.idInscription = idInscription;
	}



	public Inscription(String matricule, Eleve eleve,  BigDecimal frais, String annee, Date date) {
		super();
		this.matricule = matricule;
		this.eleve = eleve;
		this.frais = frais;
		this.date = date;
		this.annee = annee;
	}



	public Inscription(String matricule, Eleve eleve, BigDecimal frais, Date date, String annee, String image) {
		super();
		this.matricule = matricule;
		this.eleve = eleve;
		this.frais = frais;
		this.date = date;
		this.annee = annee;
		this.image = image;
	}
	
	public Inscription(String matricule, Eleve eleve, BigDecimal frais, Date date, String annee, String image, byte[] photo) {
		super();
		this.matricule = matricule;
		this.eleve = eleve;
		this.frais = frais;
		this.date = date;
		this.annee = annee;
		this.image = image;
		this.photo = photo;
	}
		
	
	public Inscription(long idInscription, String matricule, Eleve eleve, BigDecimal frais, Date date, String annee, String image, byte[] photo) {
		super();
		this.idInscription = idInscription;
		this.matricule = matricule;
		this.eleve = eleve;
		this.frais = frais;
		this.date = date;
		this.annee = annee;
		this.image = image;
		this.photo = photo;
		
	}

	
	public long getIdInscription() {
		return idInscription;
	}



	public void setIdInscription(long idInscription) {
		this.idInscription = idInscription;
	}



	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public BigDecimal getFrais() {
		return frais;
	}
	

	public void setFrais(BigDecimal frais) {
		this.frais = frais;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}
	

	

	public byte[] getPhoto() {
		return photo;
	}



	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}



	@Override
	public String toString() {
		return "Inscription [idInscription=" + idInscription + ", matricule=" + matricule + ", eleve=" + eleve
				+ ", frais=" + frais + ", date=" + date + ", annee=" + annee + ", image=" + image + ", photo=" + photo
				+ "]";
	}
	
	/*
	@Override
	public String toString() {
		return "Inscription [idInscription=" + idInscription + ", matricule=" + matricule + ", eleve=" + eleve + ", frais=" + frais
				+ ", date=" + date + ", annee=" + annee + ", image=" + image + "]";
	}
	*/
	
}
