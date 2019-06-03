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

import com.example.demo.jpa.Tim;
import com.example.demo.reps.TimRepository;

@RestController
public class TimRestController {

	@Autowired
	private TimRepository timRepository;

	
	@RequestMapping(value = "tim", method = RequestMethod.GET)
	public Collection<Tim> getTim(){
			return timRepository.findAll();
		}
	
	@RequestMapping(value = "tim/{id}", method = RequestMethod.GET)
	public ResponseEntity<Tim> getTim(@PathVariable("id") Integer id){
		Tim tim= timRepository.findOne(id);
		return new ResponseEntity<Tim>(tim, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "tim/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Tim> deleteTim(@PathVariable("id") Integer id){
		timRepository.delete(id);
		return new ResponseEntity<Tim>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "tim/{id}", method = RequestMethod.POST)
	public ResponseEntity<Tim> insertTim(@PathVariable("id") Integer id, @RequestBody Tim tim){
			if(timRepository.exists(tim.getId()))
				return new ResponseEntity<Tim>(HttpStatus.CONFLICT);
			timRepository.save(tim);
			return new ResponseEntity<Tim>(HttpStatus.OK);

		}
	
	@RequestMapping(value = "tim/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Tim> updatetim(@PathVariable("id") Integer id, @RequestBody Tim tim){
		if(!timRepository.exists(tim.getId()))
			return new ResponseEntity<Tim>(HttpStatus.NO_CONTENT);
		timRepository.save(tim);
		return new ResponseEntity<Tim>(HttpStatus.OK);
	}
	
	
}
