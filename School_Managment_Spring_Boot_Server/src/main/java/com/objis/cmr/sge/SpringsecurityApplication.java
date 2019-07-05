package com.objis.cmr.sge;


import java.math.BigDecimal;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


import com.objis.cmr.sge.model.Eleve;
import com.objis.cmr.sge.model.Inscription;
import com.objis.cmr.sge.repository.InscriptionRepository;


@SpringBootApplication
public class SpringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
		
		/*
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringsecurityApplication.class, args);
		
		InscriptionRepository inscriptionRepository = ctx.getBean(InscriptionRepository.class);
		
		
		
		
		Eleve e1 = new Eleve("LK001", "Hamdane", "Khalil", "Masculin", "Ridina", 14, "3eme");
		inscriptionRepository.save(new Inscription("LK001", e1, convertStringToBigDecimal("10000"), new Date("2019/10/15"), "2018/2019", "myPhoto"));		
									//Inscription(String matricule, Eleve eleve, BigDecimal frais, Date date, String annee, String image)
		
		Eleve e2 = new Eleve("LK002", "Halime", "Khalil", "Feminin", "Ridina", 14, "3eme");
		inscriptionRepository.save(new Inscription("LK002", e2, convertStringToBigDecimal("15000"), new Date("2019/10/15"), "2018/2019", "myPhoto"));

		Eleve e3 = new Eleve("LK003", "Aicha", "Khalil", "Femini", "Ridina", 14, "5eme");
		inscriptionRepository.save(new Inscription("LK003", e3, convertStringToBigDecimal("7000"), new Date("2019/09/25"), "2018/2019", "myPhoto"));

		Eleve e4 = new Eleve("LK004", "Hamid", "Khalil", "Masculin", "Ndjari", 14, "6eme");
		inscriptionRepository.save(new Inscription("LK003", e4, convertStringToBigDecimal("8000"), new Date("2019/09/25"), "2018/2019", "myPhoto"));
		*/
	}

	protected static BigDecimal convertStringToBigDecimal(String bdStr)
	 {
		 BigDecimal result = null;
		 try
			{
				double valueDouble = Double.parseDouble(bdStr);
				result = BigDecimal.valueOf(valueDouble);
			}
			catch(Exception ex)
			{
				System.out.println("Valeur invalid. Valeur par defaut to 0.0");
				result = BigDecimal.valueOf(0.0);
			}	
		return result;	
	}
	
	@Bean
	public UrlBasedCorsConfigurationSource  corsFilter() {

		CorsConfiguration config = new CorsConfiguration();
        config.applyPermitDefaultValues();
        config.setAllowCredentials(true);// this line is important it sends only specified domain instead of *
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("OPTIONS");
	    config.addAllowedMethod("HEAD");
	    config.addAllowedMethod("GET");
	    config.addAllowedMethod("PUT");
	    config.addAllowedMethod("POST");
	    config.addAllowedMethod("DELETE");
	    config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return source;
	}  

}
