import javax.swing.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Biblioteca extends JFrame implements ActionListener {
    private Inventario inventario;
    private ArrayList<String> idsAlmacenadas;
    private JMenuBar barraMenu;
    private JMenu menuArchivo,menuAgregar,menuModificar,menuTest;
    private JMenuItem menuLibro, menuRevista, menuDVD, menuEliminar, menuLeer, guardar,testContenido;

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
        setResizable(false);
        barraMenu = new JMenuBar();

        //Creación del menu de Archivo
        menuArchivo = new JMenu("Archivo");
        guardar = new JMenuItem("Guardar");

        //Creación del menu para Añadir Libros
        menuAgregar = new JMenu("Crear");
        menuLibro = new JMenuItem("Libro");
        menuRevista = new JMenuItem("Revista");
        menuDVD = new JMenuItem("DVD");

        //Creación del menu para modificar la biblioteca (Leer, Editar, Eliminar)
        menuModificar = new JMenu("Modificar");
        menuEliminar = new JMenuItem("Eliminar");
        menuLeer = new JMenuItem("Leer");

        //Esto es un menu de test, lo eliminaremos al final
        menuTest = new JMenu("Test");
        testContenido = new JMenuItem("Contenido");

        menuArchivo.add(guardar);

        menuAgregar.add(menuLibro);
        menuAgregar.add(menuRevista);
        menuAgregar.add(menuDVD);

        menuModificar.add(menuLeer);
        menuModificar.add(menuEliminar);

        menuTest.add(testContenido);

        barraMenu.add(menuArchivo);
        barraMenu.add(menuAgregar);
        barraMenu.add(menuModificar);
        barraMenu.add(menuTest);
        setJMenuBar(barraMenu);

        //ActionListeners de los menús
        menuLibro.addActionListener(e -> crearLibro());
        menuRevista.addActionListener(e -> crearRevista());
        menuDVD.addActionListener(e -> crearDvd());
        menuEliminar.addActionListener(e -> eliminarElemento());
        menuLeer.addActionListener(e -> leerElementoOElementos());
        testContenido.addActionListener(e -> testMostrarContenido());
        guardar.addActionListener(e->guardarInventario());


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

    public void leerElementoOElementos(){
    VentanaLeerElemento ventanaLeer = new VentanaLeerElemento(inventario);
        if(ventanaLeer.pregunta()!=2) {
            ventanaLeer.setVisible(true);
        }else{
            ventanaLeer.setVisible(false);
        }
    }

    public void guardarInventario(){
        //Selector de Archivos
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int confirmar = fc.showOpenDialog(this);

        if(confirmar == JFileChooser.APPROVE_OPTION){
            File directorio = fc.getSelectedFile();
            String nombre = directorio.getAbsolutePath();

            try{
                StringBuilder builder = new StringBuilder();
                for (ElementoBiblioteca elemento : inventario.obtenerTodosLosElementos()) {
                    builder.append(elemento.toString()).append("\n\n");
                }
                String contenido = builder.toString();

                File file = new File(nombre+"\\"+"Inventario.txt");

                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido);
                bw.close();

                String mensaje = "El archivo Inventario.txt fue creado con exito en: "+nombre;
                JOptionPane.showMessageDialog(this,mensaje,"Atencion",JOptionPane.INFORMATION_MESSAGE);

            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"Error en creación de archivo","Error",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }


        }
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
