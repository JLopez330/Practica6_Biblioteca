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
}
