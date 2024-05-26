/**
 * Crea la ventana para Modificar un Elemento en el Inventario
 * y su respectivo método
 */

import javax.swing.*;
import java.awt.*;

public class VentanaModificarElemento extends JFrame {
    private Inventario inventario;
    private Container contenedor;
    private JLabel id;
    private JTextField idField;
    private JButton modificar;

    public VentanaModificarElemento(Inventario inventario) {
        this.inventario = inventario;
        iniciarVentana();
        setTitle("Modificar");
        setSize(300, 160);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void iniciarVentana() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        // Etiqueta y campo de texto para la ID a modificar
        id = new JLabel();
        id.setText("ID:");
        id.setBounds(20, 20, 135, 23);
        idField = new JTextField();
        idField.setBounds(160, 20, 100, 23);

        // Boton de modificación
        modificar = new JButton();
        modificar.setText("Modificar");
        modificar.setBounds(100, 80, 100, 25);

        // ActionListeners del botón
        modificar.addActionListener(e -> modificarElemento());

        // Añadir elementos al contenedor
        contenedor.add(id);
        contenedor.add(idField);
        contenedor.add(modificar);
    }

    /**
     * Método para la modificación del elemento deseado
     * con respecto a la ID capturada
     */
    public void modificarElemento() {
        String id = idField.getText();
        try {
            ElementoBiblioteca elemento = inventario.obtenerElementoPorId(id);
            if (elemento != null) {
                abrirVentanaModificar(elemento);
            } else {
                throw new Exception("ID no encontrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error, ID no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Abre la ventana para la edición del elemento
     */
    private void abrirVentanaModificar(ElementoBiblioteca elemento) {
        JFrame ventanaModificar = new JFrame("Modificar Elemento");
        ventanaModificar.setSize(400, 400);
        ventanaModificar.setLocationRelativeTo(null);
        ventanaModificar.setResizable(false);

        Container contenedor = ventanaModificar.getContentPane();
        contenedor.setLayout(new GridLayout(0, 2));

        // Crear campos para modificar las propiedades del elemento
        JTextField tituloField = new JTextField(elemento.getTitulo());
        JTextField fechaField = new JTextField(elemento.getFecha());

        contenedor.add(new JLabel("Título:"));
        contenedor.add(tituloField);
        contenedor.add(new JLabel("Fecha:"));
        contenedor.add(fechaField);

        if(elemento instanceof Libro){
            Libro libro = (Libro) elemento;
            JTextField paginasField = new JTextField(libro.getPaginas());
            JTextField editorialField = new JTextField(libro.getEditorial());
            JTextField autorField = new JTextField(libro.getAutor());

            contenedor.add(new JLabel("Páginas:"));
            contenedor.add(paginasField);
            contenedor.add(new JLabel("Editorial:"));
            contenedor.add(editorialField);
            contenedor.add(new JLabel("Autor:"));
            contenedor.add(autorField);

            JButton guardarButton = new JButton("Guardar");
            guardarButton.addActionListener(e -> {
                libro.setTitulo(tituloField.getText());
                libro.setFecha(fechaField.getText());
                libro.setPaginas(paginasField.getText());
                libro.setEditorial(editorialField.getText());
                libro.setAutor(autorField.getText());
                ventanaModificar.dispose();
            });
            contenedor.add(guardarButton);
        }else if (elemento instanceof Revista){
            Revista revista = (Revista) elemento;
            JTextField paginasField = new JTextField(revista.getPaginas());
            JTextField editorialField = new JTextField(revista.getEditorial());
            JTextField autorField = new JTextField(revista.getAutor());
            JTextField volumenField = new JTextField(revista.getVolumen());

            contenedor.add(new JLabel("Páginas:"));
            contenedor.add(paginasField);
            contenedor.add(new JLabel("Editorial:"));
            contenedor.add(editorialField);
            contenedor.add(new JLabel("Autor:"));
            contenedor.add(autorField);
            contenedor.add(new JLabel("Volumen:"));
            contenedor.add(volumenField);

            JButton guardarButton = new JButton("Guardar");
            guardarButton.addActionListener(e -> {
                revista.setTitulo(tituloField.getText());
                revista.setFecha(fechaField.getText());
                revista.setPaginas(paginasField.getText());
                revista.setEditorial(editorialField.getText());
                revista.setAutor(autorField.getText());
                revista.setVolumen(volumenField.getText());
                ventanaModificar.dispose();
            });
            contenedor.add(guardarButton);
        }else if(elemento instanceof Dvd){
            Dvd dvd = (Dvd) elemento;
            JTextField directorField = new JTextField(dvd.getDirector());
            JTextField productoraField = new JTextField(dvd.getProductora());
            JTextField duracionField = new JTextField(dvd.getDuracion());

            contenedor.add(new JLabel("Director:"));
            contenedor.add(directorField);
            contenedor.add(new JLabel("Productora:"));
            contenedor.add(productoraField);
            contenedor.add(new JLabel("Duración:"));
            contenedor.add(duracionField);

            JButton guardarButton = new JButton("Guardar");
            guardarButton.addActionListener(e -> {
                dvd.setTitulo(tituloField.getText());
                dvd.setFecha(fechaField.getText());
                dvd.setDirector(directorField.getText());
                dvd.setProductora(productoraField.getText());
                dvd.setDuracion(duracionField.getText());
                ventanaModificar.dispose();
            });
            contenedor.add(guardarButton);
        }

        ventanaModificar.setVisible(true);
    }
}