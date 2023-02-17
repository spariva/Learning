package registrosTarjetasRegalos.src;
public class Cliente extends Persona{
    private static int contadorClientes = 0;
    private int[] tarjetasPropias;
    private int final ID_CLIENTE;


    public Cliente(String nombre, String apellido, String DNI) {
        super(nombre, apellido, DNI);
        contadorClientes += 1;
        tarjetasPropias = new int[TarjetaRegalo.getMaxTarjetas()];
        ID_CLIENTE = contadorClientes+50;
        
    }
    public String toString(){
        String.format("Cliente ");
    }
    
}
