import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bodega miBodega = new Bodega();
        int opcion = 0;

        // El menú se repite mientras la opción sea distinta de 5
        while (opcion != 5) {
            System.out.println("\n--- MENÚ ALMACÉN ---");
            System.out.println("1. Registrar producto");
            System.out.println("2. Vender producto");
            System.out.println("3. Ver Inventario");
            System.out.println("4. Ver Stock Crítico");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");

            opcion = input.nextInt();
            input.nextLine(); // Limpia el Enter después de leer un número

            if (opcion == 1) {
                System.out.print("Nombre del producto: ");
                String nombre = input.nextLine();
                System.out.print("Cantidad que llegó: ");
                int cantidad = input.nextInt();
                miBodega.registrar(nombre, cantidad);

            } else if (opcion == 2) {
                System.out.print("Nombre del producto a vender: ");
                String nombre = input.nextLine();
                System.out.print("Cantidad a vender: ");
                int cantidad = input.nextInt();
                miBodega.vender(nombre, cantidad);

            } else if (opcion == 3) {
                miBodega.verInventario();

            } else if (opcion == 4) {
                miBodega.verStockCritico();

            } else if (opcion == 5) {
                System.out.println("Programa finalizado.");
            } else {
                System.out.println("Opción incorrecta.");
            }
        }

        input.close();
    }
}