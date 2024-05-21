import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<ElementoBiblioteca> elementos;
    public Biblioteca(){
        elementos = new ArrayList<>();
    }

    public void menuPrincipalConsola(){
        int opcion = -1;

        do{
            System.out.println("========Biblioteca=======");
            System.out.println("[1] Registrar Articulo");
            System.out.println("[2] Buscar Articulo");
            System.out.println("[3] Modificar Articulo");
            System.out.println("[4] Eliminar Articulo");
            System.out.println("[5] Salir");
            System.out.println("=========================");
        }while(opcion<5);
    }

    public void crearElemento(){

    }

    public void buscarElemento(int id){

    }

    public void modificarElemento(int id){

    }

    public void eliminarElemento(int id){

    }


}
