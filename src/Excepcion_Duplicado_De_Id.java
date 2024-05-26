/**
 * Excepción que aparece cuando existe una ID duplicada al intentar
 * añadir un nuevo elemento a la biblioteca
 */
public class Excepcion_Duplicado_De_Id extends Exception{
    public Excepcion_Duplicado_De_Id(String mensaje){
        super(mensaje);
    }
}
