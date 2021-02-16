package com.videoclub.webservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import modelo.Director;
import modelo.Pelicula;
import modelo.VideoclubRepository;

@RestController
public class PeliculaServiceController { 
	
	VideoclubRepository rep =new VideoclubRepository();
	
	@GetMapping(value = "/pelicula")
	public ResponseEntity<Object> getPeliculas(){
		return new ResponseEntity<>(rep.getPeliculas(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/pelicula/{id}")
	public ResponseEntity<Object> getPelicula(@PathVariable("id") String id) {
		return new ResponseEntity<>(rep.getPelicula(id), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/pelicula/{id}")
	public ResponseEntity<Object> deletePelicula(@PathVariable("id") String id) {
		rep.removePelicula(id);
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	@PutMapping(value = "/pelicula/{id}")
	public ResponseEntity<Object> updatePelicula(@PathVariable("id") String id, @RequestBody Pelicula pelicula) {
		rep.removePelicula(id);
		pelicula.setIdPelicula(id);
		rep.putPelicula(id, pelicula);
		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}

	@PostMapping(value = "/pelicula")
	public ResponseEntity<Object> createPelicula(@RequestBody Pelicula pelicula) {
		rep.putPelicula(pelicula.getIdPelicula(), pelicula);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/director")
	public ResponseEntity<Object> getDirectores(){
		return new ResponseEntity<>(rep.getDirectores(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/director/{id}")
	public ResponseEntity<Object> getDirector(@PathVariable("id") String id) {
		return new ResponseEntity<>(rep.getDirector(id), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/director/{id}")
	public ResponseEntity<Object> deleteDirector(@PathVariable("id") String id) {
		rep.removeDirector(id);
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	@PutMapping(value = "/director/{id}")
	public ResponseEntity<Object> updateDirector(@PathVariable("id") String id, @RequestBody Director director) {
		rep.removeDirector(id);
		director.setId(id);
		rep.putDirector(id, director);
		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}

	@PostMapping(value = "/director")
	public ResponseEntity<Object> createDirector(@RequestBody Director director) {
		rep.putDirector(director.getId(), director);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/director/{id}/pelicula")
	public ResponseEntity<Object> getModelos(@PathVariable("id") String idDirector) {
		return new ResponseEntity<>(rep.getFilmografia(idDirector), HttpStatus.OK);
	}
	
	

	
}
