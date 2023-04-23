package ejemplo7agroeco;

import java.util.ArrayList;
import java.util.List;

public class AgroGestion {
    String name;
    List<Product> products;
    List<Fresh> freshProducts;
    List<Cold> coldProducts;
    List<Frozen> frozenProducts;


    public AgroGestion(String name) {
        this.name = name;
        this.products = new ArrayList<>();
        this.freshProducts = new ArrayList<>();
        this.coldProducts = new ArrayList<>();
        this.frozenProducts = new ArrayList<>();
    }


    public void addProduct(Product p) {
        products.add(p);
    }
    public void addFreshProduct(Fresh p) {
        products.add(p);
        freshProducts.add(p);
    }
    public void addColdProduct(Cold p) {
        products.add(p);
        coldProducts.add(p);
    }
    public void addFrozenProduct(Frozen p) {
        products.add(p);
        frozenProducts.add(p);
    }
    

    @Override
    public String toString() {
        String string = "AgroGestión [Has a total number of: " + products.size() + " products. /n";
        if(!freshProducts.isEmpty()){
            string += "The fresh ones are: ";
            for(Product product : freshProducts) {
                string += product.getName();
            }
        }
        if(!coldProducts.isEmpty()){
            string += "The cold ones are: ";
            for(Product product : coldProducts) {
                string += product.getName();
            }
        }
        if(!frozenProducts.isEmpty()){
            string += "The frozen ones are: ";
            for(Product product : frozenProducts) {
                string += product.getName();
            }
        }
        return string;
    }

    
    
}
