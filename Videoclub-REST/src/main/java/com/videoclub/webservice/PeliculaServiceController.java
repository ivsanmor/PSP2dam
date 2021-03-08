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
import modelo.Plataforma;
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
	 * Gets the pelicula. Devuelve las películas de un director
	 *
	 * @param idDirector the id director
	 * @return the response entity
	 */
	@GetMapping(value = "/director/{id}/pelicula")
	public ResponseEntity<Object> getModelos(@PathVariable("id") String idDirector) {
		if (rep.getDirector(idDirector) == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(rep.getFilmografia(idDirector), HttpStatus.OK);
	}
	/**
	 * Gets the pelicula. Devuelve la película con el id
	 *
	 * @param id the id
	 * @return the pelicula
	 */
	@GetMapping(value = "/director/{idDir}/pelicula/{idPel}")
	public ResponseEntity<Object> getPelicula(@PathVariable("idDir") String idDirector, @PathVariable("idPel") String idPel) {
		if (rep.getDirector(idDirector) == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(rep.getPelicula(idDirector, idPel), HttpStatus.OK);
	}
	
	/**
	 * Delete pelicula. Borra la película con el id 
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping(value = "director/{idDir}/pelicula/{idPel}")
	public ResponseEntity<Object> deletePelicula(@PathVariable("idDir") String idDir, @PathVariable("idPel") String idPel) {
		if (rep.getDirector(idDir) != null) {
			if (rep.getPelicula(idDir,idPel) != null) {
				rep.removePelicula(idDir,idPel);
				return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.NOT_ACCEPTABLE);
				
			} else {
				return new ResponseEntity<>("No existe esa pelicula", HttpStatus.NOT_ACCEPTABLE);
			}
		}
		return new ResponseEntity<>("No existe ese director", HttpStatus.OK);
		
		
		
		
	
	}

	/**
	 * Update pelicula. Actualiza una película
	 *
	 * @param id the id
	 * @param pelicula the pelicula
	 * @return the response entity
	 */
	@PutMapping(value = "director/{idDir}/pelicula/{idPel}")
	public ResponseEntity<Object> updatePelicula(@PathVariable("idDir") String idDir, @PathVariable("idPel") String idPel, @RequestBody Pelicula pelicula) {
		if (pelicula.getIdPelicula().equals("")) {
			return new ResponseEntity<>("Rellene los datos", HttpStatus.OK);
		}
		if (rep.getDirector(idDir) != null) {
			if (rep.getPelicula(idDir,idPel) != null) {
				if (rep.getPlataforma((pelicula.getPlataforma().getId())) == null) {
					return new ResponseEntity<>("Esa plataforma no existe", HttpStatus.NOT_ACCEPTABLE);
				}
				rep.removePelicula(idDir,idPel);
				pelicula.setIdPelicula(idPel);
				rep.putPelicula(idDir, pelicula);
				return new ResponseEntity<>("Product is updated successsfully", HttpStatus.NOT_ACCEPTABLE);
				
			} else {
				return new ResponseEntity<>("No existe esa pelicula", HttpStatus.NOT_ACCEPTABLE);
			}
		}
		
		return new ResponseEntity<>("No existe ese director", HttpStatus.OK);

	}

	/**
	 * Creates the pelicula. Añade una película
	 *
	 * @param pelicula the pelicula
	 * @return the response entity
	 */
	@PostMapping(value = "/director/{id}/pelicula")
	public ResponseEntity<Object> createPelicula(@PathVariable("id") String id, @RequestBody Pelicula pelicula) {
		if (rep.getDirector(id) != null) {
			if (pelicula.getIdPelicula().equals("")) {
				return new ResponseEntity<>("Rellene los datos por favor", HttpStatus.NOT_ACCEPTABLE);
			}
			if (rep.getPlataforma((pelicula.getPlataforma().getId())) == null) {
				return new ResponseEntity<>("Esa plataforma no existe", HttpStatus.NOT_ACCEPTABLE);
			}
			for (Pelicula p : rep.getPeliculas(id)) {
				if  (p.getIdPelicula().equals(pelicula.getIdPelicula())) {
					return new ResponseEntity<>("Esa pelicula ya existe", HttpStatus.NOT_ACCEPTABLE);
				}  
			}
			
			rep.putPelicula(id, pelicula);
			return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
		}
		
		else {
			return new ResponseEntity<>("Ese director no existe", HttpStatus.NOT_ACCEPTABLE);
		}
		
		
		
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
		if (rep.getDirector(id) == null) {
			return new ResponseEntity<>("No existe ese director", HttpStatus.OK);
		}
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
		if (director.getId().equals("")) {
			return new ResponseEntity<>("Rellene los datos", HttpStatus.OK);
		}
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
		
		if  (VideoclubRepository.directores.containsKey(director.getId())) {
			return new ResponseEntity<>("Ese director ya existe", HttpStatus.NOT_ACCEPTABLE);
		}  
		if (director.getId().equals("")) {
			return new ResponseEntity<>("Rellene los datos por favor", HttpStatus.NOT_ACCEPTABLE);
		} 
		rep.putDirector(director.getId(), director);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
		
	}
	
	
	/**
	 * Gets the plataformas. Devuelve todas las plataformas
	 *
	 * @return the plataformas
	 */
	@GetMapping(value = "/plataforma")
	public ResponseEntity<Object> getPlataformas(){
		return new ResponseEntity<>(rep.getPlataformas(), HttpStatus.OK);
	}
	
	/**
	 * Gets the plataforma. Devuelve la plataforma con el id
	 *
	 * @param id the id
	 * @return the pelicula
	 */
	@GetMapping(value = "/plataforma/{id}")
	public ResponseEntity<Object> getPlataforma(@PathVariable("id") String id) {
		return new ResponseEntity<>(rep.getPlataforma(id), HttpStatus.OK);
	}
	
	/**
	 * Delete plataforma. Borra la plataforma con el id 
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping(value = "/plataforma/{id}")
	public ResponseEntity<Object> deletePlataforma(@PathVariable("id") String id) {
		if (rep.getPlataforma(id) == null) {
			return new ResponseEntity<>("No existe esa plataforma", HttpStatus.OK);
		}
		rep.removePlataforma(id);
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	/**
	 * Update plataforma. Actualiza una plataforma
	 *
	 * @param id the id
	 * @param plataforma the plataforma
	 * @return the response entity
	 */
	@PutMapping(value = "/plataforma/{id}")
	public ResponseEntity<Object> updatePlataforma(@PathVariable("id") String id, @RequestBody Plataforma plataforma) {
		if (plataforma.getId().equals("")) {
			return new ResponseEntity<>("Rellene los datos", HttpStatus.OK);
		}
		rep.removePlataforma(id);
		plataforma.setId(id);
		rep.putPlataforma(id, plataforma);
		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}
	
	/**
	 * Creates the plataforma. Añade una plataforma.
	 *
	 * @param plataforma the plataforma
	 * @return the response entity
	 */
	@PostMapping(value = "/plataforma")
	public ResponseEntity<Object> createPlataforma(@RequestBody Plataforma plataforma) {
		
		if  (VideoclubRepository.plataformas.containsKey(plataforma.getId())) {
			return new ResponseEntity<>("Esa plataforma ya existe", HttpStatus.NOT_ACCEPTABLE);
		}  
		if (plataforma.getId().equals("")) {
			return new ResponseEntity<>("Rellene los datos por favor", HttpStatus.NOT_ACCEPTABLE);
		} 
		rep.putPlataforma(plataforma.getId(), plataforma);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}
		
		


	
	

	
}
