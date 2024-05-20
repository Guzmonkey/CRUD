public class Revista extends ElementoBiblioteca{
    private int numEjemplares;
    private String editores;
    public Revista(String titulo, int anioPublicacion, int numIdentificacion, String genero, String autor, int numEjemplares, String editores) {
        super(titulo, anioPublicacion, numIdentificacion, genero, autor);
        this.numEjemplares = numEjemplares;
        this.editores = editores;
    }
    
    public int getNumEjemplares() {
        return numEjemplares;
    }
    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }
    public String getEditores() {
        return editores;
    }
    public void setEditores(String editores) {
        this.editores = editores;
    }

    
}
