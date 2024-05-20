public class Libro extends ElementoBiblioteca {
    /*
     * Declaracion de variables
     */
    private int numPaginas;
    private int numCapitulos;
    /*
     * Constructor de la clase
     */
    public Libro(String titulo, int anioPublicacion, int numIdentificacion, String genero, String autor, int numPaginas, int numCapitulos) {
        super(titulo, anioPublicacion, numIdentificacion, genero, autor);
        this.numPaginas = numPaginas;
        this.numCapitulos = numCapitulos;
    }
    /*
     * Getters y setters 
     */
    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getNumCapitulos() {
        return numCapitulos;
    }

    public void setNumCapitulos(int numCapitulos) {
        this.numCapitulos = numCapitulos;
    } 

}
