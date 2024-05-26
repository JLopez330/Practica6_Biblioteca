/**
 * Maneja la lógica de la biblioteca junto a sus respectivas ventanas
 * de la interfaz gráfica
 */

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Biblioteca extends JFrame{
    private Inventario inventario;
    private ArrayList<String> idsAlmacenadas;
    private JMenuBar barraMenu;
    private JMenu menuArchivo,menuAgregar,menuModificar;
    private JMenuItem menuLibro, menuRevista, menuDVD, menuEliminar, menuLeer, menuSobrescribir,guardar;
    private Clip musicaClip;
    private JButton botonSilencio,botonCreditos;
    private boolean isMuted = true;

    public Biblioteca(){
        inventario = new Inventario();
        idsAlmacenadas = new ArrayList<>();
        iniciarMenu();
        iniciarMusicaFondo();
        iniciarFondoImagen();
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
        menuLeer = new JMenuItem("Leer");
        menuSobrescribir = new JMenuItem("Sobrescribir");
        menuEliminar = new JMenuItem("Eliminar");

        menuArchivo.add(guardar);

        menuAgregar.add(menuLibro);
        menuAgregar.add(menuRevista);
        menuAgregar.add(menuDVD);

        menuModificar.add(menuLeer);
        menuModificar.add(menuSobrescribir);
        menuModificar.add(menuEliminar);

        barraMenu.add(menuArchivo);
        barraMenu.add(menuAgregar);
        barraMenu.add(menuModificar);
        setJMenuBar(barraMenu);

        //ActionListeners de los menús
        menuLibro.addActionListener(e -> crearLibro());
        menuRevista.addActionListener(e -> crearRevista());
        menuDVD.addActionListener(e -> crearDvd());
        menuEliminar.addActionListener(e -> eliminarElemento());
        menuLeer.addActionListener(e -> leerElementoOElementos());
        menuSobrescribir.addActionListener(e -> sobrescribirElemento());
        guardar.addActionListener(e->guardarInventario());

        botonSilencio = new JButton("Activar Música");
        botonSilencio.setBounds(650, 20, 130, 25);
        botonSilencio.addActionListener(e -> toggleMusica());
        getContentPane().add(botonSilencio);

        botonCreditos = new JButton("Créditos");
        botonCreditos.setBounds(650,500,130,25);
        botonCreditos.addActionListener(e -> creditos());
        getContentPane().add(botonCreditos);
    }

    public void creditos(){
        JOptionPane.showMessageDialog(null,"Alumnos:\nJosé Alejandro López Cuevas\n" +
                "Luis Fernando Prieto Duarte\nMatriculas:\n1169995\n" +
                "1190227\n"+"Musica: Quiet_Ocean\nAutor: PeriTune\n","Créditos",JOptionPane.INFORMATION_MESSAGE);
    }

    public void iniciarFondoImagen() {
        // Cargar imagen de fondo
        JLabel background = new JLabel(new ImageIcon("Fondo.jpg"));
        setContentPane(background);
        background.setLayout(new BorderLayout());
        background.setLayout(null); // Use null layout to allow absolute positioning
        background.add(botonSilencio);
        background.add(botonCreditos);
    }

    public void iniciarMusicaFondo() {
        try {
            File audioFile = new File("MusicaFondo.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            musicaClip = AudioSystem.getClip();
            musicaClip.open(audioStream);
            musicaClip.loop(Clip.LOOP_CONTINUOUSLY);
            musicaClip.stop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void toggleMusica() {
        if (isMuted) {
            musicaClip.start();
            musicaClip.loop(Clip.LOOP_CONTINUOUSLY);
            botonSilencio.setText("Silenciar Música");
        } else {
            musicaClip.stop();
            botonSilencio.setText("Activar Música");
        }
        isMuted = !isMuted;
    }

    //Métodos para añadir Un Libro, Una Revista y Un DVD
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

    //Método para llamar la vetana de Eliminar Elemento
    public void eliminarElemento(){
    VentanaEliminarElemento ventanaEliminar = new VentanaEliminarElemento(inventario);
    ventanaEliminar.setVisible(true);
    }

    //Método para llamar la ventana de Leer Elemento
    public void leerElementoOElementos(){
    VentanaLeerElemento ventanaLeer = new VentanaLeerElemento(inventario);
        if(ventanaLeer.pregunta()!=2) {
            ventanaLeer.setVisible(true);
        }else{
            ventanaLeer.setVisible(false);
        }
    }


    public void sobrescribirElemento(){
    VentanaModificarElemento ventanaSobrescribir = new VentanaModificarElemento(inventario);
    ventanaSobrescribir.setVisible(true);
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

}
