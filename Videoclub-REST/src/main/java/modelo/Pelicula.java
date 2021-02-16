package modelo;

public class Pelicula {

	private String id;
	private String nombre;
	private int duracion;
	private String genero;
	private Director director;
	
	
	public String getIdPelicula() {
		return id;
	}
	public void setIdPelicula(String idPelicula) {
		this.id = idPelicula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	
	

}
