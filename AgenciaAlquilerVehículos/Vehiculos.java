package AgenciaAlquilerVehículos;

public class Vehiculos {
    private String marca;
    private String modelo;
    private Integer posicionClienteAlquiler;

    public Vehiculos(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.posicionClienteAlquiler = null;
    }

    @Override
    public String toString() {
        return String.format("%s %s ",marca, modelo);
    }


    

    
}
