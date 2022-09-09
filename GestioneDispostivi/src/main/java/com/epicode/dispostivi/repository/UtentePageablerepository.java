package com.epicode.dispostivi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicode.dispostivi.it.security.auth.users.User;

public interface UtentePageablerepository extends PagingAndSortingRepository<User, Long> {

	

}
