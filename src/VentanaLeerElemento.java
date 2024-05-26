import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaLeerElemento extends JFrame {
    private Inventario inventario;
    private Container contenedor;
    private JLabel id;
    private JLabel texto;
    private JTextField idField;
    private JButton leer;

    public VentanaLeerElemento(Inventario inventario) {
        this.inventario = inventario;
        setTitle("Leer");
        setSize(300, 160);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public int pregunta() {
        Object[] botones = {"Leer un elemento", "Leer todos"};
        int respuesta=-1;
        respuesta = JOptionPane.showOptionDialog(null, "¿Desea leer un elemento o leer todos?", "Pregunta",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
        if (respuesta == 1) {
            leerTodosLosElementos();
        } else if (respuesta == 0) {
            iniciarVentana();
        }
        if (respuesta == JOptionPane.CLOSED_OPTION) {
            System.out.println("Diálogo cerrado por el usuario.");
            respuesta = 2;
        }
        return respuesta;
    }

    public void iniciarVentana() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        // Etiqueta y campo de texto para la ID a leer
        id = new JLabel();
        id.setText("ID:");
        id.setBounds(20, 20, 135, 23);
        idField = new JTextField();
        idField.setBounds(160, 20, 100, 23);

        // Boton para leer un elemento
        leer = new JButton();
        leer.setText("Leer");
        leer.setBounds(40, 60, 200, 25);

        // ActionListeners de los botones
        leer.addActionListener(e -> leerUnElemento());

        // Añadir elementos al contenedor
        contenedor.add(id);
        contenedor.add(idField);
        contenedor.add(leer);
    }

    public void leerUnElemento() {
        String id = idField.getText();
        try {
            // Verificar si el ID existe en el inventario
            Object elemento = inventario.obtenerElementoPorId(id);
            if (elemento != null) {
                JOptionPane.showMessageDialog(this, elemento.toString(), "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                throw new Exception("ID no encontrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error, ID no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void leerTodosLosElementos() {
        ArrayList<ElementoBiblioteca> elementos = inventario.obtenerTodosLosElementos();
        JTextArea textArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        StringBuilder builder = new StringBuilder();
        for (ElementoBiblioteca elemento : elementos) {
            builder.append(elemento.toString()).append("\n\n");
        }
        textArea.setText(builder.toString());
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(this, scrollPane, "Todos los Elementos", JOptionPane.INFORMATION_MESSAGE);
        contenedor = getContentPane();
        contenedor.setLayout(null);

        // Etiqueta y campo de texto para la ID a leer
        texto = new JLabel();
        texto.setText("Se a cerrado la lectura");
        texto.setBounds(20, 20, 135, 23);
        contenedor.add(texto);
    }
}
