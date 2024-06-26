/**
 * Modela la Lógica de una Revista
 */
public class Revista extends ElementoBiblioteca{
    private String paginas;
    private String editorial;
    private String autor;
    private String volumen;

    public Revista(String titulo, String fecha, String id, String paginas, String editorial, String autor, String volumen) {
        super(titulo, fecha, id);
        this.paginas = paginas;
        this.editorial = editorial;
        this.autor = autor;
        this.volumen = volumen;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getVolumen() {
        return volumen;
    }

    public void mostrarInformacion(){
        System.out.println("Datos de una Revista: ");
        super.mostrarInformacion();
        System.out.println("Paginas: "+paginas);
        System.out.println("Editorial: "+editorial);
        System.out.println("Autor: "+autor);
        System.out.println("Volumen: "+volumen);
    }

    public String toString() {
        return "Datos de una Revista: \n" + super.toString() +
                "Paginas: " + paginas + "\n" +
                "Editorial: " + editorial + "\n" +
                "Autor: " + autor + "\n" +
                "Volumen: " + volumen;
    }
}
