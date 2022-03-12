package com.example.jpa2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("person")
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	
	//CRUD ==> create, Read, Update and delete
	
	@PostMapping
	public ResponseEntity<Person> createOrUpdate(@RequestBody Person person)
	{
		personRepository.save(person);	//CREATE or UPDATE
		return ResponseEntity.ok(person);
	}
	
	@GetMapping
	public Iterable<Person> readAll()
	{
		return personRepository.findAll();  //read all records
	}
	
	
	@GetMapping("/{id}")
	public Person read(@PathVariable Integer id)
	{
		return personRepository.findById(id).get();  //read one record
	}
	
	@GetMapping("/{id}")
	public Integer delete(@PathVariable Integer id)
	{
		personRepository.deleteById(id);	//delete the one record
		return id;
	}
	
}
