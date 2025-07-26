package util;

import model.Usuario;

public class Pagos {
    public static void realizarPago(Usuario usuario, double monto) {
        System.out.println("Procesando pago de $" + monto + " por " + usuario.getNombre());
        System.out.println("Pago realizado con éxito.");
    }
}
