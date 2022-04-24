package com.joeleduardo.webservicemongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joeleduardo.webservicemongo.domain.User;
import com.joeleduardo.webservicemongo.dto.UserDTO;
import com.joeleduardo.webservicemongo.services.UserService;

@RestController //indica que a classe é um recurso REST 
@RequestMapping(value= "/users") //informa o caminho do endpoint
public class UserResource {                                             // controlador REST

	@Autowired
	private UserService service;
	
	
	
	@GetMapping //indica que o método vai ser o endpoint no caminho /users
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
}
