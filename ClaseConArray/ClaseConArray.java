import java.util.Scanner;

public class ClaseConArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("\n===> ClaseConArray\n");

    Curso daw1v = new Curso("DAW1V", 3);

    System.out.println("Pulsa ENTER para continuar...");
    sc.nextLine();

    String nombre = "Pedro";
    float nota = 5.8f;
    if(daw1v.addAlumno(nombre, nota)){
      System.out.println(daw1v);
    } else {
      System.out.println("ERROR: No se ha podido añadir el alumno " + nombre + " con nota " + nota 
                         + " al curso DAW1V");
    }

    System.out.println("Pulsa ENTER para continuar...");
    sc.nextLine();
    nombre = "María";
    nota = 7.9f;
    if(daw1v.addAlumno(nombre, nota)){
      System.out.println(daw1v);
    } else {
      System.out.println("ERROR: No se ha podido añadir el alumno " + nombre + " con nota " + nota 
                         + " al curso DAW1V");
    }
    
    System.out.println("Pulsa ENTER para continuar...");
    sc.nextLine();
    nombre = "Juan";
    nota = 8.2f;
    if(daw1v.addAlumno(nombre, nota)){
      System.out.println(daw1v);
    } else {
      System.out.println("ERROR: No se ha podido añadir el alumno " + nombre + " con nota " + nota 
                         + " al curso DAW1V");
    }
    
    System.out.println("Pulsa ENTER para continuar...");
    sc.nextLine();
    nombre = "Pepe";
    nota = 6.5f;
    if(daw1v.addAlumno(nombre, nota)){
      System.out.println(daw1v);
    } else {
      System.out.println("ERROR: No se ha podido añadir el alumno " + nombre + " con nota " + nota 
                         + " al curso DAW1V");
    }
    sc.close();
    System.out.println("\n===> Bye, bye\n");
  }
}
