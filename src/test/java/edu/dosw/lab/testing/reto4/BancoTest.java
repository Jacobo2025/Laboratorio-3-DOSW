package edu.dosw.lab.testing.reto4;

import edu.dosw.lab.agilismo.reto4.Banco;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Banco
 */
class BancoTest {

    @Test
    void crearBancoCodigoValido() {
        Banco banco = new Banco("01", "BANCOLOMBIA");
        assertEquals("01", banco.getCodigoBanco());
        assertEquals("BANCOLOMBIA", banco.getNombreBanco());
    }

    @Test
    void crearBancoCodigoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Banco("ABC", "BancoX"));
        assertThrows(IllegalArgumentException.class, () -> new Banco(null, "BancoY"));
    }
}
