public class Libro extends ElementoBiblioteca {
    /*
     * Declaracion de variables
     */
    private String numPaginas;
    private String numCapitulos;
    /*
     * Constructor de la clase
     */
    public Libro(String titulo, String anioPublicacion, String numIdentificacion, String genero, String autor, String numPaginas, String numCapitulos) {
        super(titulo, anioPublicacion, numIdentificacion, genero, autor);
        this.numPaginas = numPaginas;
        this.numCapitulos = numCapitulos;
    }

    /*
     * Getters y setters 
     */
    public String getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(String numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getNumCapitulos() {
        return numCapitulos;
    }

    public void setNumCapitulos(String numCapitulos) {
        this.numCapitulos = numCapitulos;
    }

    @Override
    public void mostrarInformacion(){
        System.out.println("Numero de paginas: " + numPaginas + "\nNumero de capitulos: " + numCapitulos);
    }

}
