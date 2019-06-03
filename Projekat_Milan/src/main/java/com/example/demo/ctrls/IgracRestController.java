package com.example.demo.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jpa.Igrac;
import com.example.demo.reps.IgracRepository;

@RestController
public class IgracRestController {

	@Autowired
	private IgracRepository igracRepository;

	
	@RequestMapping(value = "igrac", method = RequestMethod.GET)
	public Collection<Igrac> getIgrac(){
			return igracRepository.findAll();
		}
	
	@RequestMapping(value = "igrac/{id}", method = RequestMethod.GET)
	public ResponseEntity<Igrac> getIgrac(@PathVariable("id") Integer id){
		Igrac igrac = igracRepository.findOne(id);
		return new ResponseEntity<Igrac>(igrac, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "igrac/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Igrac> deleteIgrac(@PathVariable("id") Integer id){
		igracRepository.delete(id);
		return new ResponseEntity<Igrac>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "igrac/{id}", method = RequestMethod.POST)
	public ResponseEntity<Igrac> insertIgrac(@PathVariable("id") Integer id, @RequestBody Igrac igrac){
			if(igracRepository.exists(igrac.getId()))
				return new ResponseEntity<Igrac>(HttpStatus.CONFLICT);
			igracRepository.save(igrac);
			return new ResponseEntity<Igrac>(HttpStatus.OK);

		}
	
	@RequestMapping(value = "igrac/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateIgrac(@PathVariable("id") Integer id, @RequestBody Igrac igrac){
		if(!igracRepository.exists(igrac.getId()))
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		igracRepository.save(igrac);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
}
