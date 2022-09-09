package com.epicode.dispostivi.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.dispostivi.entity.Dispositivi;
import com.epicode.dispostivi.entity.Laptop;
import com.epicode.dispostivi.entity.SmartPhone;
import com.epicode.dispostivi.entity.Tablet;
import com.epicode.dispostivi.entity.TipoStato;
import com.epicode.dispostivi.it.security.auth.users.User;
import com.epicode.dispostivi.repository.DispositiviRepository;
import com.epicode.dispostivi.repository.UtenteRepository;




@Configuration
public class DispositiviConfigurazione {

	@Autowired
	private UtenteRepository repoUtente;

	@Autowired
	private DispositiviRepository repoDispositivi;
	
	
	@Autowired
	ObjectProvider<Dispositivi> prenotazioniProvider;
	
	@Bean("dispositivi")
	public User utente1Dispositivi() {
		
	
		Laptop dispositivo1 = (Laptop) prenotazioniProvider.getObject();
		dispositivo1.setSchermo(12);
		dispositivo1.setTipoStato(TipoStato.DISPONSIBILE);
		dispositivo1.setMarca("Apple");
		dispositivo1.setOperatingSystem("IOS");
		repoDispositivi.save(dispositivo1);
		
		Tablet dispositivo2 = (Tablet) prenotazioniProvider.getObject();
		dispositivo2.setSchermo(14);
		dispositivo2.setTipoStato(TipoStato.ASSENGATO);
		dispositivo2.setMarca("Apple");
		dispositivo2.setWithKeyboard(true);
		repoDispositivi.save(dispositivo1);
		
List<Dispositivi> dispositivi = new ArrayList<Dispositivi>();
		
	dispositivi.add(dispositivo1);
	dispositivi.add(dispositivo2);

		
		User utente = User.builder()
				
				.nome("Jim")
				.cognome("Bean")
				.password("111111")
				.username("jeanbean89")
				.email("jeanbean89@gmail.com")
				.dispositivi(dispositivi)
				.build();
		repoUtente.save(utente);
		return utente;
		
	}
	
	@Bean("dispositivi2")
	public User utente2Dispositivi() {
		
	
		Laptop dispositivo1 = (Laptop) prenotazioniProvider.getObject();
		dispositivo1.setSchermo(12);
		dispositivo1.setTipoStato(TipoStato.DISPONSIBILE);
		dispositivo1.setMarca("Apple");
		dispositivo1.setOperatingSystem("IOS");
		repoDispositivi.save(dispositivo1);
		
		Tablet dispositivo2 = (Tablet) prenotazioniProvider.getObject();
		dispositivo2.setSchermo(14);
		dispositivo2.setTipoStato(TipoStato.ASSENGATO);
		dispositivo2.setMarca("Apple");
		dispositivo2.setWithKeyboard(true);
		repoDispositivi.save(dispositivo1);
		
		SmartPhone dispositivo3 = (SmartPhone) prenotazioniProvider.getObject();
		dispositivo3.setSchermo(12);
		dispositivo3.setTipoStato(TipoStato.IN_MANUTENZIONE);
		dispositivo3.setMarca("Samsung");
		dispositivo3.setNummero("086666854721");
		repoDispositivi.save(dispositivo1);
		
List<Dispositivi> dispositivi = new ArrayList<Dispositivi>();
		
	dispositivi.add(dispositivo1);
	dispositivi.add(dispositivo2);
	dispositivi.add(dispositivo3);

		
		User utente = User.builder()
				
				.nome("Mary")
				.username("mmac")
				.email("mmac@yahoo.com")
				.cognome("McGuinness")
				.password("22222")
				.dispositivi(dispositivi)
				.build();
		repoUtente.save(utente);
		return utente;
		
	}
	
	@Bean("dispositivi3")
	public User utente3Dispositivi() {
		
	
		SmartPhone dispositivo1 = (SmartPhone) prenotazioniProvider.getObject();
		dispositivo1.setSchermo(12);
		dispositivo1.setTipoStato(TipoStato.IN_MANUTENZIONE);
		dispositivo1.setMarca("Apple");
		dispositivo1.setNummero(")8765678721");
		repoDispositivi.save(dispositivo1);
		
		
		
List<Dispositivi> dispositivi = new ArrayList<Dispositivi>();
		
	dispositivi.add(dispositivo1);


		
	User utente = User.builder()
			
			.nome("Owen")
			.username("oh67")
			.email("oh67@yahoo.com")
			.cognome("Hughes")
			.password("5555555")
			.dispositivi(dispositivi)
			.build();
	repoUtente.save(utente);
	return utente;
		
	}
}
