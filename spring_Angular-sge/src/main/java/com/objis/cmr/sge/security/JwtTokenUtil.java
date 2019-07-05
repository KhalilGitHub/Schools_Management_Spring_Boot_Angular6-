package com.objis.cmr.sge.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable{


	private static final long serialVersionUID = 5822867727819148827L;
	
	static final String CLAM_KEY_USERNAME = "sub";
	static final String CLAM_KEY_AUDIENCE = "audience";
	static final String CLAM_KEY_CREATED = "created";
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Long expiration;
	

	public String getUsernameFormToken(String token) {
		
		String username = null;
		
		try {
			final Claims claims = getClaimsFormToken(token);
			username = claims.getSubject();
		}
		catch(Exception e) {
			username = null;
			
		}
		
		return username;
	}


	private Claims getClaimsFormToken(String token) {

		Claims claims = null;
		
		try {
			
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJwt(token).getBody();
			
		}
		catch(Exception e)
		{
			claims = null;
		}
		return claims;
	}


	public boolean validateToken(String token, UserDetails userDetails) {

		JwtUser user = (JwtUser)userDetails;
		final String username = getUsernameFormToken(token);
		
		return (username.equals(user.getUsername()) && !isTokenExpired(token));
	}


	private boolean isTokenExpired(String token) {

		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}


	private Date getExpirationDateFromToken(String token) {

		Date expiration = null;
		try
		{
			final Claims claims = getClaimsFormToken(token);
			if(claims != null) {
				expiration = claims.getExpiration();
			}else {
				expiration = null;
			}
		}catch(Exception e)
		{
			expiration = null;
		}
		return expiration;
	}


	public String generateTokem(JwtUser userDetails) {
		
		Map<String, Object> clamis = new HashMap<String, Object>();
		clamis.put(CLAM_KEY_USERNAME, userDetails.getUsername());
		clamis.put(CLAM_KEY_CREATED, new Date());
		
		return generateTokem(clamis);
	}


	private String generateTokem(Map<String, Object> clamis) {
		// TODO Auto-generated method stub
		return Jwts.builder().setClaims(clamis).setExpiration(generateExpirationDate()).signWith(SignatureAlgorithm.HS512, secret).compact();
	}


	private Date generateExpirationDate() {
		// TODO Auto-generated method stub
		return new Date(System.currentTimeMillis() + expiration*1000);
	}

}
