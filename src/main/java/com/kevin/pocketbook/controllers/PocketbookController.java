package com.kevin.pocketbook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.kevin.pocketbook.models.Expense;
import com.kevin.pocketbook.services.PocketbookService;

@Controller
public class PocketbookController {
	private final PocketbookService pocketbookService;
	
	public PocketbookController(PocketbookService pocketbookService) {
		this.pocketbookService = pocketbookService;
	}
	
	@GetMapping("/")
	public String index(@ModelAttribute("newExpense")Expense expense, Model model){
		List<Expense> expenses = pocketbookService.allExpenses();
		model.addAttribute("expenses",expenses);
		return "index.jsp";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("newExpense")Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		else {
			System.out.println(expense.getExpense());
			pocketbookService.create(expense);
			return "redirect:/";
			}
		}
//	I may get errors here due to expense being the name of the variable passed into the view as well as expense being the name of the path.. etc.
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, @ModelAttribute("updateExpense")Expense updateExpense, Model model){
		Expense expense = pocketbookService.findById(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@PutMapping("/update")
	public String update(@Valid @ModelAttribute("updateExpense")Expense expense, BindingResult result) {
		
		if(result.hasErrors() ) {
			return"edit.jsp";
		}
		else {
			pocketbookService.create(expense);
			return "redirect:/";
		}
	}
	
	@DeleteMapping("/delete/{id}") 
	public String delete(@PathVariable("id")Long id) {
		pocketbookService.delete(id);
		return "redirect:/";
	}
	
	
	@PostMapping("/update/{id}")
	public String save(@Valid @ModelAttribute("updateExpense")Expense updateExpense, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		else {
			pocketbookService.create(updateExpense);
			return "redirect:/";
			}
		}
}
