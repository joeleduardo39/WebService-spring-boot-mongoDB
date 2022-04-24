package com.joeleduardo.webservicemongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeleduardo.webservicemongo.domain.User;
import com.joeleduardo.webservicemongo.repository.UserRepository;
import com.joeleduardo.webservicemongo.services.exception.ObjectNotFoundException;

@Service
public class UserService { //Acessa o repositório
	
	@Autowired //instancia o objeto automaticamente
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
}
