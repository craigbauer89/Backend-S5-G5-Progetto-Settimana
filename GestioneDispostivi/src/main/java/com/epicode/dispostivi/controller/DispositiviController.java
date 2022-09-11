package com.epicode.dispostivi.controller;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.dispostivi.dto.Userdto;
import com.epicode.dispostivi.it.security.auth.users.User;
import com.epicode.dispostivi.repository.DispositiviRepository;
import com.epicode.dispostivi.repository.UtenteRepository;
import com.epicode.dispostivi.services.DispositiviService;





@RestController
@RequestMapping("/dispositivi")
public class DispositiviController {

	@Autowired
//	@Qualifier("dispositiviServiceImp")
	private DispositiviService dipositiviService;
	
	@Autowired
	private DispositiviRepository dispositiviRepository;
	
	@Autowired
	private UtenteRepository utenteRepository;
	

	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> creaLibro(@RequestBody Userdto dto) {
		

		try {
		return new ResponseEntity<User>(dipositiviService.crea(dto), HttpStatus.OK);
		}
		catch (EntityExistsException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
		}
	}
		

	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> inserisci(@PathVariable Long id, @RequestBody Userdto dto) {
		
		try {
		dipositiviService.modifica(id, dto);
		
		return new ResponseEntity<String>("Libro modificato con sucesso", HttpStatus.OK);
	}
		catch(EntityNotFoundException e) {
			return new ResponseEntity<String>("Libro non trovato", HttpStatus.NOT_FOUND);
		}
}
	

	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> trovaById(@PathVariable Long id) { 
		
		
			return ResponseEntity.ok(dipositiviService.trovaperId(id));
		
	}
	
	
	
	
	@DeleteMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> cancella(@PathVariable Long id) { 
	
		dipositiviService.cancella(id);
		 return ResponseEntity.ok("Utente eliminato");
	
		
		
	
	}

}
