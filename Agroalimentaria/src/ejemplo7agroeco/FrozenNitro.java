package ejemplo7agroeco;

public class FrozenNitro extends Frozen{
    private TiposCongelado metodoCongelacion;
    private int segundosExposicion;
    private MaterialTipo material;

    public enum TiposCongelado{
        DIP,
        SPRAY,
        IMMERSION,
        CONTROLLED_RATE
    }

    public enum MaterialTipo{
        DELICADO,
        PEQUE,
        MEDIANO,
        GRANDE
    }

    



    public FrozenNitro(String f_envasado, String pais, Temperatura temp, String nombre, MaterialTipo material) {
        super(f_envasado, pais, temp, nombre);
        this.material = material;
        switch (material) {
            case DELICADO:
                this.metodoCongelacion = TiposCongelado.CONTROLLED_RATE;
                this.segundosExposicion = 92000;
                break;
            case PEQUE:
                this.metodoCongelacion = TiposCongelado.DIP;
                this.segundosExposicion = 10;
                break;
            case MEDIANO:
                this.metodoCongelacion = TiposCongelado.SPRAY;
                this.segundosExposicion = 500;
                break;
            case GRANDE:
                this.metodoCongelacion = TiposCongelado.IMMERSION;
                this.segundosExposicion = 7500;
            default:
                break;
        }
    }



    public TiposCongelado getMetodoCongelacion() {
        return metodoCongelacion;
    }

    public int getSegundosExposicion() {
        return segundosExposicion;
    }

    public MaterialTipo getMaterial() {
        return material;
    }

    public void setMetodoCongelacion(TiposCongelado metodoCongelacion) {
        this.metodoCongelacion = metodoCongelacion;
    }

    public void setSegundosExposicion(int segundosExposicion) {
        this.segundosExposicion = segundosExposicion;
    }

    public void setMaterial(MaterialTipo material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() + " y en el método de Congelación que se usó fue: " + metodoCongelacion + ", y segundos de exposición: " + segundosExposicion
                + ", material: " + material + "].";
    }

    
}
