package bankify;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Pruebas {

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

    @Test
    void testCrearCuentaYDepositar() {
        Banco banco = new Banco("02", "DAVIVIENDA");
        Cliente cliente = new Cliente("010", "Pedro Sanchez", "1122334455");
        GestorCuenta gestor = new GestorCuenta();

        CuentaBancaria cuenta = gestor.crearCuenta(cliente, banco, "0200001234");

        assertTrue(gestor.validarCuenta(cuenta));

        gestor.realizarDeposito(cuenta, 10000);
        assertEquals(10000, gestor.consultarSaldo(cuenta));
    }
}
