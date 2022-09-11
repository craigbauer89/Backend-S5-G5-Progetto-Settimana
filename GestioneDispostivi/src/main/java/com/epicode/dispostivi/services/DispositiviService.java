package com.epicode.dispostivi.services;



import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.dispostivi.dto.Userdto;
import com.epicode.dispostivi.entity.Laptop;
import com.epicode.dispostivi.entity.SmartPhone;
import com.epicode.dispostivi.entity.Tablet;
import com.epicode.dispostivi.it.security.auth.users.User;
import com.epicode.dispostivi.repository.DispositiviRepository;
import com.epicode.dispostivi.repository.UtenteRepository;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DispositiviService {
	
	@Autowired
	DispositiviRepository dispositiviRepository;
	
	@Autowired
	UtenteRepository utenteRepository;
	
	@Autowired
	@Qualifier("smartphone")
	private SmartPhone smartphone;
	
	@Autowired
	@Qualifier("laptop")
	private Laptop laptop;
	
	@Autowired
	@Qualifier("tablet")
	private Tablet tablet;
	
	
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
	
	public void modifica(Long id,Userdto dto) {
		
		if (!utenteRepository.existsById(id)) {
			throw new EntityNotFoundException("Utente non trovato");
		}
		
		User l = utenteRepository.findById(id).get();
		BeanUtils.copyProperties(dto, l);
		
		utenteRepository.save(l);
		
		
		
	}

	public User trovaperId(Long id) {
		if(!utenteRepository.existsById(id)) {
			throw new EntityNotFoundException("Utente non trovato");
		}
		return utenteRepository.findById(id).get();
	}
	
	public User crea(Userdto dto) {
		
		if (utenteRepository.existsByNome(dto.getNome())) {
			throw new EntityExistsException("Utente gia esistente");
		}
		User u = new User();
		BeanUtils.copyProperties(dto, u);
		utenteRepository.save(u);
		return u;
		
	}
	
	public void cancella(Long id) {
		if(!utenteRepository.existsById(id)) {
			throw new EntityNotFoundException("Utente non trovato");
		}
		utenteRepository.deleteById(id);
		
	}

	
	public void stampaVideoDispositivi() {
		User utente1dispositivi = creaDispositivi();
		log.info("-----Dispositivi delle Utente 1-----------");
		log.info("Dispositivi *" +utente1dispositivi.toString());
		
		log.info("-------------------------------");
		
		
		User utente2dispositivi  = creaDispositivi2();
		log.info("-----Dispositivi delle Utente 2-----------");
		log.info("Dispositivi *" +utente2dispositivi.toString());
		
		log.info("-------------------------------");
		
		User utente3dispositivi = creaDispositivi3();
		log.info("-----Dispositivi delle Utente 2-----------");
		log.info("Dispositivi *" +utente3dispositivi.toString());
		
		log.info("-------------------------------");
	}
	


}
