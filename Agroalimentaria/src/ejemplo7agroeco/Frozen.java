package ejemplo7agroeco;

public abstract class Frozen extends Product{
    float temperature;

    public Frozen(String expiracyDate, int lotNumber, String packagingDate, String country, String name,
            float temperature) {
        super(expiracyDate, lotNumber, packagingDate, country, name);
        this.temperature = temperature;
    }

    public abstract void rotting();//not sure about this one.
}
