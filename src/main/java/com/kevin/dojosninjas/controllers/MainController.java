package com.kevin.dojosninjas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kevin.dojosninjas.models.Dojo;
import com.kevin.dojosninjas.models.Ninja;
import com.kevin.dojosninjas.services.DojoService;
import com.kevin.dojosninjas.services.NinjaService;

@Controller

public class MainController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	
	public MainController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService =ninjaService;
		this.dojoService = dojoService;
	}
	
	@GetMapping("/")
		public String index(Model model) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos",dojos);
			model.addAttribute("ninjas");
			return "index.jsp";
		}
	@GetMapping("/ninja")
		public String ninjaForm(@ModelAttribute("ninja")Ninja ninja, Model model) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			return "newninja.jsp";
	}
	
	@GetMapping("/dojo")
		public String dojoForm(@ModelAttribute("dojo")Dojo dojo) {
		return "newdojo.jsp";
	}
	@PostMapping("/ninja/create")
		public String ninjaCreate(@ModelAttribute("ninja")Ninja ninja, BindingResult result) {
		ninjaService.create(ninja);
		return "redirect:/";
	}
	
	@PostMapping("/dojo/create")
		public String dojoCreate(@ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		 dojoService.create(dojo);
		 return "redirect:/";
	}
}
