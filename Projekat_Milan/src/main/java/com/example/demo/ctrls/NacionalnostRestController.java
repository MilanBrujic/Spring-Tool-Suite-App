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

import com.example.demo.jpa.Nacionalnost;
import com.example.demo.reps.NacionalnostRepository;

@RestController
public class NacionalnostRestController {

	@Autowired
	private NacionalnostRepository nacionalnostRepository;

	
	@RequestMapping(value = "nacionalnost", method = RequestMethod.GET)
	public Collection<Nacionalnost> getNacionalnost(){
			return nacionalnostRepository.findAll();
		}
	
	@RequestMapping(value = "nacionalnost/{id}", method = RequestMethod.GET)
	public ResponseEntity<Nacionalnost> getNacionalnost(@PathVariable("id") Integer id){
		Nacionalnost nacionalnost = nacionalnostRepository.findOne(id);
		return new ResponseEntity<Nacionalnost>(nacionalnost, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "nacionalnost/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Nacionalnost> deleteNacionalnost(@PathVariable("id") Integer id){
		nacionalnostRepository.delete(id);
		return new ResponseEntity<Nacionalnost>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "nacionalnost/{id}", method = RequestMethod.POST)
	public ResponseEntity<Nacionalnost> nacionalnostIgrac(@PathVariable("id") Integer id, @RequestBody Nacionalnost nacionalnost){
			if(nacionalnostRepository.exists(nacionalnost.getId()))
				return new ResponseEntity<Nacionalnost>(HttpStatus.CONFLICT);
			nacionalnostRepository.save(nacionalnost);
			return new ResponseEntity<Nacionalnost>(HttpStatus.OK);

		}
	
	@RequestMapping(value = "nacionalnost/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Nacionalnost> updateNacionalnost(@PathVariable("id") Integer id, @RequestBody Nacionalnost nacionalnost){
		if(!nacionalnostRepository.exists(nacionalnost.getId()))
			return new ResponseEntity<Nacionalnost>(HttpStatus.NO_CONTENT);
		nacionalnostRepository.save(nacionalnost);
		return new ResponseEntity<Nacionalnost>(HttpStatus.OK);
	}
	
	
}
