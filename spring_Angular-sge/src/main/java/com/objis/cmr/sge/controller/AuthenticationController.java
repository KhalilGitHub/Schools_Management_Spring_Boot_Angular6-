package com.objis.cmr.sge.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.objis.cmr.sge.UnAuthorizedException;
import com.objis.cmr.sge.domaine.UserDTO;
import com.objis.cmr.sge.model.User;
import com.objis.cmr.sge.security.JwtTokenUtil;
import com.objis.cmr.sge.security.JwtUser;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

	@Value("${jwt.header}")
	private String tokenHeader;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping(value="/login")
	public ResponseEntity<UserDTO> login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response){
		
		try
		{
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			final JwtUser userDetails = (JwtUser)authentication.getPrincipal();
			SecurityContextHolder.getContext().setAuthentication(authentication);
			final String token = jwtTokenUtil.generateTokem(userDetails);
			response.setHeader("Token", token);
			
			return new ResponseEntity<UserDTO>(new UserDTO(userDetails.getUser(), token), HttpStatus.OK);
		}catch (Exception e) {
			throw new UnAuthorizedException(e.getMessage());
		}
		
	}
}
