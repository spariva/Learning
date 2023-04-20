package ejemplo7agroeco;

public class Frozen_Air extends Frozen{
    private int nytrogen;
    private int oxygen;
    private int carbonDyoxide;
    private int steamWater;
    
    public Frozen_Air(String f_envasado, String pais, Temperatura temp, String nombre, int nytrogen, int oxygen,
            int carbonDyoxide, int steamWater) {
        super(f_envasado, pais, temp, nombre);
        this.nytrogen = nytrogen;
        this.oxygen = oxygen;
        this.carbonDyoxide = carbonDyoxide;
        this.steamWater = steamWater;
    }

    public int getNytrogen() {
        return nytrogen;
    }

    public int getOxygen() {
        return oxygen;
    }

    public int getCarbonDyoxide() {
        return carbonDyoxide;
    }

    public int getSteamWater() {
        return steamWater;
    }

    public void setNytrogen(int nytrogen) {
        this.nytrogen = nytrogen;
    }

    public void setOxygen(int oxygen) {
        this.oxygen = oxygen;
    }

    public void setCarbonDyoxide(int carbonDyoxide) {
        this.carbonDyoxide = carbonDyoxide;
    }

    public void setSteamWater(int steamWater) {
        this.steamWater = steamWater;
    }

    @Override
    public String toString() {
        return super.toString() + "y su composicion de Frozen_Air: [N02=" + nytrogen + "%, 02=" + oxygen + "%, C02=" + carbonDyoxide
                + "%, H20=" + steamWater + "%].";
    }

    

    
}
