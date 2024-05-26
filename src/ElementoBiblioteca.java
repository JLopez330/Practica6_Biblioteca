/**
 * Es la clase padre que da forma a la lógica de las clases
 * Libro, Revista y Biblioteca
 */

public class ElementoBiblioteca {
    protected String titulo;
    protected String fecha;
    protected String id;

    public ElementoBiblioteca(String titulo, String fecha, String id){
        this.titulo = titulo;
        this.fecha = fecha;
        this.id = id;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void mostrarInformacion(){
        System.out.println("Titulo: "+titulo);
        System.out.println("ID: "+id);
        System.out.println("Año de publicación: "+fecha);
    }

    public String toString() {
        return "Titulo: " + titulo + "\n" +
                "ID: " + id + "\n" +
                "Año de publicación: " + fecha + "\n";
    }
}
