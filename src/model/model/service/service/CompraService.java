package service;

import model.Producto;
import model.Usuario;
import util.Pagos;

public class CompraService {
    public void comprarProducto(Usuario comprador, Producto producto) {
        System.out.println(comprador.getNombre() + " está comprando " + producto.getNombre());
        Pagos.realizarPago(comprador, producto.getPrecio());
    }
}
