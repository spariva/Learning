import programacion.tiempo.Time;

public class MainTime {
  public static void main(String[] args) {
    Time medianoche = new Time(00, 00);
    Time mediodia = new Time(12, 00, 00, false);

    /*
     *
     * La línea que instancia el objeto de la clase Time llamado tiempoPorDefecto, 
     * no compila. Al fallar la instanciación, tampoco podemos imprimir tiempoPorDefecto.
     * Encuentra el porqué y haz el cambio necesario **en el fichero Time.java**
     * para que descomentando las líneas que instancian e imprimen tiempoPorDefecto, el 
     * programa compile.
     */

    Time tiempoPorDefecto = new Time();

    System.out.println("medianoche es " + medianoche);
    System.out.println("mediodia es " + mediodia);
    System.out.println("El valor de tiempoPorDefecto es " + tiempoPorDefecto);

    final int quince = 15;
    final int treinta = 30;
    final int noventa = 90;

    if (medianoche.addMinutes(quince)) {
      System.out.println("Después de ejecutar medianoche.addMinutes(quince), medianoche es "
          + medianoche);
    } 
    else {
      System.err.println("Error: medianoche.addMinutes(quince) ha devuelto false. medianoche"
          + " es " + medianoche);
    }

    if (medianoche.addSeconds(treinta)) {
      System.out.println("Después de ejecutar medianoche.addSeconds(treinta), medianoche es "
          + medianoche);
    } 
    else {
      System.err.println("Error: medianoche.addSeconds(treinta) ha devuelto false. medianoche"
          + " es " + medianoche);
    }

    if (medianoche.addSeconds(noventa)) {
      System.out.println("Después de ejecutar medianoche.addSeconds(noventa), medianoche es "
          + medianoche);
    } 
    else {
      System.err.println("Error: medianoche.addSeconds(noventa) ha devuelto false. medianoche"
          + " es " + medianoche);
    }

    if (mediodia.addMinutes(noventa)) {
      System.out.println("Después de ejecutar mediodia.addMinutes(noventa), mediodia es "
          + mediodia);
    }else if(mediodia.getNextDay()){
      System.out.print(" del día siguiente.");
    }
    else {
      System.err.println("Error: mediodia.addMinutes(noventa) ha devuelto false. "
          + "mediodia es " + mediodia);
    }

    if (mediodia.addHoras(quince)) {
      System.out.println("Después de ejecutar mediodia.addHoras(quince)="
          + quince + "), mediodia es " + mediodia);
      if(mediodia.getNextDay()){
        System.out.print(" del día siguiente.");
      }
    }
     else {
      System.err.println("Error: mediodia.addHoras(quince) ha devuelto false. mediodia es " 
          + mediodia);
    }
    

    

    
    /*
     *
     * Añade el código que necesites para probar todos los casos de uso de los métodos addSeconds, 
     * addMinutes y addHoras, y comprobar que los incrementos de tiempo se comportan como se 
     * espera: el valor de hora se encuentra entre 0 y 23, el valor de minuto entre 0 y 59 y el 
     * de segundo también entre 0 y 59.
     */
    if (tiempoPorDefecto.addHoras(23)) {
      System.out.println("Después de ejecutar tedef.addHoras(quince)="
          + 23 + "), tpor defecto es " + tiempoPorDefecto);
      if(tiempoPorDefecto.getNextDay()){
        System.out.print(" del día siguiente.");
      }
    }
     else {
      System.err.println("Error: tiempoPorDefecto.addHoras(23) ha devuelto false. tdef es " 
          + tiempoPorDefecto);
    }

    if (tiempoPorDefecto.addMinutes(59)) {
      System.out.println("Después de ejecutar tedef.addmins(59)="
          + 59 + "), tpor defecto es " + tiempoPorDefecto);
      if(tiempoPorDefecto.getNextDay()){
        System.out.print(" del día siguiente.");
      }
    }
     else {
      System.err.println("Error: tiempoPorDefecto.addminutes(59) ha devuelto false. tdef es " 
          + tiempoPorDefecto);
    }
     
    if (tiempoPorDefecto.addSeconds(61)) {
      System.out.println("Después de ejecutar tiempoPorDefecto.addSeconds(61)="
          + 61 + "), tiempoPorDefecto es " + tiempoPorDefecto);
      if(tiempoPorDefecto.getNextDay()){
        System.out.print(" del día siguiente.");
      }
    }
     else {
      System.err.println("Error: mediodia.addHoras(quince) ha devuelto false. mediodia es " 
          + mediodia);
    }

    System.out.println("Si todo ha salido bien debería haber salido que tiempo por defecto es las 00:00:01 del día siguiente.");


  }
}