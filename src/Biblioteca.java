import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Biblioteca extends JFrame implements ActionListener {
    private Inventario inventario;
    private ArrayList<String> idsAlmacenadas;
    private JMenuBar barraMenu;
    private JMenu menuAgregar,menuModificar,menuTest;
    private JMenuItem menuLibro, menuRevista, menuDVD, menuEliminar, testContenido;

    public Biblioteca(){
        inventario = new Inventario();
        idsAlmacenadas = new ArrayList<>();
        iniciarMenu();

    }

    public void iniciarMenu(){
        setTitle("Biblioteca");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        barraMenu = new JMenuBar();

        //Creación del menu para Añadir Libros
        menuAgregar = new JMenu("Crear");
        menuLibro = new JMenuItem("Libro");
        menuRevista = new JMenuItem("Revista");
        menuDVD = new JMenuItem("DVD");

        //Creación del menu para modificar la biblioteca (Leer, Editar, Eliminar)
        menuModificar = new JMenu("Modificar");
        menuEliminar = new JMenuItem("Eliminar");

        //Esto es un menu de test, lo eliminaremos al final
        menuTest = new JMenu("Test");
        testContenido = new JMenuItem("Contenido");

        menuAgregar.add(menuLibro);
        menuAgregar.add(menuRevista);
        menuAgregar.add(menuDVD);

        menuModificar.add(menuEliminar);


        menuTest.add(testContenido);

        barraMenu.add(menuAgregar);
        barraMenu.add(menuModificar);
        barraMenu.add(menuTest);
        setJMenuBar(barraMenu);

        menuLibro.addActionListener(e -> crearLibro());
        menuRevista.addActionListener(e -> crearRevista());
        menuDVD.addActionListener(e -> crearDvd());
        menuEliminar.addActionListener(e -> eliminarElemento());
        testContenido.addActionListener(e -> testMostrarContenido());
    }

    public void crearLibro(){
    FormularioLibro ventanaLibro = new FormularioLibro(inventario,idsAlmacenadas);
    ventanaLibro.setVisible(true);
    }

    public void crearRevista(){
    FormularioRevista ventanaRevista = new FormularioRevista(inventario,idsAlmacenadas);
    ventanaRevista.setVisible(true);
    }

    public void crearDvd(){
    FormularioDvd ventanaDvd = new FormularioDvd(inventario,idsAlmacenadas);
    ventanaDvd.setVisible(true);
    }

    public void buscarElemento(){

    }

    public void editarElemento(){

    }

    public void eliminarElemento(){
    VentanaEliminarElemento ventanaEliminar = new VentanaEliminarElemento(inventario);
    ventanaEliminar.setVisible(true);
    }

    public void testMostrarContenido(){
        inventario.mostrarContenidoEnConsola();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        Biblioteca gui = new Biblioteca();
        gui.setVisible(true);
    }
}
