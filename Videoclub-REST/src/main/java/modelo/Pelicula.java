package modelo;

// TODO: Auto-generated Javadoc
/**
 * The Class Pelicula.
 */
public class Pelicula {

	/** The id. */
	private String id;
	
	/** The nombre. */
	private String nombre;
	
	/** The duracion. */
	private int duracion;
	
	/** The genero. */
	private String genero;
	
	/** The director. */
	private Director director;
	
	/** The plataforma. */
	private Plataforma plataforma;
	
	/**
	 * Gets the plataforma.
	 *
	 * @return the plataforma
	 */
	public Plataforma getPlataforma() {
		return plataforma;
	}

	/**
	 * Sets the plataforma.
	 *
	 * @param plataforma the new plataforma
	 */
	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	/**
	 * Gets the id pelicula.
	 *
	 * @return the id pelicula
	 */
	public String getIdPelicula() {
		return id;
	}
	
	/**
	 * Sets the id pelicula.
	 *
	 * @param idPelicula the new id pelicula
	 */
	public void setIdPelicula(String idPelicula) {
		this.id = idPelicula;
	}
	
	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Gets the duracion.
	 *
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}
	
	/**
	 * Sets the duracion.
	 *
	 * @param duracion the new duracion
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	/**
	 * Gets the genero.
	 *
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}
	
	/**
	 * Sets the genero.
	 *
	 * @param genero the new genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	/**
	 * Gets the director.
	 *
	 * @return the director
	 */
	public Director getDirector() {
		return director;
	}
	
	/**
	 * Sets the director.
	 *
	 * @param director the new director
	 */
	public void setDirector(Director director) {
		this.director = director;
	}
	
	

}
