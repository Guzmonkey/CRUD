public class DVD extends ElementoBiblioteca{
    private String duracion; 
    private String idioma;
    public DVD(String titulo, String anioPublicacion, String numIdentificacion, String genero, String autor, String duracion, String idioma) {
        super(titulo, anioPublicacion, numIdentificacion, genero, autor);
        this.duracion = duracion;
        this.idioma = idioma;
    }

    public String getDuracion() {
        return duracion;
    }
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    @Override
    public void mostrarInformacion(){
        System.out.println("Duracion: " + duracion + "\nIdioma: " + idioma);
    }
    
}
