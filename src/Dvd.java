public class Dvd extends ElementoBiblioteca{
    private String director;
    private String film;
    private String productora;

    public Dvd(String titulo, int año, int id, String director, String film, String productora) {
        super(titulo, año, id);
        this.director = director;
        this.film = film;
        this.productora = productora;
    }
}
