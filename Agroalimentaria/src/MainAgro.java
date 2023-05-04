import ejemplo7agroeco.*;

import java.util.Scanner;

/**
 * @author Maki Spariva
 */

public class MainAgro { 
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Name your company: ");
        String name = sc.nextLine();
        AgroGestion company = new AgroGestion(name);

        try {
            Fresh manzana = new Fresh("10-02-2023", "02", "01-02-2023", "Spain", "Manzana");
            company.addProduct(manzana);
            company.addFreshProduct(manzana);
        } catch (InvalidParameterException iPE) {
            iPE.getMessage();
        }
        
        try {
            Cold cruason = new Cold("10-03-2023", "02", "05-10-2023", "France", "Un croisan", "324r", 24.5f);
            company.addProduct(cruason);
            company.addColdProduct(cruason);
        } catch (InvalidParameterException iPE) {
            iPE.getMessage();
        }
        do{
            printMenu();
            int option = sc.nextInt();
            sc.nextLine();//clean buffer.

        switch (option) {
            case 1:
                company.writeCSV();
            case 2:
                company.readCSV(); 
            default: 
                System.out.println("Bye bye");
        }
        }while(sc.nextInt() != 1 || sc.nextInt() != 2);
        
        System.out.println(company);
    }
    private static void printMenu(){
        System.out.println("Press 1 to write a file.");
        System.out.println("Press 2 to read the file.");
        System.out.println("Press any other number to exit.");
    }
        /*private static void getMenu(){
        sc.nextLine();
        int option = sc.nextInt();
        sc.nextLine();//clean buffer.
        System.out.println("Press 1 to write a file.");
        System.out.println("Press 2 to read the file.");
        System.out.println("Press any other number to exit.");
        switch (option) {
            case 1:
                company.writeCSV();
            case 2:
                company.readCSV(); 
            default: 
                System.out.println("Bye bye");
        }
    }*/
}
