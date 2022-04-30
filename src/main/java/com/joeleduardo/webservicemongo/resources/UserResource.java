package com.joeleduardo.webservicemongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(value="/{id}") //indica que o método vai ser o endpoint no caminho /users
	public ResponseEntity<UserDTO> findById(@PathVariable String id) { //junta o String id com o id recebido na url
	User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@PostMapping //anotação para inserir 
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) { //junta o String id com o id recebido na url
	User obj = service.fromDTO(objDto);
	obj = service.insert(obj);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
	return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value="/{id}") //indica que o método vai ser o endpoint no caminho /users
	public ResponseEntity<Void> delete(@PathVariable String id) { //junta o String id com o id recebido na url
	service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}") //indica que o método vai ser o endpoint no caminho /users
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) { //junta o String id com o id recebido na url
	User obj = service.fromDTO(objDto);
	obj.setId(id);
	obj = service.update(obj);
	return ResponseEntity.noContent().build();
	}
	
	
	
	
}
