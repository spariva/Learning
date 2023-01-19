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


Crea la clase Ej_230125_CuentaBancaria
Esta clase solamente tendrá el método main. Se podrán crear otros métodos auxiliares si fuesen necesarios, aunque en principio no hace falta.
El método main hará lo siguiente:

Creará el objeto cuentaNomina, que será una instancia de la clase CuentaBancaria.
Creará el objeto cuentaDeAhorro, que será una instancia de la clase CuentaBancaria.
Ambas cuentas tendrán el mismo titular, distinto número de cuenta y distinto saldo.
cuentaNomina comenzará con un saldo de 1500€. cuentaDeAhorro comenzará con un saldo de 5000€.

Imprimiremos el estado de cuentaNomina
Imprimiremos el estado de cuentaDeAhorro
Haremos una retirada de la cuentaNomina de 500€
Haremos una transferencia de la cuentaNomina a la cuentaDeAhorro de 700€
Haremos una retirada de la cuentaNomina de 500€
Haremos un depósito en la cuentaNomina de 300€
Haremos una retirada de la cuentaNomina de 500€
Imprimiremos el estado de cuentaNomina
Imprimiremos el estado de cuentaDeAhorro */

public class CuentaBancaria{
    private int[] numeroCuenta = new int[20];
    private String titular;
    private int saldo;
    private String moneda; //me dan miedito los char, pero me atrevo con private static String moneda = "€"; ?
//constructor
    public CuentaBancaria(int[] numeroCuenta,String titular,int saldo,String moneda){
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.moneda = moneda;
    }

//methods (realmente son setters, no?)
    public void retirarDinero(int dineroRetirado) { //podría ser tipo int y return directamente el saldo?
        saldo = saldo - dineroRetirado;       
    }
    public void depositarDinero(int dineroDepositado) {
        saldo += dineroDepositado;
        System.out.println("Nuevo balance: "+ saldo + moneda);
    }
    public int hacerTransferencia(int dineroTransferido) { 
        saldo = saldo - dineroTransferido; 
        return saldo; //puede returnear y tomar valores?
    }


}