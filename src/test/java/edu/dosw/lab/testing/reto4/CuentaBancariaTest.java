package edu.dosw.lab.testing.reto4;

import edu.dosw.lab.agilismo.reto4.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest {

    private Banco banco;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        banco = new Banco("01", "BANCOLOMBIA");
        cliente = new Cliente("C001", "Juan Perez", "123456789");
    }

    @Test
    void testValidarCuentaValida() {
        CuentaBancaria cuenta = new CuentaBancaria("0100001234", banco, cliente);
        assertTrue(cuenta.validarCuenta());
    }

    @Test
    void testValidarCuentaInvalida() {
        CuentaBancaria cuenta = new CuentaBancaria("9900001234", banco, cliente);
        assertFalse(cuenta.validarCuenta());
    }

    @Test
    void testDepositar() {
        CuentaBancaria cuenta = new CuentaBancaria("0100009876", banco, cliente);
        cuenta.depositar(5000);
        assertEquals(5000, cuenta.getSaldo());
    }

    @Test
    void cuentaInvalidaPorLongitud() {
        CuentaBancaria cuenta = new CuentaBancaria("010123", banco, cliente);
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
