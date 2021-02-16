package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VideoclubRepository {
	
	
	/** La constante que guarda todas las peliculas*/
    public static final Map<String, Pelicula> peliculas = new HashMap<>();
    
    /** La constante que guarda todos los directores */
    public static final Map<String, Director> directores = new HashMap<>();
    
    /** La constante que guarda las peliculas de cada director */
    public static final Map<String, ArrayList<Pelicula>> filmografia = new HashMap<>();
    
    /**
     * Inits the data.
     */
    @PostConstruct
    public void initData() {
    	
    	ArrayList<Pelicula> pelis = new ArrayList<>();
    	
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
        pelicula.setDirector(director);
        pelicula.setGenero("Drama");
        peliculas.put(pelicula.getIdPelicula(), pelicula);
        pelis.add(pelicula);
        
        pelicula = new Pelicula();
        pelicula.setIdPelicula("2");
        pelicula.setNombre("Django Desencadenado");
        pelicula.setDuracion(170);
        pelicula.setDirector(director);
        pelicula.setGenero("Oeste");
        peliculas.put(pelicula.getIdPelicula(), pelicula);
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
        pelicula.setDirector(director);
        pelicula.setGenero("Thriller");
        peliculas.put(pelicula.getIdPelicula(), pelicula);
        pelis.add(pelicula);
        
        pelicula = new Pelicula();
        pelicula.setIdPelicula("4");
        pelicula.setNombre("Origen");
        pelicula.setDuracion(148);
        pelicula.setDirector(director);
        pelicula.setGenero("Drama");
        peliculas.put(pelicula.getIdPelicula(), pelicula);
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
        pelicula.setDirector(director);
        pelicula.setGenero("Drama");
        peliculas.put(pelicula.getIdPelicula(), pelicula);
        pelis.add(pelicula);
        
        pelicula = new Pelicula();
        pelicula.setIdPelicula("6");
        pelicula.setNombre("Parque Jurásico");
        pelicula.setDuracion(127);
        pelicula.setDirector(director);
        pelicula.setGenero("Aventura");
        peliculas.put(pelicula.getIdPelicula(), pelicula);
        pelis.add(pelicula);
        
        filmografia.put(director.getId(), pelis);
         
    }
 
    /**
     * Find pelicula, devuelve la película con el nombre pasado por parámetros
     *
     * @param name el nombre de la película
     * @return the pelicula
     */
    public Pelicula findPelicula(String name) {
        Assert.notNull(name, "El nombre de la película no puede ser nulo");
        return peliculas.get(name);
    }
    
    /**
     * Find director, devuelve el director con el nombre pasado por parámetros
     *
     * @param name el nombre del director
     * @return the director
     */
    public Director findDirector(String name) {
        Assert.notNull(name, "El nombre del director no puede ser nulo");
        return directores.get(name);
    }
    
    /**
     * Find filmografia, devuelve las peliculas del director con el nombre pasado por parámetros
     *
     * @param name el nombre del director
     * @return the su filmografía
     */
    public ArrayList<Pelicula> findFilmografia(String name) {
        Assert.notNull(name, "El nombre del director no puede ser nulo");
        return filmografia.get(name);
    }
    
    public Collection<Pelicula> getPeliculas() {
    	return peliculas.values();
    }
    
    public Pelicula getPelicula(String id) {
    	return peliculas.get(id);
    }
    
    public void removePelicula(String id) {
    	peliculas.remove(id);
    }
    
    public void putPelicula(String id, Pelicula pelicula) {
    	peliculas.put(id, pelicula);
    }
    
    public Collection<Director> getDirectores() {
    	return directores.values();
    }
    
    public Director getDirector(String id) {
    	return directores.get(id);
    }
    
    public void removeDirector(String id) {
    	directores.remove(id);
    }
    
    public void putDirector(String id, Director director) {
    	directores.put(id, director);
    }
    
    public Collection<Pelicula> getFilmografia(String id){
    	return filmografia.get(id);
    }
    
}
