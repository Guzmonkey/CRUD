public class ElementoBiblioteca{
    /*
     * Declaracion de variables
     */
    protected String titulo;
    protected int anioPublicacion;
    protected int numIdentificacion;
    protected String genero;
    protected String autor;
    
    /*
     * Contructor de la clase
     */
    public ElementoBiblioteca(String titulo, int anioPublicacion, int numIdentificacion, String genero, String autor) {
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.numIdentificacion = numIdentificacion;
        this.genero = genero;
        this.autor = autor;
    }
    /*
     * Getters y setters
     */
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(int numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    
}