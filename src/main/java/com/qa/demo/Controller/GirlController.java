package com.qa.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.domain.Girl;

@RestController 
//tells Spring that this is a Controller

public class GirlController {

	//LIST - WE havent got DB yet so we need to store data somewhere 
	private List<Girl> girlies = new ArrayList<>();
	
	//CRUD CONTROLLERS
	//We will replace CRUD with Response Entity, this is an extension of HTTP response including status code, headers and body 
	//create
	@PostMapping("/create") //201 - created
	public ResponseEntity<Girl> createGirl(@RequestBody Girl g) {
		this.girlies.add(g);
		Girl created = this.girlies.get(this.girlies.size()-1);
		ResponseEntity<Girl> response = new ResponseEntity<Girl>(created, HttpStatus.CREATED);
		return response;
	}	
	//read all
	@GetMapping("/getAll") //200 - OK
	public ResponseEntity<List<Girl>> getAllGirlies() {
		return ResponseEntity.ok(this.girlies);
	}
	//read one
	@GetMapping("/get/{id}") //200 - OK
	public Girl getGirl(@PathVariable Integer id) {
		return this.girlies.get(id);
	}
	//update
	@PutMapping("/replace/{id}") //202 - accepted
	public ResponseEntity<Girl> replaceGirl(@PathVariable Integer id, @RequestBody Girl newGirl) {
		Girl body = this.girlies.set(id, newGirl);
		ResponseEntity<Girl> response = new ResponseEntity<Girl>(body, HttpStatus.ACCEPTED);
		return response;
	}
	//remove
	@DeleteMapping("/remove/{id}") //204 - no content
		public ResponseEntity<?> removeGirl(@PathVariable Integer id) {
			this.girlies.remove(id.intValue());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
		
}
