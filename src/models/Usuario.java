package models;
import java.util.ArrayList;
import java.util.List;
public class Usuario {
    private static int contadorId=1;
    private int id;
    private String nombre;
    private String contrasena;
    private List<Producto> carrito;


    public Usuario(String nombre,String contrasena) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.contrasena=contrasena;
        this.carrito=new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public String getContrasena(){
        return contrasena;
    }
    public List<Producto> getCarrito(){
        return carrito;
    }
    public void agregarAlCarrito(Producto producto){
        carrito.add(producto);
    }
    public double calcularTotalCarrito(){
        return carrito.stream().mapToDouble(Producto::getPrecio).sum();
    }
    public void limpiarCarrito(){
        carrito.clear();
    }


}
