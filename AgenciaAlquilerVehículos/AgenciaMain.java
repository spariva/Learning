package AgenciaAlquilerVehículos;
import java.util.Scanner;

public class AgenciaMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreAgencia;
        do{
            System.out.println("Introduzca nombre agencia: ");
            nombreAgencia = sc.nextLine();
        }while(nombreAgencia.length()<=0);

        AgenciaAlquiler agencia1 = new AgenciaAlquiler(nombreAgencia, 2, 1);
        agencia1.addVehiculo("Seat", "Panda");
        System.out.println(agencia1);
    }
    
}
