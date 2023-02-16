package registrosTarjetasRegalos;
public class TarjetaRegalo {
    private float dineroTarjeta;
    private final int ID_TARJETA;
    private Cliente titular;
    private Empleade empleade;
    private static int maxTarjetas = 4;

    public TarjetaRegalo(float dineroTarjeta, Cliente titular, Empleade empleade) {
        this.dineroTarjeta = dineroTarjeta;
        this.titular = titular;
        this.empleade = empleade;
        ID_TARJETA = (int)Math.random()*101;
    }
    public static int getMaxTarjetas(){
        return maxTarjetas;
    }
    public float getDineroTarjeta() {
        return dineroTarjeta;
    }
    

    public boolean 
}
