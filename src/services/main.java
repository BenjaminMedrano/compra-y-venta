import models.Producto;
import models.Usuario;
import services.MarketplaceService;

import java.util.List;
import java.util.Scanner;

public class main {

    public static void mostrarTitulo() {
        System.out.println("███╗   ███╗ █████╗ ██████╗ ██╗  ██╗███████╗████████╗██████╗ ██╗      █████╗  ██████╗███████╗");
        System.out.println("████╗ ████║██╔══██╗██╔══██╗██║ ██╔╝██╔════╝╚══██╔══╝██╔══██╗██║     ██╔══██╗██╔════╝██╔════╝");
        System.out.println("██╔████╔██║███████║██████╔╝█████╔╝ █████╗     ██║   ██████╔╝██║     ███████║██║     █████╗  ");
        System.out.println("██║╚██╔╝██║██╔══██║██╔══██╗██╔═██╗ ██╔══╝     ██║   ██╔═══╝ ██║     ██╔══██║██║     ██╔══╝  ");
        System.out.println("██║ ╚═╝ ██║██║  ██║██║  ██║██║  ██╗███████╗   ██║   ██║     ███████╗██║  ██║╚██████╗███████╗");
        System.out.println("╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝     ╚══════╝╚═╝  ╚═╝ ╚═════╝╚══════╝");
        System.out.println("                              \033[32m       AgroSmart \u001B[0m                            ");
    }


    public static void main(String[] args) {
        MarketplaceService service = new MarketplaceService();
        Scanner scanner = new Scanner(System.in);
        MarketplaceService marketplace = new MarketplaceService();
        Usuario usuarioActual = null;
        while (true) {
            System.out.println("\n--- AgroSmart ---");
            System.out.println("1. Registrarse");
            System.out.println("2. iniciar sesion");
            System.out.println("3. salir");

            System.out.print("  Seleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de usuario ");
                    String nombreRegistro = scanner.nextLine();
                    System.out.print("contraseña: ");
                    String contrasenaRegistro = scanner.nextLine();
                    usuarioActual = marketplace.registrarUsuario(nombreRegistro, contrasenaRegistro);
                    System.out.println("\n   ==============================");
                    System.out.println("   \033[33m Usuario registrado con exito \u001B[0m");
                    System.out.println("   ================================\n");
                    break;

                case 2:
                    System.out.print("Nombre de usuario ");
                    String nombreLong = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contrasenaLong = scanner.nextLine();
                    usuarioActual = marketplace.iniciarSesion(nombreLong, contrasenaLong);
                    if (usuarioActual != null) {
                        System.out.println("iniciaste sesion correctamente.");
                        menuUsuario(scanner, usuarioActual, marketplace);
                    } else {
                        System.out.println("usuario o contraseña incorrectas intente de nuevo");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo........................................");
                    return;
            }
        }
    }


    public static void menuUsuario(Scanner scanner, Usuario usuario, MarketplaceService marketplace) {
        while (true) {
            mostrarTitulo();
            System.out.println("\n ----- menu -----");
            System.out.println("1. productos disponibles");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. ver carrito");
            System.out.println("4. vender producto");
            System.out.println("5. Realizar compra");
            System.out.println("6 cerrar sesion");
            System.out.println("opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    List<Producto>productos =marketplace.getProductosDisponibles();
                    if(productos.isEmpty()){
                        System.out.println("\n no hay productos en este momento");
                    }else{
                        System.out.println("\n ---------productos disponibles-------------");
                        System.out.printf("%-5s %-20s %-10s\n", "N°", "Nombre", "Precio");
                        System.out.println("---------------------------------------------------------------------------------------");
                        int index=1;
                        for(Producto p:productos){
                            System.out.printf("%-5d %-20s $%-9.2f\n", index, p.getNombre(), p.getPrecio());
                                index++;
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("ingrese el producto que quiera agregar al carrito ");
                    String nombreProducto = scanner.nextLine();
                    Producto encontrado = marketplace.buscarProductoPorNombre(nombreProducto);
                    if (encontrado != null) {
                        usuario.agregarAlCarrito(encontrado);
                        System.out.println("============================");
                        System.out.println("producto agregado al carrito");
                        System.out.println("============================");
                        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           \n" +
                                "⠀          ⠈⠛⠻⠶⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀           ⠈⢻⣆⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀           ⢻⡏⠉⠉⠉⠉⢹⡏⠉⠉⠉⠉⣿⠉⠉⠉⠉⠉⣹⠇⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀           ⠈⣿⣀⣀⣀⣀⣸⣧⣀⣀⣀⣀⣿⣄⣀⣀⣀⣠⡿⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀            ⠸⣧⠀⠀⠀⢸⡇⠀⠀⠀⠀⣿⠁⠀⠀⠀⣿⠃⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀           ⢹⣧⣤⣤⣼⣧⣤⣤⣤⣤⣿⣤⣤⣤⣼⡏⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀            ⢿⠀⠀⢸⡇⠀⠀⠀⠀⣿⠀⠀⢠⡿⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           ⢸⣷⠤⠼⠷⠤⠤⠤⠤⠿⠦⠤⠾⠃⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀            ⢀⣾⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀            ⢾⣷⢶⣶⠶⠶⠶⠶⠶⠶⣶⠶⣶⡶⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀             ⠸⣧⣠⡿⠀⠀⠀⠀⠀⠀⢷⣄⣼⠇⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀              ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Carrito: ");
                    for (Producto p : usuario.getCarrito()) {
                        System.out.println(p);
                    }
                    System.out.println("=========================================");
                    System.out.println("Total: $" + usuario.calcularTotalCarrito());
                    System.out.println("==========================================");
                    break;
                case 4:
                    System.out.println("nombre del producto que vendera");
                    String nombreNuevo = scanner.nextLine();
                    System.out.print("precio: ");
                    double precioNuevo = scanner.nextDouble();
                    scanner.nextLine();
                    Producto nuevevoProducto = new Producto(nombreNuevo, precioNuevo);
                    marketplace.agregarProducto(nuevevoProducto);
                    System.out.println("Tu producto se puso a la venta exitosamente");
                    break;
                case 5:
                    double total= usuario.calcularTotalCarrito();
                    System.out.println("\n===========================");
                    System.out.println("       ¡COMPRA EXITOSA!      ");
                    System.out.println("-----------------------------");
                    System.out.printf("Total a pagar: $%.2f \n", total);
                    System.out.println("-----------------------------");
                    System.out.println("  ¡Gracias por su compra! :)");
                    System.out.println("=============================\n");
                    usuario.limpiarCarrito();
                    break;
                case 6:
                    System.out.println("sesion cerrada.");
                    return;
            }
        }
    }
}
