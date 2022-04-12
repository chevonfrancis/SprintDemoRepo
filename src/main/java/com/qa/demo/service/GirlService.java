package com.qa.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.demo.domain.Girl;
import com.qa.demo.repo.GirlRepo;

@Service //stores main business logic of the application
public class GirlService implements ServiceIF<Girl>{

	private GirlRepo repo;
	
	@Autowired
	public GirlService(GirlRepo repo) {
		super();
		this.repo = repo;
	}
	
	//CRUD Functionality 
	
	//INSERT INTO Girl
	public Girl create(Girl g) {
	Girl created = this.repo.save(g);	
	return created;
	}
	
	//SELECT * FROM Girl
	 public List<Girl> getAll() {
		 return this.repo.findAll();
	 }
	 
	 //SELECT * FROM Girl WHERE ID =
	 public Girl getOne(Integer id) {
		Optional <Girl> found = this.repo.findById(id);
		return found.get();
	 }
	 
	 //UPDATE
	 public Girl replace(Integer id, Girl newGirl) {
		 Girl existing = this.repo.findById(id).get();
		 existing.setAge(newGirl.getAge());
		 existing.setHairColor(newGirl.getHairColor());
		 existing.setName(newGirl.getName());
		 Girl updated = this.repo.save(existing);
		 return updated;
	 }
	 //DELETE FROM Girl WHERE ID =
	public void remove(@PathVariable Integer id) {
		this.repo.deleteById(id);
	}
	 
	//SELECT * FROM Girl WHERE name =
	public List <Girl> getGirliesByName(String name) {
		List <Girl> found = this.repo.findByNameIgnoreCase(name);
		return found;
	 }
	//SELECT * FROM Girl WHERE age=
	public List <Girl> getGirliesByAge(Integer age) {
		List <Girl> found = this.repo.findByAge(age);
		return found;
	 }
}
