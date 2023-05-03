package ejemplo7agroeco;

import java.time.LocalDate;

public abstract class Product {
    final LocalDate EXPIRACY_DATE;
    final int LOT_NUMBER;
    final static String LOT_REGEX = "^[A-Z]{2}-[0-9]{4}-[0-9]{1,4}$";
    String packagingDate;
    String country;
    String name;
    
/**
 * Both parameters are final in order to avoid any change that might cause a health threat. 
 * For example, someone changing the expiracyDate to sell expired products.
 * @param expiracyDate 
 * @param lotNumber 
 * 
 */
    public Product(String expiracyDate, int lotNumber, String packagingDate, String country, String name) {
        this.EXPIRACY_DATE = LocalDate.parse(expiracyDate);
        this.LOT_NUMBER = lotNumber;
        this.packagingDate = packagingDate;
        this.country = country;
        this.name = name;
    }

    
    public String getName() {
    return name;
}
/**
 * rotting() should change a boolean attribute, rotten, 
 * and it should be visible in the document, 
 * probably added to another list, and removed from the other lists. 
 * 
 * I will implement once I finish the exercise.
 */
    public abstract void rotting();

    
    public String toCsvLine(){
        return name + "," + EXPIRACY_DATE + "," + LOT_NUMBER + "," + packagingDate + "," + country;
    }

    @Override
    public String toString() {
        return "Product [EXPIRACY_DATE=" + EXPIRACY_DATE + ", LOT_NUMBER=" + LOT_NUMBER + ", packagingDate="
                + packagingDate + ", country=" + country + ", name=" + name + "]";
    }

    if(!LOT_NUMBER.matches(LOT_REGEX)){
        throw new InvalidParameterException("Lot number format not valid, should match: " + LOT_REGEX);
    }
    
}
