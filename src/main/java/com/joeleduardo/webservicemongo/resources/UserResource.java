package com.joeleduardo.webservicemongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joeleduardo.webservicemongo.domain.User;

@RestController //indica que a classe é um recurso REST
@RequestMapping(value= "/users") //informa o caminho do endpoint
public class UserResource {

	@GetMapping //indica que o método vai ser o endpoint no caminho /users
	public ResponseEntity<List<User>> findAll() {
		
		User maria = new User("1", "Maria Brown", "maria@gmail.com");	
		User alex = new User("2", "Alex Green", "Alex@gmail.com");	
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,alex));
		return ResponseEntity.ok().body(list);
	}
	
	
}
