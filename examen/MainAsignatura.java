import java.util.Scanner;
public class MainAsignatura{
    public static void main(String[] args) {
        Asignatura prog = new Asignatura("programación", 3);
        System.out.println(prog);
        
        prog.addEstudiante("Maki", "Spariva");
        prog.addNota(0,1,9f);
        System.out.println(prog);

        String nombreA;
        Scanner sc = new Scanner(System.in);
       System.out.println("inicio menú:");
       System.out.println("Menú : \n\t 1)Imprimir detalles \n\t 2)Añaddir estudiante\n\t3)Añadir nota\n\t4)Salir");

       int opcion = sc.nextInt();
       switch (opcion) {
        case 1:
                do{
                    System.out.println("introduzca nombre asign: ");
                    nombreA = sc.nextLine();

                }while(nombreA.isEmpty());
            break;
        
        default: System.out.println("Bye");
            break;
       }
    }
}