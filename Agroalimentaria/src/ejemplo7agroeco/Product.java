package ejemplo7agroeco;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Locale;

public abstract class Product{
    LocalDate expiracyDate;
    String lotNumber;
    final static String LOT_REGEX = "^[A-Z]{2}-[0-9]{4}-[0-9]{1,4}$";
    LocalDate packagingDate;
    String country;
    String name;
    
/**
 * Both parameters are final in order to avoid any change that might cause a health threat. 
 * For example, someone changing the expiracyDate to sell expired products.
 * @param expiracyDate 
 * @param lotNumber 
 * @throws InvalidParameterExceptione
 * 
 */
    public Product(String expiracyDate, String lotNumber, String packagingDate, String country, String name) throws InvalidParameterExceptione {
        DateTimeFormatter dF = DateTimeFormatter.ofPattern("dd-M-yyyy", Locale.ENGLISH);
        this.expiracyDate = LocalDate.parse(expiracyDate, dF);
        if(!lotNumber.matches(LOT_REGEX)){
            throw new InvalidParameterExceptione("Lot number format not valid, should match: " + LOT_REGEX);
        }
        this.lotNumber = lotNumber;
        this.packagingDate = LocalDate.parse(packagingDate, dF);
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
        return name + "," + expiracyDate + "," + lotNumber + "," + packagingDate + "," + country;
    }

    @Override
    public String toString() {
        return "Product [EXPIRACY_DATE=" + expiracyDate + ", LOT_NUMBER=" + lotNumber + ", packagingDate="
                + packagingDate + ", country=" + country + ", name=" + name + "]";
    }

    public static final Comparator<Product> BY_NAME = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return p1.name.compareTo(p2.name);
        }
    };

    public static final Comparator<Product> BY_EXPIRACY_DATE = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return p1.packagingDate.compareTo(p2.expiracyDate);
        }
    };

    public static final Comparator<Product> BY_PACKAGING_DATE = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return p1.packagingDate.compareTo(p2.packagingDate);
        }
    };

}