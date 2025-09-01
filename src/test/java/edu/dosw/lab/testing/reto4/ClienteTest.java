package edu.dosw.lab.testing.reto4;

import edu.dosw.lab.agilismo.reto4.Cliente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Cliente
 */
class ClienteTest {

    @Test
    void crearClienteValido() {
        Cliente cliente = new Cliente("C001", "Juan Perez", "123456789");
        assertEquals("C001", cliente.getIdCliente());
        assertEquals("Juan Perez", cliente.getNombre());
        assertEquals("123456789", cliente.getDocumento());
    }

    @Test
    void crearClienteInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente(null, "Ana", "111"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("C002", null, "222"));
        assertThrows(IllegalArgumentException.class, () -> new Cliente("C003", "Luis", null));
    }
}
