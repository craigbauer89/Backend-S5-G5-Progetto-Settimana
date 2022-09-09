package com.epicode.dispostivi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.dispostivi.it.security.auth.users.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DispositiviService {

	@Autowired
	@Qualifier("dispositivi")
	private User dispositivi;
	
	@Autowired
	@Qualifier("dispositivi2")
	private User dispositivi2;
	
	@Autowired
	@Qualifier("dispositivi3")
	private User dispositivi3;
	
	
	public User creaDispositivi() {
		return dispositivi;
	}
	
	public User creaDispositivi2() {
		return dispositivi2;
	}
	
	public User creaDispositivi3() {
		return dispositivi3;
	}
	
	public void stampaVideoPrenotazioni() {
		User utente1dispositivi = creaDispositivi();
		log.info("-----Prenotazioni delle Utente 1-----------");
		log.info("Prenotazioni *" +utente1dispositivi.toString());
		
		log.info("-------------------------------");
		
		
		User utente2dispositivi  = creaDispositivi2();
		log.info("-----Prenotazioni delle Utente 2-----------");
		log.info("Prenotazioni *" +utente2dispositivi.toString());
		
		log.info("-------------------------------");
		
		User utente3dispositivi = creaDispositivi3();
		log.info("-----Prenotazioni delle Utente 2-----------");
		log.info("Prenotazioni *" +utente3dispositivi.toString());
		
		log.info("-------------------------------");
	}

}
