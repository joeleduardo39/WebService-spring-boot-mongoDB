package com.joeleduardo.webservicemongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeleduardo.webservicemongo.domain.User;
import com.joeleduardo.webservicemongo.repository.UserRepository;

@Service
public class UserService { //Acessa o repositório
	
	@Autowired //instancia o objeto automaticamente
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}

}
