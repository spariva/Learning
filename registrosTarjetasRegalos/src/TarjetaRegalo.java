package registrosTarjetasRegalos.src;
public class TarjetaRegalo {
    private float dineroTarjeta;
    private final int ID_TARJETA;
    private Cliente titular;
    private Empleade empleade;
    private static int maxTarjetas = 4;

    public TarjetaRegalo(float dineroTarjeta, Cliente titular, Empleade empleade, String nom) {
        this.dineroTarjeta = dineroTarjeta;
        this.titular = new Cliente();
        this.empleade = new Empleade();
        ID_TARJETA = (int)Math.random()*101;
    }
    public static int getMaxTarjetas(){
        return maxTarjetas;
    }
    public float getDineroTarjeta() {
        return dineroTarjeta;
    }
    

    public void setDineroTarjeta(float dineroTarjeta) {
        this.dineroTarjeta = dineroTarjeta;
    }
    
    public boolean fusionarTarjetas(TarjetaRegalo tarjeta1, TarjetaRegalo tarjeta2, Empleade newEmpleade){
        if(tarjeta1.titular == tarjeta2.titular){
            TarjetaRegalo tarjeta3 = new TarjetaRegalo((tarjeta1.dineroTarjeta + tarjeta2.dineroTarjeta),
             tarjeta1.titular, newEmpleade);
             tarjeta1.setDineroTarjeta(0f);
             tarjeta2.setDineroTarjeta(0f);

             System.out.println("Tarjeta 1 saldo: " + tarjeta1.getDineroTarjeta());
             System.out.println("Tarjeta 1 saldo: " + tarjeta2.getDineroTarjeta());
             System.out.println(tarjeta3);
            return true;
        }else{
            return false;
        }    
    }

    public String toString() {
        return String.format("La tarjeta con ID %d  y titular %s , tiene un saldo de %3.2f y fue expedida por %s .",
        ID_TARJETA, titular, dineroTarjeta, empleade);
    }
}
