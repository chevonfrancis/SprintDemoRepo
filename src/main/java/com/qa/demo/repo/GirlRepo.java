package com.qa.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.domain.Girl;

@Repository
public interface GirlRepo extends JpaRepository<Girl, Integer> {
	
//Spring will auto generate all of the basic CRUD functionality
	
	List<Girl> findByNameIgnoreCase(String name);
	List<Girl> findByAge(Integer age);
	
}
