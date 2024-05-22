import javax.swing.*;
import java.awt.*;

public class Interfaz extends JFrame {
    public Interfaz(){
        this.setSize(1000,1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Gestión de biblioteca");
        setLocationRelativeTo(null);
    }

    public void iniciarComponentes(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GREEN);
        this.getContentPane().add(panel);

        JLabel etiqueta = new JLabel("Sistema de Gestión de Biblioteca.");
        etiqueta.setBounds(50,50,500,50);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setFont(new Font("arial",2,30));
        panel.add(etiqueta);
    }
}
