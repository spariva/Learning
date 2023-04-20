package ejemplo7agroeco;

//import java.util.ArrayList;

public abstract class Producto {
    private final int F_CADUCIDAD;
    private final int N_LOTE;
    private String f_envasado;
    private String pais;
    private Temperatura temp;
    private String nombre;
     

    
    public Producto(int F_CADUCIDAD, int N_LOTE, String f_envasado, String pais, Temperatura temp, String nombre) {
        this.F_CADUCIDAD = F_CADUCIDAD;
        this.N_LOTE = N_LOTE;
        this.f_envasado = f_envasado;
        this.pais = pais;
        this.temp = temp;
        this.nombre = nombre;
        
    }

    public abstract void estropearse();

    public enum Temperatura{
        AMBIENTE,
        FRÍA,
        CONGELADA
    }

    public int getF_CADUCIDAD() {
        return F_CADUCIDAD;
    }

    public int getN_LOTE() {
        return N_LOTE;
    }

    public String getF_envasado() {
        return f_envasado;
    }

    public String getPais() {
        return pais;
    }

    public Temperatura getTemp() {
        return temp;
    }

    public void setF_envasado(String f_envasado) {
        this.f_envasado = f_envasado;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setTemp(Temperatura temp) {
        this.temp = temp;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + ": [Caducidad= " + F_CADUCIDAD + ", Número lote= " + N_LOTE + ", fecha de envasado= " + f_envasado + ", País= "
                + pais + ", Temperatura= " + temp + " ].";
    }
}
