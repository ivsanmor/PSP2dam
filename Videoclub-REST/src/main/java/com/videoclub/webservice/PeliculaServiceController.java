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

// TODO: Auto-generated Javadoc
/**
 * The Class PeliculaServiceController.
 */
@RestController
public class PeliculaServiceController { 
	
	/** El repositorio con las peliculas y directores */
	VideoclubRepository rep =new VideoclubRepository();
	
	/**
	 * Gets the peliculas. Devuelve todas las películas
	 *
	 * @return the peliculas
	 */
	@GetMapping(value = "/pelicula")
	public ResponseEntity<Object> getPeliculas(){
		return new ResponseEntity<>(rep.getPeliculas(), HttpStatus.OK);
	}
	
	/**
	 * Gets the pelicula. Devuelve la película con el id
	 *
	 * @param id the id
	 * @return the pelicula
	 */
	@GetMapping(value = "/pelicula/{id}")
	public ResponseEntity<Object> getPelicula(@PathVariable("id") String id) {
		return new ResponseEntity<>(rep.getPelicula(id), HttpStatus.OK);
	}
	
	/**
	 * Delete pelicula. Borra la película con el id 
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping(value = "/pelicula/{id}")
	public ResponseEntity<Object> deletePelicula(@PathVariable("id") String id) {
		rep.removePelicula(id);
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	/**
	 * Update pelicula. Actualiza una película
	 *
	 * @param id the id
	 * @param pelicula the pelicula
	 * @return the response entity
	 */
	@PutMapping(value = "/pelicula/{id}")
	public ResponseEntity<Object> updatePelicula(@PathVariable("id") String id, @RequestBody Pelicula pelicula) {
		rep.removePelicula(id);
		pelicula.setIdPelicula(id);
		rep.putPelicula(id, pelicula);
		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}

	/**
	 * Creates the pelicula. Añade una película
	 *
	 * @param pelicula the pelicula
	 * @return the response entity
	 */
	@PostMapping(value = "/pelicula")
	public ResponseEntity<Object> createPelicula(@RequestBody Pelicula pelicula) {
		rep.putPelicula(pelicula.getIdPelicula(), pelicula);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}
	
	/**
	 * Gets the directores. Devuelve todos los directores.
	 *
	 * @return the directores
	 */
	@GetMapping(value = "/director")
	public ResponseEntity<Object> getDirectores(){
		return new ResponseEntity<>(rep.getDirectores(), HttpStatus.OK);
	}
	
	/**
	 * Gets the director. Devuelve el director con el id
	 *
	 * @param id the id
	 * @return the director
	 */
	@GetMapping(value = "/director/{id}")
	public ResponseEntity<Object> getDirector(@PathVariable("id") String id) {
		return new ResponseEntity<>(rep.getDirector(id), HttpStatus.OK);
	}
	
	/**
	 * Delete director. Borra el director con el id
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping(value = "/director/{id}")
	public ResponseEntity<Object> deleteDirector(@PathVariable("id") String id) {
		rep.removeDirector(id);
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	/**
	 * Update director. Actualizar un director
	 *
	 * @param id the id
	 * @param director the director
	 * @return the response entity
	 */
	@PutMapping(value = "/director/{id}")
	public ResponseEntity<Object> updateDirector(@PathVariable("id") String id, @RequestBody Director director) {
		rep.removeDirector(id);
		director.setId(id);
		rep.putDirector(id, director);
		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}

	/**
	 * Creates the director. Añade un director.
	 *
	 * @param director the director
	 * @return the response entity
	 */
	@PostMapping(value = "/director")
	public ResponseEntity<Object> createDirector(@RequestBody Director director) {
		rep.putDirector(director.getId(), director);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}
	
	/**
	 * Gets the pelicula. Devuelve las películas de un director
	 *
	 * @param idDirector the id director
	 * @return the response entity
	 */
	@GetMapping(value = "/director/{id}/pelicula")
	public ResponseEntity<Object> getModelos(@PathVariable("id") String idDirector) {
		return new ResponseEntity<>(rep.getFilmografia(idDirector), HttpStatus.OK);
	}
	
	

	
}
