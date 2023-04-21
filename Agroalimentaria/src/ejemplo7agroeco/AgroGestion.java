package ejemplo7agroeco;

import java.util.ArrayList;
import java.util.List;

public class AgroGestion {
     final String nombre;
     List<Producto> productos = new ArrayList<>();
     List<Producto> freshProductos = new ArrayList<>();
     List<Producto> coldProductos = new ArrayList<>();
     List<Producto> frozenProductos = new ArrayList<>();


    public AgroGestion(String nombre) {
        this.nombre = nombre;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    public void setFreshProductos(List<Producto> freshProductos) {
        this.freshProductos = freshProductos;
    }
    public void setColdProductos(List<Producto> coldProductos) {
        this.coldProductos = coldProductos;
    }
    public void setFrozenProductos(List<Producto> frozenProductos) {
        this.frozenProductos = frozenProductos;
    }


    public List<Producto> agregarProducto(Producto p) {
        productos.add(p);
        return productos;
    }
    public List<Producto> agregarFreshProducto(Producto p) {
        freshProductos.add(p);
        return freshProductos;
    }
    public List<Producto> agregarColdProducto(Producto p) {
        productos.add(p);
        return coldProductos;
    }
    public List<Producto> agregarFrozenProducto(Producto p) {
        productos.add(p);
        return frozenProductos;
    }

    public List<Producto> getFreshProductos() {
        return freshProductos;
    }
    public List<Producto> getColdProductos() {
        return coldProductos;
    }
    public List<Producto> getFrozenProductos() {
        return frozenProductos;
    }
    

    @Override
    public String toString() {
        return "AgroGestión [productos=" + productos + ", freshProductos=" + freshProductos + ", coldProductos="
                + coldProductos + ", frozenProductos=" + frozenProductos + "]";
    }

    
    
}
