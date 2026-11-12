import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BodegaTest {

    // Prueba 1: Sumar stock a un producto que ya existe
    @Test
    public void testSumarStock() {
        Bodega bodega = new Bodega();
        bodega.registrar("Bebida 3L", 10);
        bodega.registrar("Bebida 3L", 5); // Sumamos 5 más

        // Obtenemos el primer producto de la lista (posición 0) y comprobamos que tenga 15
        Producto p = bodega.listaProductos.get(0);
        assertEquals(15, p.getStock());
    }

    // Prueba 2: Restar stock en una venta normal
    @Test
    public void testRestarStock() {
        Bodega bodega = new Bodega();
        bodega.registrar("Bebida 3L", 10);
        bodega.vender("Bebida 3L", 4); // Vendemos 4

        // Comprobamos que el stock haya bajado a 6
        Producto p = bodega.listaProductos.get(0);
        assertEquals(6, p.getStock());
    }

    // Prueba 3: Evitar stock negativo si intentan vender más de lo disponible
    @Test
    public void testEvitarStockNegativo() {
        Bodega bodega = new Bodega();
        bodega.registrar("Bebida 3L", 5);
        bodega.vender("Bebida 3L", 8); // Intentamos vender 8 teniendo solo 5

        // Como la venta se rechaza, el stock debe seguir siendo 5 (nunca -3)
        Producto p = bodega.listaProductos.get(0);
        assertEquals(5, p.getStock());
    }
}