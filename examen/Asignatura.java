public class Asignatura {
    private String nombre;
    private Estudiante[] estudiantes;
    private float[][] notas;
    private int estudiantesMax;
    private int pesoPrimeraEval;
    private int pesoSegundaEval;
    private int pesoTerceraEval;
    private int numEstudiantes;
    private int numEvaluaciones;

    public Asignatura(String nombre, int estudiantesMax) {
        this.nombre = nombre;
        this.estudiantesMax = estudiantesMax;
        this.estudiantes = new Estudiante[estudiantesMax];
        this.notas = new float[estudiantesMax][3];
        this.pesoPrimeraEval = 20;
        this.pesoSegundaEval = 30;
        this.pesoTerceraEval = 50;
        this.numEvaluaciones = 3;
    }

    @Override
    public String toString() {
        String cadena = String.format("Asignatura '%s'.    %d estudiantes registrados (máximo %d) \n"
        ,nombre,numEstudiantes,estudiantesMax);
        cadena += " 1aEv  2aEv  3aEv    FINAL  |   NIA  (nombre y apellidos)\n";
        cadena += this.notasToString();
        cadena += "           " + this.estudiantesToString();


        return cadena;
    } 
    public String notasToString(){
        String cadena = "";
        
        for (int i = 0; i < numEstudiantes; i++) {
            for (int j = 0; j < numEvaluaciones+1; j++) {
                float intsumaMedia = 0f;
                if(j!=3){
                    cadena += String.format(" %3.2f ",notas[i][j]);
                    switch (j) {
                        case 0:
                        float n1 = notas[i][j]*(20/100);
                            break;
                        case 1:
                        float n2 = notas[i][j] * (30/100);
                            break;
                        case 2:
                        float n3 = notas[i][j] * (50/100);
                            break;
                        default:

                            break;
                    }
                }else{
                    cadena += String.format(" %3.2f ",(n1+n2+n3));
                    
                }
            }
            cadena += "";
        }
        System.out.println(cadena);
        return cadena;
    }
    /*                if((notas[i][j]).isEmpty()){   No encotnré de qué manera hacer la comprobación
                    cadena += String.format(" %3.2f ",notas[i][j]);
                }else{
                    cadena += String.format(" %3.2f ","*");
                } */


    public String estudiantesToString(){
        String cadena = "";
        for (int i = 0; i < numEstudiantes; i++) {
            cadena += estudiantes[i];
        }
        System.out.println(cadena);
        return cadena;
    }

    public boolean addEstudiante(String nombre, String apellidos){
        if(numEstudiantes<estudiantesMax){
            estudiantes[numEstudiantes] = new Estudiante(nombre, apellidos);
            numEstudiantes++;
            return true;
        }else{
            return false;
        }
        
    }

    public boolean addNota(int posicionEstudiante, int evaluacion, float nota){
        notas[posicionEstudiante][evaluacion-1] = nota;
        return false;
        
    }
    



    
}
