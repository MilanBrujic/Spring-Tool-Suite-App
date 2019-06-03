package projekat.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import projekat.jpa.Igrac;
import projekat.reps.IgracRepository;

@RestController
public class IgracRestContoller {
	
	@Autowired
	private IgracRepository igracRepository;
	
	@RequestMapping(value = "igrac", method = RequestMethod.GET)
	public Collection<Igrac> getIgrac(){
		return igracRepository.findAll();
	}
	
	@RequestMapping(value = "igrac/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Igrac> deleteIgrac(@PathVariable("id") Integer id){
		igracRepository.delete(id);
		return new ResponseEntity<Igrac>(HttpStatus.OK);
	}
	
	//insert
	@RequestMapping(value = "igrac/{id}", method = RequestMethod.POST)
	public ResponseEntity<Igrac> insertIgrac(@PathVariable("id") Integer id, @RequestBody Igrac igrac){
		if(igracRepository.exists(igrac.getId()))
			return new ResponseEntity<Igrac>(HttpStatus.CONFLICT);
	igracRepository.save(igrac);
	return new ResponseEntity<Igrac>(HttpStatus.OK);
	}
	
	//update
	@RequestMapping(value = "igrac/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Igrac> updateIgrac(@PathVariable("id") Integer id,@RequestBody Igrac igrac){
		if(!igracRepository.exists(igrac.getId()))
			return new ResponseEntity<Igrac>(HttpStatus.NO_CONTENT);
		igracRepository.save(igrac);
		return new ResponseEntity<Igrac>(HttpStatus.OK);
		
	}

}
