/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemagestioninventario;

/**
 *
 * @author bea
 */
import java.util.List;
import java.util.Scanner;

public class Menu {
    private ProductoDAO inventarioDAO = new ProductoDAO();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Sistema de Gestión de Inventario ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Mostrar Todos los Productos");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private void agregarProducto() {
        System.out.print("Nombre del Producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Categoría: ");
        String categoria = scanner.nextLine();

        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        producto producto = new producto(0, nombre, categoria, cantidad, precio, descripcion);
        inventarioDAO.agregarProducto(producto);
    }

    private void mostrarProductos() {
        List<producto> productos = inventarioDAO.obtenerTodosLosProductos();
        System.out.println("\n--- Listado de Productos ---");
        for (producto producto : productos) {
            System.out.println(producto.getId() + " | " +
                               producto.getNombre() + " | " +
                               producto.getCategoria() + " | " +
                               producto.getCantidad() + " | " +
                               producto.getPrecio() + " | " +
                               producto.getDescripcion());
        }
    }

    private void eliminarProducto() {
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = scanner.nextInt();
        inventarioDAO.eliminarProducto(id);
    }
}

