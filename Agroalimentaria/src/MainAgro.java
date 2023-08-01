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
            Fresh manzana = new Fresh("10-02-2023", "ZA-123-02", "01-02-2023", "Spain", "Manzana");
            company.addProduct(manzana);
            company.addFreshProduct(manzana);
        } catch (InvalidParameterExceptione iPE) {
            iPE.getMessage();
        }
        
        try {
            Cold cruason = new Cold("10-03-2023", "02", "05-10-2023", "France", "Un croisan", "324r", 24.5f);
            company.addProduct(cruason);
            company.addColdProduct(cruason);
        } catch (InvalidParameterExceptione iPE) {
            iPE.getMessage();
        }

        int option = 0; //I initialiaze it outside in order to simplify the do while loop.
        do{
            printMenu();
            option = sc.nextInt();
            sc.nextLine();//clean buffer.

        switch (option) {
            case 1:
                company.writeCSV();
            case 2:
                company.readCSV(); 
            case 3:
                System.out.println("Press 1 to sort by expiracy date.");
                System.out.println("Press 2 to sort by country.");
                System.out.println("Press 3 to sort by name.");
                int option2 = sc.nextInt();
                sc.nextLine();//clean buffer.
                switch (option2) {
                    case 1:
                        company.sortByExpiracyDate();
                        break;
                    case 2:
                        company.sortByCountry();
                        break;  
                    case 3:
                        company.sortByName();
                        break;
                    default:
                        System.out.println("Something weird happened.");
                        break;
                }
            case 4: 
                System.out.println(company);// TODO: I will override toString() in AgroGestion and their child classes.
            default: 
                System.out.println("Something weird happened.");
        }
        }while(sc.nextInt() != 5);
        
        System.out.println(company);
    }
    
    private static void printMenu(){
        System.out.println("Press 1 to write a file.");
        System.out.println("Press 2 to read the file.");
        System.out.println("Press 3 to sort the products");
        System.out.println("Press 4 to print details.");
        System.out.println("Press 5 to exit.");
    }
}
