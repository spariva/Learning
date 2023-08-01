package ejemplo7agroeco;

public abstract class Frozen extends Product{
    float temperature;

    public Frozen(String expiracyDate, String lotNumber, String packagingDate, String country, String name,
            float temperature) throws InvalidParameterExceptione {
        super(expiracyDate, lotNumber, packagingDate, country, name);
        this.temperature = temperature;
    }

    public abstract void rotting();//not sure about this one. I mean would be the same if I just delete this line?
}
