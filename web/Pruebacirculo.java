import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Pruebacirculo {

  public static void main( String[] args ) {

     circulo  circulo = new circulo( 37, 43, 2.5 );

      String salida = "La coordenada X es " + circulo.obtenerX() + 

        "\nLa coordenada Y es " + circulo.obtenerY() + 

        "\nEl radio es " + circulo.obtenerRadio();

      circulo.establecerX( 35 );

      circulo.establecerY( 20 );

      circulo.establecerRadio( 4.25 );

      salida += "\n\nLa nueva ubicación y el radio del círculo son\n" +

        circulo.toString();

      DecimalFormat dosDigitos = new DecimalFormat( "0.00" );

      salida += "\nEl diámetro es " + 

        dosDigitos.format( circulo.obtenerDiametro() );

      salida += "\nLa circunferencia es " +

        dosDigitos.format( circulo.obtenerCircunferencia() );

      salida += "\nEl área es " + dosDigitos.format( circulo.obtenerArea() );

      JOptionPane.showMessageDialog( null, salida ); 

      System.exit( 0 );

  } // fin de main

} // fin de la clase PruebaCirculo
