package ejemplo7agroeco;

public class Fresh extends Producto{

    public Fresh(String f_envasado, String pais, Temperatura temp, String nombre) {
        super(f_envasado, pais, temp, nombre);
    }
    
    @Override
    public void estropearse() {
        System.out.println(this.getNombre() + " , muy fresco pero demasiado tiempo al sol.");
        System.out.println("Su temperatura recomendada era: "+ this.getTemp() + " pero al ser fresco seguramente fuese por el envasado.");
    }

    @Override
    public String toString() {
        return super.toString() + "este producto es fresco.";
    }
    
    
}
