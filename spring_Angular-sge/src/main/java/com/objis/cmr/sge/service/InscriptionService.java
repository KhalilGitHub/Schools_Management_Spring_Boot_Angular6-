package com.objis.cmr.sge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.objis.cmr.sge.model.Eleve;
import com.objis.cmr.sge.model.Inscription;

//import org.springframework.data.domain.Page;
//import org.springframework.web.bind.annotation.RequestParam;


public interface InscriptionService {
	
	public Optional<Inscription> findByIdInscription(Long id);
	
	public Inscription findByMatricule(String mat);
	
	List<Inscription> getInscriptions();
	
	public Inscription addInscription(Inscription inscription);
	
	public void updateInscription(Inscription inscription);

	public void deleteInscription(Long id);
}
