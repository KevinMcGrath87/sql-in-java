package com.kevin.burger.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.kevin.burger.models.Burger;
import com.kevin.burger.services.BurgerService;

@Controller
public class BurgerController {
	private final BurgerService burgerService;
	
	public BurgerController(BurgerService burgerService) {
		this.burgerService = burgerService;
	}
	
	@GetMapping(value = "/")
	public String index(@ModelAttribute("burger")Burger burger, Model model) {
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers",burgers);
		for(Burger burg:burgerService.allBurgers()){
			System.out.println(burg.getName());
		}
		System.out.println(burgerService.allBurgers());
		
		return "index.jsp";
	}
	@PostMapping(value = "/create")
	public String create(@Valid @ModelAttribute("burger")Burger burger, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
			burgerService.create(burger);
			return("redirect:/");
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id")Long id, Model model) {
		Burger burger = burgerService.findById(id);
		model.addAttribute("burger", burger);
		return "edit.jsp";
	}
	
	@PutMapping("/update/{id}")
	public String update(@Valid @ModelAttribute("burger")Burger burger, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		burgerService.create(burger);		
		return "redirect:/";
		
	}
	
	

}
