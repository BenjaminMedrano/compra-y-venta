package service;

import model.Producto;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class PublicacionService {
    private List<Producto> productos = new ArrayList<>();

    public Producto publicarProducto(Usuario usuario, String nombre, double precio) {
        Producto nuevo = new Producto(nombre, precio, usuario);
        productos.add(nuevo);
        System.out.println("Producto publicado: " + nombre);
        return nuevo;
    }

    public void mostrarProductos() {
        System.out.println("Productos disponibles:");
        for (Producto p : productos) {
            System.out.println("- " + p.getNombre() + " ($" + p.getPrecio() + ")");
        }
    }
}
