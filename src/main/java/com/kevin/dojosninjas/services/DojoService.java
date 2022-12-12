package com.kevin.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kevin.dojosninjas.models.Dojo;
import com.kevin.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}
	
	public Dojo create(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	public Dojo getDojoById(Long id) {
		Optional<Dojo> testDojo = dojoRepository.findById(id); 
		if (testDojo.isPresent()) {
			return testDojo.get();
		}
		else {
			return null;
		}
	}

}
