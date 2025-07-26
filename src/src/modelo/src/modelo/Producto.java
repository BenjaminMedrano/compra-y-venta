package model;

public class Producto {
    private String nombre;
    private double precio;
    private Usuario vendedor;

    public Producto(String nombre, double precio, Usuario vendedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.vendedor = vendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Usuario getVendedor() {
        return vendedor;
    }
}
