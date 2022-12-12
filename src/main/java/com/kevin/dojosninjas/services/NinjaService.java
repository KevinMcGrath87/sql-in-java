package com.kevin.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kevin.dojosninjas.models.Ninja;
import com.kevin.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	
	}
	
	public Ninja create(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public Ninja getNinjaById(Long id) {
		
		if (ninjaRepository.findById(id).isPresent()) {
			return ninjaRepository.findById(id).get();
		}
		else {
			return null;
		}
	}
	
	
	

}
