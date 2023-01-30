package cuentaBancaria;
public class Ej_230125_CuentaBancaria{
    public static void main(String[] args) {
        CuentaBancaria cuentaNomina = new CuentaBancaria("" ,"Maki", 1500, "euros");
        cuentaNomina.setNumeroCuenta();
        CuentaBancaria cuentaDeAhorro = new CuentaBancaria("","Maki", 5000, "euros");
        cuentaDeAhorro.setNumeroCuenta();
/*Imprimiremos el estado de cuentaNomina
Imprimiremos el estado de cuentaDeAhorro */
        cuentaNomina.checkStatusAccount();
        cuentaDeAhorro.checkStatusAccount();
/*Podría tener directamente el mensaje en el método, pero de esta manera separamos métodos 
y mensajes de salida que según fuese cajero etc sería diferente la manera de hacerlo*/

//Haremos una retirada de la cuentaNomina de 500€
        boolean flag = cuentaNomina.retirarDinero(500);
        if(flag == true){
            System.out.println("Fit =)");
            cuentaNomina.checkStatusAccount();
        }else{
            System.out.println("Not enough money, sry =(");
            cuentaNomina.checkStatusAccount();
        }
//Haremos una transferencia de la cuentaNomina a la cuentaDeAhorro de 700€
        boolean flag1 = cuentaNomina.hacerTransferencia(700,cuentaDeAhorro);
        if(flag1 == true){
            System.out.println("Fit =)");
            cuentaNomina.checkStatusAccount();
            cuentaDeAhorro.checkStatusAccount();
        }else{
            System.out.println("Something went wrong, sry =(");
            cuentaNomina.checkStatusAccount();
        }
//Haremos una retirada de la cuentaNomina de 500€
        boolean flag2 = cuentaNomina.retirarDinero(500);
        if(flag2 == true){
            System.out.println("Fit =)");
            cuentaNomina.checkStatusAccount();
            cuentaDeAhorro.checkStatusAccount();
        }else{
            System.out.println("Not enough money, sry =(");
            cuentaNomina.checkStatusAccount();
        }
//Haremos un depósito en la cuentaNomina de 300€ 
        cuentaNomina.depositarDinero(300);
//Haremos una retirada de la cuentaNomina de 500€
        boolean flag3 = cuentaNomina.retirarDinero(500);
        if(flag3 == true){
            System.out.println("Fit =)");
            cuentaNomina.checkStatusAccount();
            cuentaDeAhorro.checkStatusAccount();
        }else{
            System.out.println("Not enough money, sry =(");
            cuentaNomina.checkStatusAccount();
        }
        cuentaNomina.checkStatusAccount();
        cuentaDeAhorro.checkStatusAccount();
    }
}
/*Esta clase solamente tendrá el método main. Se podrán crear otros métodos auxiliares si fuesen necesarios, aunque en principio no hace falta.
El método main hará lo siguiente:

Creará el objeto cuentaNomina, que será una instancia de la clase CuentaBancaria.
Creará el objeto cuentaDeAhorro, que será una instancia de la clase CuentaBancaria.
Ambas cuentas tendrán el mismo titular, distinto número de cuenta y distinto saldo.
cuentaNomina comenzará con un saldo de 1500€. cuentaDeAhorro comenzará con un saldo de 5000€.
*/