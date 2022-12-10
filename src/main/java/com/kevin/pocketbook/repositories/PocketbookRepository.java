package com.kevin.pocketbook.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.kevin.pocketbook.models.Expense;


public interface PocketbookRepository extends CrudRepository<Expense, Long> {
	
	List<Expense> findAll();
	
	List<Expense> findByDescriptionContaining(String search);
	
	Optional<Expense> findById(Long id);
	
	void deleteById(Long id);
	
	


	
	

}
