package cuentaBancaria;
//import java.lang.reflect.Method;
import java.util.Scanner;

public class CuentaBancaria{
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private String moneda;
    private static int contador = 0; 
    Scanner sc = new Scanner(System.in);
//constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldo, String moneda){
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.moneda = moneda;
        contador += 1;
    }

//getters y setters
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
    public void checkStatusAccount(){
        System.out.println("Titular: "+ titular + " con cuenta: "+ numeroCuenta +" saldo de: "+ saldo + " " + moneda);
    }
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
            cuentaDestino.saldo += dineroTransferido; 
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
    /*public void checkTransaction(CuentaBancaria cuenta, float quantity, Method typeTransaction){
        boolean flag = cuenta.typeTransaction(quantity);

        if(flag == true){
            System.out.println("Fit =)");
            cuenta.checkStatusAccount();
        }else{
            System.out.println("Something went wrong, sry =(");
            cuenta.checkStatusAccount();
        }
    }*/
}
    
/*Crea la clase CuentaBancaria

Sus atributos ser??n todos privados.

Atributos:
- N??mero de cuenta (20 d??gitos)
- Titular
- Saldo
- Moneda

Los m??todos getter y setter se crear??n solamente cuando sean necesarios:
-si no necesitas extraer el valor de un atributo, no hace falta crear el getter
-si no necesitas asignarle valor a un atributo, no hace falta crear el setter

M??todos:
- retirarDinero(???)
- depositarDinero(???)
- hacerTransferencia(???)
- Otros m??todos que se puedan necesitar
 */