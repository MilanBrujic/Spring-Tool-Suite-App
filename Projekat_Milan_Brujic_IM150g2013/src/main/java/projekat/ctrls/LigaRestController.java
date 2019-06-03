package projekat.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekat.jpa.Liga;
import projekat.reps.LigaRepository;

@RestController
public class LigaRestController {
	
	@Autowired
	private LigaRepository ligaRepository;
	
	@RequestMapping(value = "liga", method = RequestMethod.GET)
	public Collection<Liga> getLiga(){
		return ligaRepository.findAll();
	}
	
	@RequestMapping(value = "liga/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Liga> deleteLiga(@PathVariable("id") Integer id){
		ligaRepository.delete(id);
		return new ResponseEntity<Liga>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "liga/{id}", method = RequestMethod.POST)
	public ResponseEntity<Liga> insertLiga(@PathVariable("id") Integer id, @RequestBody Liga liga){
		if(!ligaRepository.exists(liga.getId()))
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		ligaRepository.save(liga);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "liga/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Liga> updateLiga(@PathVariable("id") Integer id, @RequestBody Liga liga){
		if(!ligaRepository.exists(liga.getId()))
			return new ResponseEntity<Liga>(HttpStatus.NO_CONTENT);
		ligaRepository.save(liga);
		return new ResponseEntity<Liga>(HttpStatus.OK);
	}

}
