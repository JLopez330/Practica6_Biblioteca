import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {
    private ArrayList<ElementoBiblioteca> inventario;

    public Inventario(){
        inventario = new ArrayList();
    }

    public void agregarAlInventario(ElementoBiblioteca objeto){
        inventario.add(objeto);
    }

    public boolean eliminarDelInventario(String id){
        boolean seElimino = false;
        Iterator<ElementoBiblioteca> iterador = inventario.iterator();
        while(iterador.hasNext()){
            if(id.equals(iterador.next().getId())){
                iterador.remove();
                seElimino = true;
            }
        }
        return seElimino;
    }


    public void mostrarContenidoEnConsola(){
        for (ElementoBiblioteca elementos:
             inventario) {
            elementos.mostrarInformacion();
        }
    }
}
