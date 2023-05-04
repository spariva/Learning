package ejemplo7agroeco;

public class Frozen_Water extends Frozen{
     int SalinityPercentage;

    
    public Frozen_Water(String expiracyDate, String lotNumber, String packagingDate, String country, String name,
            float temperature, int salinidadPorcentaje) throws InvalidParameterException {
        super(expiracyDate, lotNumber, packagingDate, country, name, temperature);
        this.SalinityPercentage = salinidadPorcentaje;
    }

    public int getSalinityPercentage() {
        return SalinityPercentage;
    }

    public void setSalinityPercentage(int salinidadPorcentaje) {
        this.SalinityPercentage = salinidadPorcentaje;
    }

    @Override
    public String toString() {
        return super.toString() + "y su agua tiene una salinidad de = " + SalinityPercentage + "%].";
    }

    @Override
    public void rotting() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rotting'");
    }

    @Override
    public String toCsvLine() {
        return name + "," + EXPIRACY_DATE + "," + LOT_NUMBER + "," + packagingDate + "," + country + "," + SalinityPercentage;
    }

}
