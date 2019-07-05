package com.objis.cmr.sge.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.objis.cmr.sge.domaine.InscriptionDto;
import com.objis.cmr.sge.domaine.Response;
import com.objis.cmr.sge.model.Eleve;
import com.objis.cmr.sge.model.Inscription;
import com.objis.cmr.sge.service.InscriptionService;

@RestController
@RequestMapping("/api/inscription")
@CrossOrigin(origins = "http://localhost:4200")
public class InscriptionController {
	
	@Autowired
	private  InscriptionService inscriptionService;
	
	@Autowired
	ServletContext context;
	
	@GetMapping("/getAll")
	public List<Inscription> getInscriptions(){
		
		return inscriptionService.getInscriptions();
		
	}
	
	@GetMapping("/getOne/{matricule}")
	public Inscription getInscription(@PathVariable(value="matricule") String matricule)
	{
		System.out.println(matricule);
		Inscription inscrit = new Inscription();
		inscrit = inscriptionService.findByMatricule(matricule);
		return inscrit;
	}
	
	
	/*// !!!!!!!!  Save Image in MySql Database 
	@PostMapping("/saveInscription")
	public ResponseEntity<Response> saveInscription(@RequestParam("imageFile") MultipartFile imageFile, @RequestParam("inscrit") String inscrit) throws JsonParseException, JsonMappingException, IOException {
	
		System.out.println(imageFile);
		System.out.println(inscrit);
		
		InscriptionDto inscriptionDto = new ObjectMapper().readValue(inscrit, InscriptionDto.class);
		
		System.out.println(inscriptionDto);
		
		
		Eleve eleve = new Eleve();
		Inscription inscription = new Inscription();
		
		inscription.setPhoto(imageFile.getBytes());
		inscription.setImage(imageFile.getOriginalFilename());
		inscription.setDate(new Date());
		inscription.setAnnee(inscriptionDto.getAnnee());
		inscription.setFrais(inscriptionDto.getFrais());
		inscription.setMatricule(inscriptionDto.getMatricule());		
		
		
		eleve.setMatricule(inscriptionDto.getEleve().getMatricule());
		eleve.setNom(inscriptionDto.getEleve().getNom());
		eleve.setPrenom(inscriptionDto.getEleve().getPrenom());
		eleve.setGenre(inscriptionDto.getEleve().getGenre());
		eleve.setAge(inscriptionDto.getEleve().getAge());
		eleve.setAdresse(inscriptionDto.getEleve().getAdresse());
		eleve.setClasse(inscriptionDto.getEleve().getClasse());
		
		inscription.setEleve(eleve);
		
		System.out.println(inscription);
		Inscription dbInscription = inscriptionService.addInscription(inscription);
		
		if(dbInscription != null) {
			return new ResponseEntity<Response>(new Response("Inscription Enregistrer avec Success ..."), HttpStatus.OK);
		}
		
		else {
			return new ResponseEntity<Response>(new Response("Inscription n'a pas ete Enregistrer !!!"), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	*/
	
	
	// !!!!!!!!!!! Save Image in Server
	@PostMapping("/saveInscriptionInServer")
	public ResponseEntity<Response> saveInscriptionInServer(@RequestParam("imageFile") MultipartFile imageFile, @RequestParam("inscrit") String inscrit) throws JsonParseException, JsonMappingException, IOException {
	
		System.out.println(imageFile);
		System.out.println(inscrit);
	
		InscriptionDto inscriptionDto = new ObjectMapper().readValue(inscrit, InscriptionDto.class);
		
		System.out.println(inscriptionDto);
		
		
		Eleve eleve = new Eleve();
		Inscription inscription = new Inscription();
		
		//inscription.setPhoto(imageFile.getBytes());
		//inscription.setImage(imageFile.getOriginalFilename());
		inscription.setDate(new Date());
		inscription.setAnnee(inscriptionDto.getAnnee());
		inscription.setFrais(inscriptionDto.getFrais());
		inscription.setMatricule(inscriptionDto.getMatricule());		
		
		
		eleve.setMatricule(inscriptionDto.getEleve().getMatricule());
		eleve.setNom(inscriptionDto.getEleve().getNom());
		eleve.setPrenom(inscriptionDto.getEleve().getPrenom());
		eleve.setGenre(inscriptionDto.getEleve().getGenre());
		eleve.setAge(inscriptionDto.getEleve().getAge());
		eleve.setAdresse(inscriptionDto.getEleve().getAdresse());
		eleve.setClasse(inscriptionDto.getEleve().getClasse());
		
		inscription.setEleve(eleve);
		
		boolean isExist = new File(context.getRealPath("/inscriptions_imgs")).exists();
		if(!isExist) {
			new File(context.getRealPath("/inscriptions_imgs")).mkdir();
		}
		
		String fileName = imageFile.getOriginalFilename();
		String modifieFileName = FilenameUtils.getBaseName(fileName) + "_" + System.currentTimeMillis() + "." + FilenameUtils.getExtension(fileName);
		File serverFile = new File(context.getRealPath("/inscriptions_imgs" + File.separator + modifieFileName));
		
		try {
			FileUtils.writeByteArrayToFile(serverFile, imageFile.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		inscription.setImage(modifieFileName);
		
		///System.out.println(inscription);
		Inscription dbInscription = inscriptionService.addInscription(inscription);
		
		if(dbInscription != null) {
			return new ResponseEntity<Response>(new Response("Inscription Enregistrer avec Success ..."), HttpStatus.OK);
		}
		
		else {
			return new ResponseEntity<Response>(new Response("Inscription n'a pas ete Enregistrer !!!"), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	
	@PutMapping("/update/{id}")
	public void updateInscription(@PathVariable("id") long id, @RequestBody Inscription inscription) {
		
		System.out.println(inscription);
		System.out.println("Update Customer with ID = " + id + "...");

		Optional<Inscription> inscriptionData = inscriptionService.findByIdInscription(id);
		
		Eleve _eleve = new Eleve();
		
		if (inscriptionData.isPresent()) {
			
			Inscription _inscription = inscriptionData.get();
			
			_inscription.setIdInscription(inscription.getIdInscription());
			_inscription.setMatricule(inscription.getMatricule());
			_eleve.setIdEleve(inscription.getEleve().getIdEleve());
			_eleve.setMatricule(inscription.getEleve().getMatricule());
			_eleve.setNom(inscription.getEleve().getNom());
			_eleve.setPrenom(inscription.getEleve().getPrenom());
			_eleve.setGenre(inscription.getEleve().getGenre());
			_eleve.setAge(inscription.getEleve().getAge());
			_eleve.setAdresse(inscription.getEleve().getAdresse());
			_eleve.setClasse(inscription.getEleve().getClasse());
			_inscription.setEleve(_eleve);
			_inscription.setFrais(inscription.getFrais());
			_inscription.setDate(inscription.getDate());
			_inscription.setAnnee(inscription.getAnnee());
			_inscription.setImage(inscription.getImage());
			
			inscriptionService.updateInscription(_inscription);
		}
	
	}
	
	

	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable Long id) {
		inscriptionService.deleteInscription(id);
	}
	
	
	@GetMapping(value="/getImages")
	public ResponseEntity<List<String>>getImages(){
		
		List<String> inscriptions_imgs = new ArrayList<String>();
		
		String filePath = context.getRealPath("/inscriptions_imgs");
		
		File fileFolder = new File(filePath);
		
		if(fileFolder != null) {
			for(final File file: fileFolder.listFiles()) {
				if(!file.isDirectory()) {
					String encodeBase64 = null;
					try {
						String extension = FilenameUtils.getExtension(file.getName());
						FileInputStream fileInputStream = new FileInputStream(file);
						byte[] bytes = new byte[(int)file.length()];
						fileInputStream.read(bytes);
						encodeBase64 = Base64.getEncoder().encodeToString(bytes);
						inscriptions_imgs.add("data:image/" + extension + ";base64," + encodeBase64);
						fileInputStream.close();
						System.out.println(inscriptions_imgs);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return new ResponseEntity<List<String>>(inscriptions_imgs, HttpStatus.OK);
		
	}
	

	@GetMapping(value="/getImage/{image}")
	public ResponseEntity<String>getImage(@PathVariable(value="image")String image){
		
		//System.out.println(image);
		
		String filePath = context.getRealPath("/inscriptions_imgs/");
		String searchFile = null;
		File fileFolder = new File(filePath);
		
		if(fileFolder != null) {
			for(final File file: fileFolder.listFiles()) {
				if(image.equals(file.getName())) {
					String encodeBase64 = null;
					try {
						String extension = FilenameUtils.getExtension(file.getName());
						FileInputStream fileInputStream = new FileInputStream(file);
						byte[] bytes = new byte[(int)file.length()];
						fileInputStream.read(bytes);
						encodeBase64 = Base64.getEncoder().encodeToString(bytes);
						searchFile = "data:image/" + extension + ";base64," + encodeBase64;
						
						fileInputStream.close();
						//System.out.println(searchFile);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		//System.out.println(searchFile);
		return new ResponseEntity<String>(searchFile, HttpStatus.OK);
	}
	
	
}
