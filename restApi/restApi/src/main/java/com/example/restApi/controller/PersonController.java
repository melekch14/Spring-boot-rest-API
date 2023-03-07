package com.example.restApi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApi.model.Person;
import com.example.restApi.repositories.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	
	@Autowired
	PersonRepository personRepository;
	
	
	@GetMapping("/findall")
	public List<Person> fetchAll(){
		return this.personRepository.findAll();
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addPerson(@RequestBody Person person ){
		
		return new ResponseEntity<>(this.personRepository.save(person),HttpStatus.CREATED);
		
	}
	
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable Integer id){
		
		if(this.personRepository.findById(id).isPresent()) {
			this.personRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<?> updatePerson(@PathVariable Integer id, @RequestBody Person person ){
		
		if(this.personRepository.findById(id).isPresent()) {
			
			person.setId(id);
			return new ResponseEntity<>(this.personRepository.save(person),HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		
		if(this.personRepository.findById(id).isPresent()) {
			
			return new ResponseEntity<>(this.personRepository.findById(id),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
	
	
	

}
