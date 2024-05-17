public class ElementoBiblioteca {
    protected String titulo;
    protected int año;
    protected int id;

    public ElementoBiblioteca(String titulo, int año, int id){
        this.titulo = titulo;
        this.año = año;
        this.id = id;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void mostrarInformacion(){
        System.out.println("ID: "+id);
        System.out.println("Titulo: "+id);
        System.out.println("Año de publicación: "+año);
    }
}
