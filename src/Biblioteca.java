import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Biblioteca extends JFrame implements ActionListener {
    private ArrayList<ElementoBiblioteca> elementos;

    private JMenuBar barraMenu;
    private JMenu menuAgregar;
    private JMenuItem menuLibro, menuRevista, menuDVD;

    public Biblioteca(){
        elementos = new ArrayList<>();
        iniciarMenu();

    }

    public void iniciarMenu(){
        setTitle("Biblioteca");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        barraMenu = new JMenuBar();

        menuAgregar = new JMenu("Crear");
        menuLibro = new JMenuItem("Libro");
        menuRevista = new JMenuItem("Revista");
        menuDVD = new JMenuItem("DVD");

        menuAgregar.add(menuLibro);
        menuAgregar.add(menuRevista);
        menuAgregar.add(menuDVD);

        barraMenu.add(menuAgregar);
        setJMenuBar(barraMenu);

        menuLibro.addActionListener(e -> crearLibro());
        menuRevista.addActionListener(e -> crearRevista());
        menuDVD.addActionListener(e -> crearDvd());
    }

    public void crearLibro(){
    FormularioLibro libro = new FormularioLibro();
    this.getContentPane().add(libro);
    Libro auxLibro = libro.generarLibro();
    elementos.add(auxLibro);
    }

    public void crearRevista(){
        FormularioRevista revista = new FormularioRevista();
        this.getContentPane().add(revista);
        Revista auxRevista = revista.generarRevista();
        elementos.add(auxRevista);
    }

    public void crearDvd(){
        FormularioDvd dvd = new FormularioDvd();
        this.getContentPane().add(dvd);
        Dvd auxDvd = dvd.generarDvd();
        elementos.add(auxDvd);
    }

    public void crearDVD(){

    }

    public void buscarElemento(int id){

    }

    public void modificarElemento(int id){

    }

    public void eliminarElemento(int id){

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        Biblioteca gui = new Biblioteca();
        gui.setVisible(true);
    }
}
