import javax.swing.*;
import java.awt.*;
import java.text.Normalizer;

public class FormularioLibro extends JPanel {
    private JTextField tituloField;
    private JTextField idField;
    private JTextField fechaField;
    private JTextField paginasField;
    private JTextField editorialField;
    private JTextField autorField;
    private JButton guardarButton;

    public FormularioLibro(){
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
        paginasField = new JTextField();
        add(paginasField);

        add(new JLabel("Editorial: "));
        editorialField = new JTextField();
        add(editorialField);

        add(new JLabel("Autor: "));
        autorField =    new JTextField();
        add(autorField);

        guardarButton = new JButton("Guardar");
        add(guardarButton);

        guardarButton.addActionListener(e -> generarLibro());
    }

    public Libro generarLibro(){
        Libro aux;
        String titulo = tituloField.getText();
        String id = idField.getText();
        String fecha = fechaField.getText();
        String paginas = paginasField.getText();
        String editorial = editorialField.getText();
        String autor = autorField.getText();
        aux = new Libro(titulo,fecha,id,paginas,editorial,autor);
        return aux;
    }
}
