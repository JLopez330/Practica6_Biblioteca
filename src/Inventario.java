/**
 * Modela el inventario de la Biblioteca por medio de un ArrayList de
 * ElementoBiblioteca
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {
    private ArrayList<ElementoBiblioteca> inventario;

    public Inventario(){
        inventario = new ArrayList();
    }

    /**
     * Agrega un elemento al inventario
     */
    public void agregarAlInventario(ElementoBiblioteca objeto){
        inventario.add(objeto);
    }

    /**
     * Elimina un elemento del inventario en base a la ID recibida
     */
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

    /**
     * Regresa el objeto en el inventario en base a la ID recibida
     */
    public ElementoBiblioteca obtenerElementoPorId(String id) {
        for (ElementoBiblioteca elemento : inventario) {
            if (id.equals(elemento.getId())) {
                return elemento;
            }
        }
        return null; // Devolver null si no se encuentra el elemento con el ID dado
    }

    /**
     * Regresa el ArrayList del Inventario
     */
    public ArrayList<ElementoBiblioteca> obtenerTodosLosElementos() {
        return inventario;
    }
}
