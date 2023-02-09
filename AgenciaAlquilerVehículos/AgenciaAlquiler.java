package AgenciaAlquilerVehículos;

public class AgenciaAlquiler{
    private String nombre;
    private Vehiculos[] vehiculos;
    private Clientes[] clientes;
    private int vehiculosMax;
    private int clientesMax;
    private int numClientes;
    private int numVehiculos;


    public AgenciaAlquiler(String nombre, int vehiculosMax, int clientesMax) {
        this.nombre = nombre;
        this.vehiculos = new Vehiculos[vehiculosMax];
        this.clientes = new Clientes[clientesMax];
        this.vehiculosMax = vehiculosMax;
        this.clientesMax = clientesMax;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Vehiculos[] getVehiculos() {
        return vehiculos;
    }


    public void setVehiculos(Vehiculos[] vehiculos) {
        this.vehiculos = vehiculos;
    }


    public Clientes[] getClientes() {
        return clientes;
    }


    public void setClientes(Clientes[] clientes) {
        this.clientes = clientes;
    }


    public int getVehTamaño() {
        return vehiculosMax;
    }


    public void setVehTamaño(int vehTamaño) {
        this.vehiculosMax = vehTamaño;
    }


    public int getCliTamaño() {
        return clientesMax;
    }


    public void setCliTamaño(int cliTamaño) {
        this.clientesMax = cliTamaño;
    }

    public String clientesToString(){
        String cad="\nLista de clientes: ";
        for (int i = 0; i < numClientes; i++) {
            cad += "\n\t " + i + clientes[i];
        }
        return cad;
    }
    public String vehiculosToString(){
        String cad="\nLista de clientes: ";
        for (int i = 0; i < numVehiculos; i++) {
            cad += "\n\t " + i + vehiculos[i];
        }
        return cad;
    }

    public String toString(){
        String cadena="Agencia: ";
        cadena += nombre;
        cadena += clientesToString();
        cadena += vehiculosToString();
        return cadena;
    }

    public boolean addVehiculo(){
        if (numVehiculos<vehiculosMax){
            
            numVehiculos++;
            return true;
        }else{
            return false;
        }

    }

    

    

}