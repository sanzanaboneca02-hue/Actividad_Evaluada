import java.util.ArrayList;

public class Bodega {

    // Lista para guardar los productos de la bodega
    ArrayList<Producto> listaProductos = new ArrayList<>();

    // CASO 1: Registrar producto nuevo o sumar stock si ya existe
    public void registrar(String nombre, int cantidad) {
        // Buscamos si el producto ya está en la lista
        for (Producto p : listaProductos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.sumarStock(cantidad); // Si existe, solo sumamos el stock
                System.out.println("Producto ya existía. Se sumó el stock. Total ahora: " + p.getStock());
                return; // Termina el método aquí
            }
        }

        // Si no existía en la lista, creamos uno nuevo y lo agregamos
        Producto nuevo = new Producto(nombre, cantidad);
        listaProductos.add(nuevo);
        System.out.println("Producto nuevo registrado con éxito.");
    }

    // CASO 2: Vender producto (sin permitir vender más de lo que hay)
    public void vender(String nombre, int cantidad) {
        for (Producto p : listaProductos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                // Validamos que haya stock suficiente antes de vender
                if (cantidad <= p.getStock()) {
                    p.restarStock(cantidad);
                    System.out.println("Venta realizada. Quedan: " + p.getStock() + " unidades.");
                } else {
                    System.out.println("Error: No hay stock suficiente. Solo quedan " + p.getStock() + " unidades.");
                }
                return; // Termina el método aquí
            }
        }
        System.out.println("El producto no existe en la bodega.");
    }

    // CASO 3: Ver todo el inventario
    public void verInventario() {
        System.out.println("\n--- INVENTARIO COMPLETO ---");
        for (Producto p : listaProductos) {
            System.out.println("Nombre: " + p.getNombre() + " | Stock: " + p.getStock());
        }
    }

    // CASO 4: Ver productos con stock crítico (5 unidades o menos)
    public void verStockCritico() {
        System.out.println("\n--- STOCK CRÍTICO (5 o menos) ---");
        for (Producto p : listaProductos) {
            if (p.getStock() <= 5) {
                System.out.println("Reponer urgente -> " + p.getNombre() + " | Quedan: " + p.getStock());
            }
        }
    }
}