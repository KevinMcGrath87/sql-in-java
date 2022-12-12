package com.kevin.dojosninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kevin.dojosninjas.models.Ninja;
//<type, idTYpe>

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();
/////errors will probably come of this...	
//	Ninja save(Ninja ninja);
	
	Optional<Ninja> findById(Long id);
	
	void deleteById(Long id);
	
	
	
	
	
	

}
