package com.kevin.burger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kevin.burger.models.Burger;
import com.kevin.burger.repositories.BurgerRepository;


@Service

public class BurgerService  {

	
	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}

	
	public List<Burger> allBurgers() {
		return burgerRepository.findAll();
		
	}
	public Burger findById(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		if (optionalBurger.isPresent()) { 
			return optionalBurger.get();
		}
			else {
				return null;
			}
		
	}
	
	public List<Burger> findByDescription(String description){
		return burgerRepository.findByDescription(description);
	}
	public List<Burger> findByName(String name){
		return burgerRepository.findByName(name);
	}
	
	public Long deleteByName(String name) {
//		List<Burger> burgers = burgerRepository.findByName(name);
//		for(Burger burger : burgers) {
//			burgerRepository.delete(burger);
//		}
		
		return burgerRepository.deleteByName(name);
		
	}
	public void deleteById(Long id) {
		burgerRepository.deleteById(id);
	}
	
	public Burger create(Burger burger) {
		return burgerRepository.save(burger);
	}
	public Long updateBurgerName(Burger burger, String newName) {
		
		burger.setName(newName);
		
		burgerRepository.save(burger);
		 
		return burger.getId();
		
	}
	public Long updateBurgerDescription(Burger burger, String newDescription) {
		burger.setDescription(newDescription);
		
		burgerRepository.save(burger);
		
		
		return burger.getId();
	}
	
	

}
