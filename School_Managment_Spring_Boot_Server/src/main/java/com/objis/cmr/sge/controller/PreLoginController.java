package com.objis.cmr.sge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.objis.cmr.sge.domaine.Response;
import com.objis.cmr.sge.model.User;
import com.objis.cmr.sge.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PreLoginController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value="/registration")
	public ResponseEntity<Response> registration(@RequestBody User user){
		
		User dbUser = userService.save(user);
		if(dbUser != null) {
			return new ResponseEntity<Response>(new Response("User is saved successfuly..."), HttpStatus.OK);
		}
		return null;
	}
}
