package ejemplo7agroeco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
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

    /**
     * So I create a new object, which reference is "writer".
     * Basically a BufferedWriter with a FileWriter as a parameter (for byte transform efficiency etc).
     * 
     * I write the different AgroGestion lists' in case they are not empty. 
     * I close the writer and handle the possible IOException as well. 
     */
    public void writeCSV(){
        try {
            BufferedWriter writerProductsList = new BufferedWriter(new FileWriter("Products.txt"));
            BufferedWriter writerFreshList = new BufferedWriter(new FileWriter("Fresh.txt"));
            BufferedWriter writerColdList = new BufferedWriter(new FileWriter("Cold.txt"));
            BufferedWriter writerFrozenList = new BufferedWriter(new FileWriter("Frozen.txt"));

            if(!products.isEmpty()){
                for (Product p : products) {
                    writerProductsList.write(p.toCsvLine());
                }
                writerProductsList.close();
            }
            if(!freshProducts.isEmpty()){
                for (Product p : freshProducts) {//Would it be better Fresh rather than Product?
                    writerFreshList.write(p.toCsvLine());
                }
                writerFreshList.close();
            }
            if(!coldProducts.isEmpty()){
                for (Product p : coldProducts) {
                    writerColdList.write(p.toCsvLine());
                }
                writerColdList.close();
            }
            if(!frozenProducts.isEmpty()){
                for (Product p : frozenProducts) {
                    writerFrozenList.write(p.toCsvLine());//aquí daría error porque hay tres tipos diferentes etc
                }
                writerFrozenList.close();
            }
        } catch (IOException ioe) {
            System.out.println("La que has liao pollito...");
            ioe.printStackTrace();
        }
        

    }

    public void readCSV(){
        try {
            BufferedReader reader = new BufferedReader(FileReader("Products.txt"));
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


    /*private Reader FileReader(String string) {
        return null;
    }*/
    
}
