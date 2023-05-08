package ejemplo7agroeco;

public class Frozen_Air extends Frozen{
    int nytrogen;
    int oxygen;
    int carbonDyoxide;
    int steamWater;
    

    public Frozen_Air(String expiracyDate, String lotNumber, String packagingDate, String country, String name,
            float temperature, int nytrogen, int oxygen, int carbonDyoxide, int steamWater) throws InvalidParameterExceptione {
        super(expiracyDate, lotNumber, packagingDate, country, name, temperature);
        this.nytrogen = nytrogen;
        this.oxygen = oxygen;
        this.carbonDyoxide = carbonDyoxide;
        this.steamWater = steamWater;
    }


    @Override
    public String toString() {
        return super.toString() + "y su composicion de Frozen_Air: [N02=" + nytrogen + "%, 02=" + oxygen + "%, C02=" + carbonDyoxide
                + "%, H20=" + steamWater + "%].";
    }

    @Override
    public void rotting() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rotting'");
    }

    @Override
    public String toCsvLine() {
        return name + "," + expiracyDate + "," + lotNumber + "," + packagingDate + "," + country + "," + nytrogen + "," + oxygen + "," + carbonDyoxide + "," + steamWater;
    }

    

    
}
