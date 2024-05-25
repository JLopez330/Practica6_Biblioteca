import javax.swing.*;
import java.awt.*;

public class FormularioLibro extends JFrame {
    private Container contenedor;
    private Inventario inventario;
    private Libro libro;
    private JLabel titulo,id,fecha,paginas,editorial,autor;
    private JTextField tituloField,idField,fechaField,paginasField,editorialField,autorField;
    private JButton guardarButton, limpiarButton;

    public FormularioLibro(Inventario inventario){

        this.inventario = inventario;
        iniciarFormulario();
        setTitle("Agregar Libro");
        setSize(300,350);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    public void iniciarFormulario(){

        contenedor = getContentPane();
        contenedor.setLayout(null);

        //Etiqueta y campo de texto para el Titulo
        titulo = new JLabel();
        titulo.setText("Nombre:");
        titulo.setBounds(20,20,135,23);
        tituloField = new JTextField();
        tituloField.setBounds(160,20,100,23);

        //Etiqueta y campo de texto para el ID
        id = new JLabel();
        id.setText("ID:");
        id.setBounds(20,50,135,23);
        idField = new JTextField();
        idField.setBounds(160,50,100,23);

        //Etiqueta y campo de texto para la Fecha de publicación
        fecha = new JLabel();
        fecha.setText("Fecha:");
        fecha.setBounds(20,80,135,23);
        fechaField = new JTextField();
        fechaField.setBounds(160,80,100,23);

        //Etiqueta y campo de texto para la cantidad de Páginas
        paginas = new JLabel();
        paginas.setText("Páginas:");
        paginas.setBounds(20,110,135,23);
        paginasField = new JTextField();
        paginasField.setBounds(160,110,100,23);

        //Etiqueta y campo de texto para la Editorial del libro
        editorial = new JLabel();
        editorial.setText("Editorial:");
        editorial.setBounds(20,140,135,23);
        editorialField = new JTextField();
        editorialField.setBounds(160,140,100,23);

        //Etiqueta y campo de texto para el Autor del libro
        autor = new JLabel();
        autor.setText("Autor:");
        autor.setBounds(20,170,135,23);
        autorField = new JTextField();
        autorField.setBounds(160,170,100,23);

        //Botes para guardar y para limpiar campos
        guardarButton = new JButton();
        guardarButton.setText("Agregar");
        guardarButton.setBounds(20,200,80,25);
        limpiarButton = new JButton();
        limpiarButton.setText("Limpiar");
        limpiarButton.setBounds(180,200,80,25);

        //ActionListeners de los botones
        guardarButton.addActionListener(e -> generarLibro());
        limpiarButton.addActionListener(e -> limpiarEspacios());

        //Añadir elementos al contenedor
        contenedor.add(titulo);
        contenedor.add(tituloField);
        contenedor.add(id);
        contenedor.add(idField);
        contenedor.add(fecha);
        contenedor.add(fechaField);
        contenedor.add(paginas);
        contenedor.add(paginasField);
        contenedor.add(editorial);
        contenedor.add(editorialField);
        contenedor.add(autor);
        contenedor.add(autorField);
        contenedor.add(guardarButton);
        contenedor.add(limpiarButton);

    }

    public void generarLibro(){
        try {
            String titulo = tituloField.getText();
            String id = idField.getText();
            String fecha = fechaField.getText();
            String paginas = paginasField.getText();
            String editorial = editorialField.getText();
            String autor = autorField.getText();
            libro = new Libro(titulo, fecha, id, paginas, editorial, autor);
            inventario.agregarAlInventario(libro);
            JOptionPane.showMessageDialog(this,"Libro añadido!","Atencion!",JOptionPane.INFORMATION_MESSAGE);
            limpiarEspacios();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error en captura de datos","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpiarEspacios(){
        tituloField.setText("");
        idField.setText("");
        fechaField.setText("");
        paginasField.setText("");
        editorialField.setText("");
        autorField.setText("");
    }

    public Libro mandarLibro(){;
        return libro;
    }
}
