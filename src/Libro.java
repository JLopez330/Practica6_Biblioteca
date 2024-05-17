public class Libro extends ElementoBiblioteca{
    private int paginas;
    private String editorial;
    private String autor;
    private int numEdicion;

    public Libro(String titulo, int año, int id, int paginas, String editorial, String autor, int numEdicion) {
        super(titulo, año, id);
        this.paginas = paginas;
        this.editorial = editorial;
        this.autor = autor;
        this.numEdicion = numEdicion;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
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

    public int getNumEdicion() {
        return numEdicion;
    }

    public void setNumEdicion(int numEdicion) {
        this.numEdicion = numEdicion;
    }


}
