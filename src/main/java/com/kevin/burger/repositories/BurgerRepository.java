package com.kevin.burger.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kevin.burger.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> {
	List<Burger> findAll();
	
	List<Burger> findByDescription(String description);
	
	List<Burger> findByName(String name);
	
	Long deleteByName(String name);
	
	void deleteById(Long id);

	
	
	
	

}
