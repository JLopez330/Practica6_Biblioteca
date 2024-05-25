public class Dvd extends ElementoBiblioteca{
    private String director;
    private String productora;
    private String duracion;

    public Dvd(String titulo, String fecha, String id, String director, String productora, String duracion) {
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


    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Director: "+director);
        System.out.println("Productora: "+productora);
        System.out.println("Duracion: "+duracion+" minutos");
    }
}
