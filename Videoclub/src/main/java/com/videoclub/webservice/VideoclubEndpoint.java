package com.videoclub.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.videoclub.xml.estante.DirectorDetailsRequest;
import com.videoclub.xml.estante.DirectorDetailsResponse;
import com.videoclub.xml.estante.FilmografiaDetailsRequest;
import com.videoclub.xml.estante.FilmografiaDetailsResponse;
import com.videoclub.xml.estante.Pelicula;
import com.videoclub.xml.estante.PeliculaDetailsRequest;
import com.videoclub.xml.estante.PeliculaDetailsResponse;


@Endpoint
public class VideoclubEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.videoclub.com/xml/estante";
	 
	private VideoclubRepository VideoclubRepository;
 
    @Autowired
    public VideoclubEndpoint(VideoclubRepository VideoclubRepository) {
        this.VideoclubRepository=VideoclubRepository;
    }
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "PeliculaDetailsRequest")
    @ResponsePayload
    public PeliculaDetailsResponse getPelicula(@RequestPayload PeliculaDetailsRequest request) {
    	PeliculaDetailsResponse response = new PeliculaDetailsResponse();
        response.setPelicula(VideoclubRepository.findPelicula(request.getName()));
 
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DirectorDetailsRequest")
    @ResponsePayload
    public DirectorDetailsResponse getDirector(@RequestPayload DirectorDetailsRequest request) {
    	DirectorDetailsResponse response = new DirectorDetailsResponse();
        response.setDirector(VideoclubRepository.findDirector(request.getName()));
 
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "FilmografiaDetailsRequest")
    @ResponsePayload
    public FilmografiaDetailsResponse getFilmografia(@RequestPayload FilmografiaDetailsRequest request) {
    	FilmografiaDetailsResponse response = new FilmografiaDetailsResponse();
    	List<Pelicula> pelis = VideoclubRepository.findFilmografia(request.getNombre());
    	for (Pelicula pelicula : pelis) {
    		response.getPeliculas().add(pelicula);
    	}
 
        return response;
    }

}
