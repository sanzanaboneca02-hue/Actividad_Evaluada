public class Producto {

    // Atributos del producto
    private String nombre;
    private int stock;

    // Constructor para crear un producto con nombre y stock inicial
    public Producto(String nombre, int stock) {
        this.nombre = nombre;
        this.stock = stock;
    }

    // Métodos para obtener los datos (Getters)
    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    // Suma unidades al stock actual
    public void sumarStock(int cantidad) {
        this.stock = this.stock + cantidad;
    }

    // Resta unidades solo si la cantidad no supera el stock disponible (evita stock negativo)
    public void restarStock(int cantidad) {
        if (cantidad <= this.stock) {
            this.stock = this.stock - cantidad;
        }
    }
}