package com.objis.cmr.sge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.objis.cmr.sge.model.Eleve;
import com.objis.cmr.sge.model.Inscription;

import java.util.Optional;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;


public interface InscriptionRepository extends JpaRepository<Inscription, Long>{

	public Inscription findByMatricule(String mat);
	
	public Optional<Inscription> findByIdInscription(Long id);
	
	
	//public Inscription findByMatricule(String mat, Pageable pageable);
	
}
