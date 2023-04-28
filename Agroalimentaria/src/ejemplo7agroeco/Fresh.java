package ejemplo7agroeco;

public class Fresh extends Product{

    public Fresh(String expiracyDate, int lotNumber, String packagingDate, String country, String name){
        super(expiracyDate, lotNumber, packagingDate, country, name);
        
    }
    
    

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void rotting() {
        //It will only rot in case the ExpiracyDate has already past.
        
    }
}
