package com.kevin.pocketbook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kevin.pocketbook.models.Expense;
import com.kevin.pocketbook.repositories.PocketbookRepository;

@Service
public class PocketbookService {
	
	private final PocketbookRepository pocketbookRepository;
	
	public PocketbookService (PocketbookRepository pocketbookRepository) {
		this.pocketbookRepository = pocketbookRepository;
	}
	
	public List<Expense> allExpenses() {
		return pocketbookRepository.findAll();
	}
	
	public void delete(Long id) {
		pocketbookRepository.deleteById(id);
	}
	
	public Expense findById(Long id) {
		Optional<Expense> optionalExpense = pocketbookRepository.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else {
			return null;
		}
		
	}
	public Expense create(Expense expense) {
		return pocketbookRepository.save(expense);
		
	}

}
