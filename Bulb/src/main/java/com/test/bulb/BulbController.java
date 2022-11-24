package com.test.bulb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bulb")
public class BulbController {

	@Autowired
	private BulbRepo repo;
	
	
	@PostMapping("/save")
	public String saveBulb(@RequestBody Bulb b) {
		
		repo.save(b);
		
		return "Bulb is saved successfully";
	}
	
	@GetMapping("/id/{id}")
	public Optional<Bulb> getBulb(@PathVariable("id") long id){
		
		return repo.findById(id);
	}
	
	@GetMapping("/details")
	public List<Bulb> getBulb(){
		
		return repo.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBub(@PathVariable("id") long id) {
		repo.deleteById(id);
		return "The requested bulb id "+id+" is deleted successfully";
	}
}
