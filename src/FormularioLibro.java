/**
 * Modela la ventana para añadir un Libro a la biblioteca y sus métodos
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FormularioLibro extends JFrame {
    private Container contenedor;
    private Inventario inventario;
    private ArrayList<String> idsRegistro;
    private Libro libro;
    private JLabel titulo,id,fecha,paginas,editorial,autor;
    private JTextField tituloField,idField,fechaField,paginasField,editorialField,autorField;
    private JButton guardarButton, limpiarButton;

    public FormularioLibro(Inventario inventario, ArrayList<String> ids){
        idsRegistro = ids;
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
        titulo.setText("Titulo:");
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

        //Botones para guardar y para limpiar campos
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
            String aux = id;
            String fecha = fechaField.getText();
            String paginas = paginasField.getText();
            String editorial = editorialField.getText();
            String autor = autorField.getText();
            try{
                Excepcion_Duplicado_De_Id expecion = verificarId(aux);
                if(expecion!=null){
                    throw expecion;
                }else{
                    idsRegistro.add(aux);
                    libro = new Libro(titulo, fecha, id, paginas, editorial, autor);
                    inventario.agregarAlInventario(libro);
                    JOptionPane.showMessageDialog(this,"Libro añadido!","Atencion",JOptionPane.INFORMATION_MESSAGE);
                    limpiarEspacios();
                }
            }catch (Excepcion_Duplicado_De_Id e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error en captura de datos","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Limpia las cajas de texto en la ventana
     */
    public void limpiarEspacios(){
        tituloField.setText("");
        idField.setText("");
        fechaField.setText("");
        paginasField.setText("");
        editorialField.setText("");
        autorField.setText("");
    }

    /**
     * Verifica si la ID se encuentra disponible y no está
     * repetida dentro del ArrayList de IDs guardadas
     */
    public Excepcion_Duplicado_De_Id verificarId(String id){
            if(!idsRegistro.isEmpty()){
                for (String identificador: idsRegistro) {
                    if(identificador.equals(id)){
                        return new Excepcion_Duplicado_De_Id("La ID ya se encuentra registrada");
                    }
                }

            }
            return null;
    }
}
