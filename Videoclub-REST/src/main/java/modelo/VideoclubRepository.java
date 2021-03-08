package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RestController;


// TODO: Auto-generated Javadoc
/**
 * The Class VideoclubRepository.
 */
@RestController
public class VideoclubRepository {
	
	
	/**  La constante que guarda todas las peliculas. 
    public static final Map<String, Pelicula> peliculas = new HashMap<>();*/
    
    /**  La constante que guarda todos los directores. */
    public static final Map<String, Director> directores = new HashMap<>();
    
    /**  La constante que guarda las peliculas de cada director. */
    public static final Map<String, ArrayList<Pelicula>> filmografia = new HashMap<>();
    
    /** The Constant plataformas. */
    public static final Map<String, Plataforma> plataformas = new HashMap<>();
    
    /**
     * Inits the data.
     */
    
    public VideoclubRepository() {
    	
    	ArrayList<Pelicula> pelis = new ArrayList<>();
    	//Creo todas las plataformas de visualizado
    	Plataforma netflix = new Plataforma();
    	netflix.setId("1");
    	netflix.setNombre("Netflix");
    	netflix.setPrecio(10);
    	netflix.setAno(1997);
    	Plataforma amazon = new Plataforma();
    	amazon.setId("2");
    	amazon.setNombre("Amazon");
    	amazon.setPrecio(8);
    	amazon.setAno(1994);
    	Plataforma hbo = new Plataforma();
    	hbo.setId("3");
    	hbo.setNombre("HBO");
    	hbo.setPrecio(12);
    	hbo.setAno(1972);
    	plataformas.put(netflix.getId(), netflix);
    	plataformas.put(amazon.getId(), amazon);
    	plataformas.put(hbo.getId(), hbo);
    	
    	//Primer director con sus peliculas
    	Director director = new Director();
    	director.setId("1");
    	director.setNombre("Quentin Tarantino");
    	director.setEdad(57);
    	director.setNacionalidad("estadounidense");
    	
    	directores.put(director.getId(), director);
         
        Pelicula pelicula = new Pelicula();
        pelicula.setIdPelicula("1");
        pelicula.setNombre("Malditos Bastardos");
        pelicula.setDuracion(153);
        pelicula.setGenero("Drama");
        pelicula.setPlataforma(netflix);
        pelis.add(pelicula);
        
        pelicula = new Pelicula();
        pelicula.setIdPelicula("2");
        pelicula.setNombre("Django Desencadenado");
        pelicula.setDuracion(170);
        pelicula.setGenero("Oeste");
        pelicula.setPlataforma(amazon);
        pelis.add(pelicula);
        
        filmografia.put(director.getId(), pelis);
        
        //Segundo director
        pelis = new ArrayList<>();
        director = new Director();
        director.setId("2");
    	director.setNombre("Christopher Nolan");
    	director.setEdad(50);
    	director.setNacionalidad("británico");
    	directores.put(director.getId(), director);
         
        pelicula = new Pelicula();
        pelicula.setIdPelicula("3");
        pelicula.setNombre("Tenet");
        pelicula.setDuracion(150);
        pelicula.setGenero("Thriller");
        pelicula.setPlataforma(hbo);
        pelis.add(pelicula);
        
        pelicula = new Pelicula();
        pelicula.setIdPelicula("4");
        pelicula.setNombre("Origen");
        pelicula.setDuracion(148);
        pelicula.setGenero("Drama");
        pelicula.setPlataforma(netflix);
        pelis.add(pelicula);
        
        filmografia.put(director.getId(), pelis);
        
        //Tercer director
        pelis = new ArrayList<>();
        director = new Director();
        director.setId("3");
    	director.setNombre("Steven Spielberg");
    	director.setEdad(74);
    	director.setNacionalidad("estadounidense");
    	directores.put(director.getId(), director);
         
        pelicula = new Pelicula();
        pelicula.setIdPelicula("5");
        pelicula.setNombre("La lista de Schindler");
        pelicula.setDuracion(195);
        pelicula.setGenero("Drama");
        pelicula.setPlataforma(amazon);
        pelis.add(pelicula);
        
        pelicula = new Pelicula();
        pelicula.setIdPelicula("6");
        pelicula.setNombre("Parque Jurásico");
        pelicula.setDuracion(127);
        pelicula.setGenero("Aventura");
        pelicula.setPlataforma(hbo);
        pelis.add(pelicula);
        
        filmografia.put(director.getId(), pelis);
         
    }
 

    
    /**
     * Find director, devuelve el director con el nombre pasado por parámetros.
     *
     * @param name el nombre del director
     * @return the director
     */
    public Director findDirector(String name) {
        Assert.notNull(name, "El nombre del director no puede ser nulo");
        return directores.get(name);
    }
    
    /**
     * Find filmografia, devuelve las peliculas del director con el nombre pasado por parámetros.
     *
     * @param name el nombre del director
     * @return the su filmografía
     */
    public ArrayList<Pelicula> findFilmografia(String name) {
        Assert.notNull(name, "El nombre del director no puede ser nulo");
        return filmografia.get(name);
    }
    
    /**
     * Gets the plataformas.
     *
     * @return the plataformas
     */
    public Collection<Plataforma> getPlataformas(){
    	return plataformas.values();
    }
    
    /**
     * Gets the plataforma.
     *
     * @param id the id
     * @return the plataforma
     */
    public Plataforma getPlataforma(String id) {
    	return plataformas.get(id);
    }
    
    /**
     * Removes the plataforma. Borra la plataforma con el id pasado por parámetros
     *
     * @param id the id
     */
    public void removePlataforma(String id) {
    	plataformas.remove(id);
    }
    
    /**
     * Put plataforma. Añade una plataforma
     *
     * @param id the id
     * @param plataforma the plataforma
     */
    public void putPlataforma(String id, Plataforma plataforma) {
    	plataformas.put(id, plataforma);
    }
    
    /**
     * Gets the peliculas. Devuelve todas las películas
     *
     * @return the peliculas
     */
    public Collection<Pelicula> getPeliculas(String id) {
    	return filmografia.get(id);
    }
    
    /**
     * Gets the pelicula. Devuelve la película con el id pasado por parámetros
     *
     * @param id the id
     * @return the pelicula
     */
    public Pelicula getPelicula(String idDir, String idPel) {
    	if (filmografia.containsKey(idDir) && filmografia.get(idDir).contains(new Pelicula(idPel))) {
    		return filmografia.get(idDir).get(filmografia.get(idDir).indexOf(new Pelicula(idPel)));
    	}
    	return null;
    }
    
    /**
     * Removes the pelicula. Borra la película con el id pasado por parámetros
     *
     * @param id the id
     */
    public void removePelicula(String idDir, String idPel) {
    	filmografia.get(idDir).remove(filmografia.get(idDir).indexOf(new Pelicula(idPel)));
    }
    
    /**
     * Put pelicula. Añade una película
     *
     * @param id the id
     * @param pelicula the pelicula
     */
    public void putPelicula(String idDir, Pelicula pelicula) {
    	filmografia.get(idDir).add(pelicula);
    }
    
    /**
     * Gets the directores. Devuelve todos los directores.
     *
     * @return the directores
     */
    public Collection<Director> getDirectores() {
    	return directores.values();
    }
    
    /**
     * Gets the director. Devuelve el director con el id pasado por parámetros
     *
     * @param id the id
     * @return the director
     */
    public Director getDirector(String id) {
    	return directores.get(id);
    }
    
    /**
     * Removes the director. Borra el director con el id pasado por parámetros
     *
     * @param id the id
     */
    public void removeDirector(String id) {
    	if (filmografia.get(id) != null) {
    		filmografia.remove(id);
    	}
    	
    	directores.remove(id);
    }
    
    /**
     * Put director. Añade un director.
     *
     * @param id the id
     * @param director the director
     */
    public void putDirector(String id, Director director) {
    	
    	directores.put(id, director);
    }
    
    /**
     * Gets the filmografia. Devuelve todas las películas de un director.
     *
     * @param id the id
     * @return the filmografia
     */
    public Collection<Pelicula> getFilmografia(String id){
    	return filmografia.get(id);
    }
    
}
