package com.objis.cmr.sge.domaine;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



public class InscriptionDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idInscription;
	private String matricule;
	private EleveDto eleve;
    private BigDecimal frais;
    private Date date;
    private String annee;
    private String image;

    public InscriptionDto() {
  		super();
  	}
      
      

  	public InscriptionDto(long idInscription) {
  		super();
  		this.idInscription = idInscription;
  	}



  	public InscriptionDto(String matricule, EleveDto eleve,  BigDecimal frais, String annee, Date date) {
  		super();
  		this.matricule = matricule;
  		this.eleve = eleve;
  		this.frais = frais;
  		this.date = date;
  		this.annee = annee;
  	}



  	public InscriptionDto(String matricule, EleveDto eleve, BigDecimal frais, Date date, String annee, String image) {
  		super();
  		this.matricule = matricule;
  		this.eleve = eleve;
  		this.frais = frais;
  		this.date = date;
  		this.annee = annee;
  		this.image = image;
  	}
  		
  	
  	public InscriptionDto(long idInscription, String matricule, EleveDto eleve, BigDecimal frais, Date date, String annee, String image) {
  		super();
  		this.idInscription = idInscription;
  		this.matricule = matricule;
  		this.eleve = eleve;
  		this.frais = frais;
  		this.date = date;
  		this.annee = annee;
  		this.image = image;
  		
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

  	public EleveDto getEleve() {
  		return eleve;
  	}

  	public void setEleve(EleveDto eleve) {
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
  	

  

  	@Override
  	public String toString() {
  		return "Inscription [idInscription=" + idInscription + ", matricule=" + matricule + ", eleve=" + eleve
  				+ ", frais=" + frais + ", date=" + date + ", annee=" + annee + ", image=" + image 
  				+ "]";
  	}
  	
  }
