public class ElementoBiblioteca{
    /*
     * Declaracion de variables
     */
    protected String titulo;
    protected String anioPublicacion;
    protected String numIdentificacion;
    protected String genero;
    protected String autor;
    
    /*
     * Contructor de la clase
     */
    public ElementoBiblioteca(String titulo, String anioPublicacion, String numIdentificacion, String genero, String autor) {
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.numIdentificacion = numIdentificacion;
        this.genero = genero;
        this.autor = autor;
    }
    public ElementoBiblioteca(){
        
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

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
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
    
    public void mostrarInformacion(){
        System.out.println("Titulo: " + titulo + "\nAño de publicacion: " + anioPublicacion + "\nNumero de identifiacion: " + numIdentificacion + "\nGenero: " + genero + "\nAutor: " + autor);
    }
}
