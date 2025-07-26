import model.Usuario;
import model.Producto;
import service.PublicacionService;
import service.CompraService;

public class Main {
    public static void main(String[] args) {
        Usuario user = new Usuario("benja", "benja@mail.com");
        PublicacionService pubService = new PublicacionService();
        CompraService compraService = new CompraService();

        Producto p1 = pubService.publicarProducto(user, "Laptop usada", 2000);
        pubService.mostrarProductos();

        compraService.comprarProducto(user, p1);
    }
}
