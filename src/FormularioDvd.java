import javax.swing.*;
import java.awt.*;
import java.text.Normalizer;

public class FormularioDvd extends JPanel {
    private JTextField tituloField;
    private JTextField idField;
    private JTextField fechaField;
    private JTextField directorField;
    private JTextField productoraField;
    private JTextField duracionField;
    private JButton guardarButton;

    public FormularioDvd(){
        iniciarFormulario();

    }

    public void iniciarFormulario(){
        setLayout(new GridLayout(4,3));

        add(new JLabel("Titulo: "));
        tituloField = new JTextField();
        add(tituloField);

        add(new JLabel("ID: "));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Fecha: "));
        fechaField = new JTextField();
        add(fechaField);

        add(new JLabel("Páginas: "));
        directorField = new JTextField();
        add(directorField);

        add(new JLabel("productora: "));
        productoraField = new JTextField();
        add(productoraField);

        add(new JLabel("duracion: "));
        duracionField =    new JTextField();
        add(duracionField);

        guardarButton = new JButton("Guardar");
        add(guardarButton);

        guardarButton.addActionListener(e -> generarDvd());
    }

    public Dvd generarDvd(){
        Dvd aux;
        String titulo = tituloField.getText();
        String id = idField.getText();
        String fecha = fechaField.getText();
        String director = directorField.getText();
        String productora = productoraField.getText();
        String duracion = duracionField.getText();
        aux = new Dvd(titulo,fecha,id,director,productora,duracion);
        return aux;
    }
}
