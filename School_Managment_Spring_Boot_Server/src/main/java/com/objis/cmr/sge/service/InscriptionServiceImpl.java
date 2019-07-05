package com.objis.cmr.sge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Service;

import com.objis.cmr.sge.model.Eleve;
import com.objis.cmr.sge.model.Inscription;
import com.objis.cmr.sge.repository.InscriptionRepository;

@Service
@Primary
public class InscriptionServiceImpl implements InscriptionService{

	@Autowired
	private  InscriptionRepository inscriptionRepository;

	
	/*
	@Override
	public Page<Inscription> getInscription(@RequestParam(name="page", defaultValue="0")int p) {
		return inscriptionRepository.findAll(new PageRequest(p, 5));
	}
	*/
	@Override
	public Inscription findByMatricule(String matricule) {
		return inscriptionRepository.findByMatricule(matricule);
	}
	
	@Override
	public List<Inscription> getInscriptions() {
		return inscriptionRepository.findAll();
	}


	
	@Override
	public void updateInscription(Inscription inscription) {
		inscriptionRepository.save(inscription);
		
	}

	@Override
	public void deleteInscription(Long id) {
		Inscription inscription = new Inscription();
		inscription.setIdInscription(id);
		inscriptionRepository.deleteById(id);
		
	}

	@Override
	public Optional<Inscription> findByIdInscription(Long id) {
		// TODO Auto-generated method stub
		return inscriptionRepository.findByIdInscription(id);
	}


	@Override
	public Inscription addInscription(Inscription inscription) {
		// TODO Auto-generated method stub
		return inscriptionRepository.save(inscription);
	}

	
}
