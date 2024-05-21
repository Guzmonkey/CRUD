public class Revista extends ElementoBiblioteca{
    private String numEjemplares;
    private String editores;
    
    public Revista(String titulo, String anioPublicacion, String numIdentificacion, String genero, String autor, String numEjemplares, String editores) {
        super(titulo, anioPublicacion, numIdentificacion, genero, autor);
        this.numEjemplares = numEjemplares;
        this.editores = editores;
    }

    public String getNumEjemplares() {
        return numEjemplares;
    }


    public void setNumEjemplares(String numEjemplares) {
        this.numEjemplares = numEjemplares;
    }


    public String getEditores() {
        return editores;
    }


    public void setEditores(String editores) {
        this.editores = editores;
    }

     @Override
    public void mostrarInformacion(){
        System.out.println("Numero de ejemplares: " + numEjemplares + "\nEditores: " + editores);
    }

}
