package codeWars;
import java.util.GregorianCalendar;

public class Calendar {
    public static void main(String[] args) {
        GregorianCalendar fecha1 = new GregorianCalendar();
        GregorianCalendar fecha2 = new GregorianCalendar(1997,3,10);
        System.out.println("Año: "+fecha1.get(Calendar.year));
System.out.println("Mes: "+fecha1.get(Calendar.MONTH));
System.out.println("Dia: "+fecha1.get(Calendar.DATE));
    }
}
