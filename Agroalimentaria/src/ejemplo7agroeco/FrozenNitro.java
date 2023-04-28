package ejemplo7agroeco;

public class FrozenNitro extends Frozen{
    FreezingMethodsEnum FREEZING_METHOD;
    int exposureInSeconds;
    MaterialTypesEnum MATERIAL;

    public enum FreezingMethodsEnum{
        DIP,
        SPRAY,
        IMMERSION,
        CONTROLLED_RATE
    }

    public enum MaterialTypesEnum{
        DELICATE,
        SMALL,
        MEDIUM,
        BIG
    }

    public FrozenNitro(String expiracyDate, int lotNumber, String packagingDate, String country, String name,
            float temperature, FreezingMethodsEnum metodoCongelacion, int segundosExposicion, MaterialTypesEnum material) {
        super(expiracyDate, lotNumber, packagingDate, country, name, temperature);
        this.FREEZING_METHOD = metodoCongelacion;
        this.exposureInSeconds = segundosExposicion;
        this.MATERIAL = material;
        switch (material) {
            case DELICATE:
                this.FREEZING_METHOD = FreezingMethodsEnum.CONTROLLED_RATE;
                this.exposureInSeconds = 92000;
            case SMALL:
                this.FREEZING_METHOD = FreezingMethodsEnum.DIP;
                this.exposureInSeconds = 10;
            case MEDIUM:
                this.FREEZING_METHOD = FreezingMethodsEnum.SPRAY;
                this.exposureInSeconds = 500;
            case BIG:
                this.FREEZING_METHOD = FreezingMethodsEnum.IMMERSION;
                this.exposureInSeconds = 7500;
            default:
        }
    }


    @Override
    public String toString() {
        return super.toString() + " the method used was: " + FREEZING_METHOD + ", with an exposure of: " + exposureInSeconds
                + " seconds, this is due a: " + name + " is a " + MATERIAL + " type of material.";
    }



    @Override
    public void rotting() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rotting'");
    }



    @Override
    public String toCsvLine() {
        return name + "," + EXPIRACY_DATE + "," + LOT_NUMBER + "," + packagingDate + "," + country + "," + FREEZING_METHOD + "," + exposureInSeconds + "," + MATERIAL;
    }

    
}
