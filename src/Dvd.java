public class Dvd extends ElementoBiblioteca{
    private String director;
    private String film;
    private String productora;
    private int duracion;

    public Dvd(String titulo, String fecha, String id, String director, String productora, int duracion) {
        super(titulo, fecha, id);
        this.director = director;
        this.productora = productora;
        this.duracion = duracion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Director: "+director);
        System.out.println("Productora: "+productora);
        System.out.println("Duracion: "+duracion+" minutos");
    }
}
