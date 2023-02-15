public class Estudiante{
    private String nombre;
    private String apellidos;
    private int nia;
    private static int contador;

    public Estudiante(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nia = contador + 1;
        contador++;
    }

    @Override
    public String toString() {
        return String.format("   %05d  (%s  %s)"
        ,nia, nombre, apellidos);
    }

}