public class DVD extends ElementoBiblioteca{
    private float duracion; 
    private String idioma;

    public DVD(String titulo, int anioPublicacion, int numIdentificacion, String genero, String autor, float duracion, String idioma) {
        super(titulo, anioPublicacion, numIdentificacion, genero, autor);
        this.duracion = duracion;
        this.idioma = idioma;
    }
    
    public float getDuracion() {
        return duracion;
    }
    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }
    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    } 

    
}
