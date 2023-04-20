package ejemplo7agroeco;

public class Frozen extends Producto{

    public Frozen(String f_envasado, String pais, Temperatura temp, String nombre) {
        super(f_envasado, pais, temp, nombre);
    }
    
    @Override
    public void estropearse() {
        System.out.println(this.getNombre() + " , se ha derretido...");
        System.out.println("Su temperatura recomendada era: " + Temperatura.CONGELADA + " pero la del producto era " + this.getTemp());

    }

    @Override
    public String toString() {
        return super.toString() + " Este producto es congelado ";
    }
}
