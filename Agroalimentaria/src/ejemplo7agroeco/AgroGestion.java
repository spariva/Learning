package ejemplo7agroeco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
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

    /**
     * So I create a new object, which reference is "writer".
     * Basically a BufferedWriter with a FileWriter as a parameter (for byte transform efficiency etc).
     * 
     * I write the different AgroGestion lists' in case they are not empty. 
     * I close the writer and handle the possible IOException as well. 
     */
    public void writeCSV(){
        BufferedWriter writerProductsList = null;
        BufferedWriter writerFreshList = null;
        BufferedWriter writerColdList = null;
        BufferedWriter writerFrozenList = null;
        try {
            writerProductsList = new BufferedWriter(new FileWriter("Products.txt"));
            writerFreshList = new BufferedWriter(new FileWriter("Fresh.txt"));
            writerColdList = new BufferedWriter(new FileWriter("Cold.txt"));
            writerFrozenList = new BufferedWriter(new FileWriter("Frozen.txt"));

            if(!products.isEmpty()){
                for (Product p : products) {
                    writerProductsList.write(p.toCsvLine());
                }
                try {
                    writerProductsList.close();
                  } catch (IOException e) {
                    System.out.println("The writer didn´t close properly: "
                        + e.getMessage());
                  }
            }
            if(!freshProducts.isEmpty()){
                for (Product p : freshProducts) {//Would it be better Fresh rather than Product?
                    writerFreshList.write(p.toCsvLine());
                }
                try {
                    writerFreshList.close();
                } catch (IOException e) {
                    System.out.println("The writer didn´t close properly: "
                        + e.getMessage());
                  }
            }
            if(!coldProducts.isEmpty()){
                for (Product p : coldProducts) {
                    writerColdList.write(p.toCsvLine());
                }
                try {
                    writerColdList.close();
                } catch (IOException e) {
                    System.out.println("The writer didn´t close properly: "
                        + e.getMessage());
                  }
            }
            if(!frozenProducts.isEmpty()){
                for (Product p : frozenProducts) {
                    writerFrozenList.write(p.toCsvLine());//aquí daría error porque hay tres tipos diferentes etc
                }
                try {
                    writerFrozenList.close();
                } catch (IOException e) {
                    System.out.println("The writer didn´t close properly: "
                        + e.getMessage());
                  }
            }
        } catch (IOException ioe) {
            System.out.println("La que has liao pollito...");
            ioe.printStackTrace();
        }
        

    }

    public void readCSV(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Products.csv"));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("My name is Charles Baker, I can´t read...");
            e.printStackTrace();
        }
    }

    public String sortByName(){
        String string = "";
        List<Producto> productsByName = new ArrayList<>(products);
        Collections.sort(productsByName, Product.BY_NAME);

        for (Product product : productsByName) {
            string += product.getName(); 
        }
        return string;
    }

    public String sortByExpiracyDate(){
        String string = "";
        List<Producto> productsByExpiracyDate = new ArrayList<>(products);
        Collections.sort(productsByExpiracyDate, Product.BY_EXPIRACY_DATE);

        for (Product product : productsByExpiracyDate) {
            string += product.getName();
        }
        return string;
    }

    public String sortByCountry(){
        String cadena = null;
        List<Product> products2 = new ArrayList<>(products);
        Collections.sort(products2, Product.LALALA);
        for (Product product : products2) {
            cadena += product;
        }
        return cadena;
    }
    
}
