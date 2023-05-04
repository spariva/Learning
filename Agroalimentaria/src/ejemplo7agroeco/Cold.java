package ejemplo7agroeco;


public class Cold extends Product{
    String supervisionCode;
    float temperature;

    
    public Cold(String expiracyDate, String lotNumber, String packagingDate, String country, String name,
            String supervisionCode, float temperature) throws InvalidParameterExceptione {
        super(expiracyDate, lotNumber, packagingDate, country, name);
        this.supervisionCode = supervisionCode;
        this.temperature = temperature;
    }


    @Override
    public String toString() {
        return "Cold [supervisionCode=" + supervisionCode + ", temperature=" + temperature + "] + this is a Cold product. ";
    }


    @Override
    public void rotting() {
        //It will rot in case the ExpiracyDate has already past or if the temperature descends.
        System.out.println("It´s rotten");
    }


    @Override
    public String toCsvLine() {
        return name + "," + EXPIRACY_DATE + "," + LOT_NUMBER + "," + packagingDate + "," + country + "," + supervisionCode + "," + temperature;
    }

    
    




}
