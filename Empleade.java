package registrosTarjetasRegalos;
public class Empleade extends Persona{
    private String cod_emple;
    private int contadorVentas;

    public Empleade(String nombre, String apellido, String DNI, String cod_emple) {
        super(nombre, apellido, DNI);
        this.cod_emple = cod_emple;
        contadorVentas = 0;
    }

    
}
