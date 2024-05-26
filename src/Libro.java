/**
 * Modela la lógica de un Libro
 */
public class Libro extends ElementoBiblioteca{
    private String paginas;
    private String editorial;
    private String autor;

    public Libro(String titulo, String fecha, String id, String paginas, String editorial, String autor) {
        super(titulo, fecha, id);
        this.paginas = paginas;
        this.editorial = editorial;
        this.autor = autor;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void mostrarInformacion(){
        System.out.println("Datos de un libro: ");
        super.mostrarInformacion();
        System.out.println("Paginas: "+paginas);
        System.out.println("Editorial: "+editorial);
        System.out.println("Autor: "+autor);
    }

    public String toString() {
        return "Datos de un libro: \n" + super.toString() +
                "Paginas: " + paginas + "\n" +
                "Editorial: " + editorial + "\n" +
                "Autor: " + autor;
    }
}
