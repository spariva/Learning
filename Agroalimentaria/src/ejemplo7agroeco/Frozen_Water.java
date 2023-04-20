package ejemplo7agroeco;

public class Frozen_Water extends Frozen{
    private int salinidadPorcentaje;

    public Frozen_Water(String f_envasado, String pais, Temperatura temp, String nombre, int salinidadPorcentaje) {
        super(f_envasado, pais, temp, nombre);
        this.salinidadPorcentaje = salinidadPorcentaje;
    }

    public int getSalinidadPorcentaje() {
        return salinidadPorcentaje;
    }

    public void setSalinidadPorcentaje(int salinidadPorcentaje) {
        this.salinidadPorcentaje = salinidadPorcentaje;
    }

    @Override
    public String toString() {
        return super.toString() + "y su agua tiene una salinidad de = " + salinidadPorcentaje + "%].";
    }

}
