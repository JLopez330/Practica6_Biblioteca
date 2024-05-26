import javax.swing.*;
import java.awt.*;

public class VentanaEliminarElemento extends JFrame {
    private Inventario inventario;
    private Container contenedor;
    private JLabel id;
    private JTextField idField;
    private JButton eliminar;


    public VentanaEliminarElemento(Inventario inventario){
        this.inventario = inventario;
        iniciarVentana();
        setTitle("Eliminar");
        setSize(300,160);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    public void iniciarVentana(){
        contenedor = getContentPane();
        contenedor.setLayout(null);

        //Etiqueta y campo de texto para la ID a eliminar
        id = new JLabel();
        id.setText("ID:");
        id.setBounds(20,20,135,23);
        idField=new JTextField();
        idField.setBounds(160,20,100,23);

        //Boton de eliminación
        eliminar = new JButton();
        eliminar.setText("Eliminar");
        eliminar.setBounds(100,80,80,25);

        //ActionListeners del boton
        eliminar.addActionListener(e ->eliminarElemento());

        //Añadir elementos al contenedor
        contenedor.add(id);
        contenedor.add(idField);
        contenedor.add(eliminar);

    }

    public void eliminarElemento(){
        String id=idField.getText();
        try{
            if(inventario.eliminarDelInventario(id)){
                JOptionPane.showMessageDialog(this,"Elemento Eliminado","Atencion",JOptionPane.INFORMATION_MESSAGE);

            }else{
                throw new Exception();
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error, ID no encontrada","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
