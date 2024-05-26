import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FormularioDvd extends JFrame {
    private Container contenedor;
    private Inventario inventario;
    private ArrayList<String> idsRegistro;
    private Dvd dvd;
    private JLabel titulo,id,fecha,director,productora,duracion;
    private JTextField tituloField,idField,fechaField,directorField,productoraField,duracionField;
    private JButton guardarButton, limpiarButton;

    public FormularioDvd(Inventario inventario, ArrayList<String> ids){
        idsRegistro = ids;
        this.inventario = inventario;
        iniciarFormulario();
        setTitle("Agregar Dvd");
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
        director = new JLabel();
        director.setText("Director:");
        director.setBounds(20,110,135,23);
        directorField = new JTextField();
        directorField.setBounds(160,110,100,23);

        //Etiqueta y campo de texto para la Editorial del dvd
        productora = new JLabel();
        productora.setText("Productora");
        productora.setBounds(20,140,135,23);
        productoraField = new JTextField();
        productoraField.setBounds(160,140,100,23);

        //Etiqueta y campo de texto para el Autor del dvd
        duracion = new JLabel();
        duracion.setText("Duración en minutos");
        duracion.setBounds(20,170,135,23);
        duracionField = new JTextField();
        duracionField.setBounds(160,170,100,23);

        //Botes para guardar y para limpiar campos
        guardarButton = new JButton();
        guardarButton.setText("Agregar");
        guardarButton.setBounds(20,200,80,25);
        limpiarButton = new JButton();
        limpiarButton.setText("Limpiar");
        limpiarButton.setBounds(180,200,80,25);

        //ActionListeners de los botones
        guardarButton.addActionListener(e -> generarDvd());
        limpiarButton.addActionListener(e -> limpiarEspacios());

        //Añadir elementos al contenedor
        contenedor.add(titulo);
        contenedor.add(tituloField);
        contenedor.add(id);
        contenedor.add(idField);
        contenedor.add(fecha);
        contenedor.add(fechaField);
        contenedor.add(director);
        contenedor.add(directorField);
        contenedor.add(productora);
        contenedor.add(productoraField);
        contenedor.add(duracion);
        contenedor.add(duracionField);
        contenedor.add(guardarButton);
        contenedor.add(limpiarButton);

    }

    public void generarDvd(){
        try {
            String titulo = tituloField.getText();
            String id = idField.getText();
            String aux = id;
            String fecha = fechaField.getText();
            String director = directorField.getText();
            String productora = productoraField.getText();
            String duracion = duracionField.getText();
            try{
                Excepcion_Duplicado_De_Id expecion = verificarId(aux);
                if(expecion!=null){
                    throw expecion;
                }else{
                    idsRegistro.add(aux);
                    dvd = new Dvd(titulo, fecha, id, director, productora, duracion);
                    inventario.agregarAlInventario(dvd);
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

    public void limpiarEspacios(){
        tituloField.setText("");
        idField.setText("");
        fechaField.setText("");
        directorField.setText("");
        productoraField.setText("");
        duracionField.setText("");
    }

    public Dvd mandarDvd(){;
        return dvd;
    }

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
