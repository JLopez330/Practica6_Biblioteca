import java.util.ArrayList;

public class Inventario {
    private ArrayList<ElementoBiblioteca> inventario;

    public Inventario(){
        inventario = new ArrayList();
    }

    public void agregarAlInventario(ElementoBiblioteca objeto){
        inventario.add(objeto);
    }


    public void mostrarContenidoEnConsola(){
        for (ElementoBiblioteca elementos:
             inventario) {
            elementos.mostrarInformacion();
        }
    }
}
