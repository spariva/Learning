import ejemplo7agroeco.*;

import java.util.Scanner;

/**
 * @author Maki Spariva
 */

public class MainAgro { 
    static Scanner sc = new Scanner(System.in);

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

    public static void main(String[] args) {
        System.out.println("Name your company: ");
        String name = sc.nextLine();
        AgroGestion company = new AgroGestion(name);

        do{
            //getMenu();
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
        }while(sc.nextInt() != 1 && sc.nextInt() != 2);
        
        System.out.println(company);
       
/*         List<Product> productos = new ArrayList<Product>();
        List<Fresh> freshProductos = new ArrayList<Fresh>();
        Fresh manzana = new Fresh("2023", "españita", Temperatura.AMBIENTE, "Manzana");
        productos.add(manzana);
        empresa.agregarFreshProducto(manzana);

        freshProductos.add(0, manzana);
        Product legumbre = new Fresh("2023", "españita", Temperatura.AMBIENTE, "Garbanzos");
        productos.add(legumbre);
        freshProductos.add(0, (Fresh) legumbre);
        System.out.println(manzana);
        System.out.println(legumbre);
        System.out.println(freshProductos);

        Product cruason = new Cold("2023", "La France", Temperatura.FRÍA, "123", "Un croisan");
        Product cafe = new Cold("2023", "Colombia", Temperatura.FRÍA, "121", "Café Estrella");
        Product soyMilk = new Cold("2023", "USA", Temperatura.FRÍA, "122", "Monsanto Monocultivos Soy Milk");
        System.out.println(cruason);
        System.out.println(cafe);
        System.out.println(soyMilk);

   
        Product flor = new FrozenNitro("2025", "México", Temperatura.AMBIENTE, "Cempasúchil", MaterialTipo.DELICADO);
        Product maiz = new FrozenNitro("2024", "Zambia", Temperatura.CONGELADA, "Nshima", MaterialTipo.PEQUE);
        Frozen postre = new FrozenNitro("2024", "Singapur", Temperatura.FRÍA, "Chendol", MaterialTipo.MEDIANO);
        Frozen patata = new FrozenNitro("2024", "Lituania", Temperatura.CONGELADA, "Manpatinka Bulvyta Karstas", MaterialTipo.GRANDE);
        Frozen chip = new Frozen_Air("2033", "Lituania", Temperatura.CONGELADA, "Manpatinka Bulvyta Karstas", 25, 25, 30, 50);
        Frozen chipBatataCerezo = new Frozen_Air("2015", "Japón", Temperatura.CONGELADA, "Sakura Ñame", 25, 25, 30, 50);
        Frozen bebidaMorada = new Frozen_Water("2015", "Perú", Temperatura.FRÍA, "Chicha", 10);
        
    
        System.out.println(flor);
        System.out.println();

        System.out.println(maiz);
        System.out.println();

        System.out.println(postre);
        System.out.println();

        System.out.println(patata);
        System.out.println();
        
        System.out.println(chip);
        System.out.println();

        System.out.println(chipBatataCerezo);
        System.out.println();

        System.out.println(bebidaMorada);
        System.out.println();

        bebidaMorada.estropearse();
        System.out.println();

        cruason.estropearse();
        System.out.println();

        manzana.estropearse();
        System.out.println();

        flor.estropearse();
        System.out.println();

        postre.estropearse();
        System.out.println(); */
    }
}
