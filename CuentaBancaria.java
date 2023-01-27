import java.util.Scanner;

public class CuentaBancaria{
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private String moneda;
    private static int contador; 
    Scanner sc = new Scanner(System.in);
//constructor
    public CuentaBancaria(String numeroCuenta, String titular, int saldo, String moneda){
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0;
        this.moneda = moneda;
        contador = +1;
    }

//
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombre() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNombre(String titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

//methods 
/*  ! Se separa lo que se enseña al cliente, y la lógica interna de los programas. 
   public void retirarDinero(double dineroRetirado) {
        if(this.saldo<dineroRetirado){
            System.out.println("No tiene tanto dinero, sry");
        }else{
            this.saldo = this.saldo - dineroRetirado;
        }
            
    } 
*/
/*   try { 
        
    } catch (Exception e) {
        // TODO: handle exception
    } 
*/
    public boolean retirarDinero(double dineroRetirado) {
        if(dineroRetirado > saldo){
            return false;
        } else {
            saldo -= dineroRetirado;
            return true;
        }
    }
    public void depositarDinero(double dineroDepositado) {
        saldo += dineroDepositado;
        System.out.println("Nuevo balance: "+ saldo + moneda);
    }
    public boolean hacerTransferencia(double dineroTransferido, CuentaBancaria cuentaDestino) { 
        if(dineroTransferido > saldo){
            return false;
        } else {
            saldo -= dineroTransferido;
            cuentaDestino.saldo += dineroTransferido; //puedo, o tengo que usar su set que es público?
            return true;
        }
  
    }
    public void setTitular(){
        titular = sc.nextLine();
    }
    public String setNumeroCuenta(){
        numeroCuenta = String.format("%020d", contador);
        return numeroCuenta;

    }
    /*protected String setNumeroCuenta(){
        for (int i = 0; i < numeroCuenta.length(); i++) {
            numeroCuenta = new StringBuilder(numeroCuenta).append(String.valueOf(i)).toString();
        }

    }
*/
}
    /*
    public int[] generarNumeroCuenta(){
        for (int i; i < numeroCuenta.length; i++){
                        
        }
    }


}
/*Crea la clase CuentaBancaria

Sus atributos serán todos privados.

Atributos:
- Número de cuenta (20 dígitos)
- Titular
- Saldo
- Moneda

Los métodos getter y setter se crearán solamente cuando sean necesarios:
-si no necesitas extraer el valor de un atributo, no hace falta crear el getter
-si no necesitas asignarle valor a un atributo, no hace falta crear el setter

Métodos:
- retirarDinero(???)
- depositarDinero(???)
- hacerTransferencia(???)
- Otros métodos que se puedan necesitar
 */