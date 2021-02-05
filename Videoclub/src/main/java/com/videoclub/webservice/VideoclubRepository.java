package com.videoclub.webservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.videoclub.xml.estante.Director;
import com.videoclub.xml.estante.Pelicula;


@Component
public class VideoclubRepository {
    private static final Map<String, Pelicula> peliculas = new HashMap<>();
    private static final Map<String, Director> directores = new HashMap<>();
    private static final Map<String, ArrayList<Pelicula>> filmografia = new HashMap<>();
    
    @PostConstruct
    public void initData() {
    	
    	ArrayList<Pelicula> pelis = new ArrayList<>();
    	
    	Director director = new Director();
    	director.setNombre("Quentin Tarantino");
    	director.setEdad(57);
    	director.setNacionalidad("estadounidense");
    	
    	directores.put(director.getNombre(), director);
         
        Pelicula pelicula = new Pelicula();
        pelicula.setNombre("Malditos Bastardos");
        pelicula.setDuracion(153);
        pelicula.setDirector(director);
        pelicula.setGenero("Drama");
        peliculas.put(pelicula.getNombre(), pelicula);
        pelis.add(pelicula);
        
        pelicula = new Pelicula();
        pelicula.setNombre("Django Desencadenado");
        pelicula.setDuracion(170);
        pelicula.setDirector(director);
        pelicula.setGenero("Oeste");
        peliculas.put(pelicula.getNombre(), pelicula);
        pelis.add(pelicula);
        
        filmografia.put(director.getNombre(), pelis);
        
        pelis = new ArrayList<>();
        director = new Director();
    	director.setNombre("Christopher Nolan");
    	director.setEdad(50);
    	director.setNacionalidad("británico");
    	directores.put(director.getNombre(), director);
         
        pelicula = new Pelicula();
        pelicula.setNombre("Tenet");
        pelicula.setDuracion(150);
        pelicula.setDirector(director);
        pelicula.setGenero("Thriller");
        peliculas.put(pelicula.getNombre(), pelicula);
        pelis.add(pelicula);
        
        pelicula = new Pelicula();
        pelicula.setNombre("Origen");
        pelicula.setDuracion(148);
        pelicula.setDirector(director);
        pelicula.setGenero("Drama");
        peliculas.put(pelicula.getNombre(), pelicula);
        pelis.add(pelicula);
        
        filmografia.put(director.getNombre(), pelis);
        
        pelis = new ArrayList<>();
        director = new Director();
    	director.setNombre("Steven Spielberg");
    	director.setEdad(74);
    	director.setNacionalidad("estadounidense");
    	directores.put(director.getNombre(), director);
         
        pelicula = new Pelicula();
        pelicula.setNombre("La lista de Schindler");
        pelicula.setDuracion(195);
        pelicula.setDirector(director);
        pelicula.setGenero("Drama");
        peliculas.put(pelicula.getNombre(), pelicula);
        pelis.add(pelicula);
        
        pelicula = new Pelicula();
        pelicula.setNombre("Parque Jurásico");
        pelicula.setDuracion(127);
        pelicula.setDirector(director);
        pelicula.setGenero("Aventura");
        peliculas.put(pelicula.getNombre(), pelicula);
        pelis.add(pelicula);
        
        filmografia.put(director.getNombre(), pelis);
         
    }
 
    public Pelicula findPelicula(String name) {
        Assert.notNull(name, "El nombre de la película no puede ser nulo");
        return peliculas.get(name);
    }
    
    public Director findDirector(String name) {
        Assert.notNull(name, "El nombre del director no puede ser nulo");
        return directores.get(name);
    }
    public ArrayList<Pelicula> findFilmografia(String name) {
        Assert.notNull(name, "El nombre del director no puede ser nulo");
        return filmografia.get(name);
    }

}
