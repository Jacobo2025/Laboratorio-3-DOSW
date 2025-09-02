package edu.dosw.lab.testing.reto4;
import edu.dosw.lab.agilismo.reto4.Banco;
import edu.dosw.lab.agilismo.reto4.Cliente;
import edu.dosw.lab.agilismo.reto4.CuentaBancaria;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest {
    @Test
    void testValidarCuentaValida() {
        Banco banco = new Banco("01", "BANCOLOMBIA");
        Cliente cliente = new Cliente("001", "Juan Perez", "123456789");
        CuentaBancaria cuenta = new CuentaBancaria("0100001234", banco, cliente);

        assertTrue(cuenta.validarCuenta());
    }

    @Test
    void testValidarCuentaInvalida() {
        Banco banco = new Banco("01", "BANCOLOMBIA");
        Cliente cliente = new Cliente("002", "Maria Lopez", "987654321");
        CuentaBancaria cuenta = new CuentaBancaria("9900001234", banco, cliente);

        assertFalse(cuenta.validarCuenta());
    }

    @Test
    void testDepositar() {
        Banco banco = new Banco("01", "BANCOLOMBIA");
        Cliente cliente = new Cliente("003", "Carlos Ruiz", "456789123");
        CuentaBancaria cuenta = new CuentaBancaria("0100009876", banco, cliente);

        cuenta.depositar(5000);
        assertEquals(5000, cuenta.getSaldo());
    }
}
package edu.dosw.lab.testing.reto4;

import edu.dosw.lab.agilismo.reto4.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase CuentaBancaria
 */
class CuentaBancariaTest {

    private Banco banco;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        banco = new Banco("01", "BANCOLOMBIA");
        cliente = new Cliente("C001", "Juan Perez", "123456789");
    }

    @Test
    void cuentaValidaConDiezDigitosYPrefijoBanco() {
        CuentaBancaria cuenta = new CuentaBancaria("0100001234", banco, cliente);
        assertTrue(cuenta.validarCuenta());
    }

    @Test
    void cuentaInvalidaPorLongitud() {
        CuentaBancaria cuenta = new CuentaBancaria("010123", banco, cliente);
        assertFalse(cuenta.validarCuenta());
    }

    @Test
    void cuentaInvalidaPorPrefijo() {
        CuentaBancaria cuenta = new CuentaBancaria("9900001234", banco, cliente);
        assertFalse(cuenta.validarCuenta());
    }

    @Test
    void depositoValidoAumentaSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria("0100001234", banco, cliente);
        cuenta.depositar(500);
        assertEquals(500, cuenta.getSaldo());
    }

    @Test
    void depositoInvalidoLanzaExcepcion() {
        CuentaBancaria cuenta = new CuentaBancaria("0100001234", banco, cliente);
        assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(0));
        assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(-100));
    }
}
