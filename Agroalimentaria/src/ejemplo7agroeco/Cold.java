package ejemplo7agroeco;

public class Cold extends Producto{
    private String cod_supervision;

    public Cold(String f_envasado, String pais, Temperatura temp, String cod_supervision, String nombre) {
        super(f_envasado, pais, temp, nombre);
        this.cod_supervision = cod_supervision;
    }

    public String getCod_supervision() {
        return cod_supervision;
    }

    public void setCod_supervision(String cod_supervision) {
        this.cod_supervision = cod_supervision;
    }

    @Override
    public void estropearse() {
       System.out.println(this.getNombre() + " , frío ya no está...");
       System.out.println("Su temperatura recomendada era: "+ this.getTemp());
    }

    @Override
    public String toString() {
        return super.toString() + "este producto es frío.";
    }
}
