package edu.dosw.lab.testing.reto4;

import edu.dosw.lab.agilismo.reto4.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class GestorCuentaTest {

    private GestorCuenta gestor;
    private Banco banco;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        gestor = new GestorCuenta();
        banco = new Banco("01", "BANCOLOMBIA");
        cliente = new Cliente("C001", "Juan Perez", "123456789");
    }

    @Test
    void testCrearCuentaYDepositar() {
        Banco banco = new Banco("02", "DAVIVIENDA");
        Cliente cliente = new Cliente("011", "Pedro Sanchez", "1122334455");
        GestorCuenta gestorLocal = new GestorCuenta();

        CuentaBancaria cuenta = gestorLocal.crearCuenta(cliente, banco, "0200001234");

        assertTrue(gestorLocal.validarCuenta(cuenta));

        gestorLocal.realizarDeposito(cuenta, 10000);
        assertEquals(10000, gestorLocal.consultarSaldo(cuenta));
    }

    @Test
    void crearCuentaValida() {
        CuentaBancaria cuenta = gestor.crearCuenta(cliente, banco, "0100001234");
        assertNotNull(cuenta);
        assertEquals(0, cuenta.getSaldo());
    }

    @Test
    void crearCuentaDuplicadaLanzaExcepcion() {
        gestor.crearCuenta(cliente, banco, "0100001234");
        assertThrows(IllegalArgumentException.class,
                () -> gestor.crearCuenta(cliente, banco, "0100001234"));
    }

    @Test
    void buscarCuentaExistente() {
        gestor.crearCuenta(cliente, banco, "0100001234");
        Optional<CuentaBancaria> encontrada = gestor.buscarCuenta("0100001234");
        assertTrue(encontrada.isPresent());
    }

    @Test
    void buscarCuentaInexistente() {
        Optional<CuentaBancaria> encontrada = gestor.buscarCuenta("0199999999");
        assertTrue(encontrada.isEmpty());
    }

    @Test
    void realizarDepositoYConsultarSaldo() {
        CuentaBancaria cuenta = gestor.crearCuenta(cliente, banco, "0100001234");
        gestor.realizarDeposito(cuenta, 1000);
        assertEquals(1000, gestor.consultarSaldo(cuenta));
    }

    @Test
    void saldoTotalDeCliente() {
        gestor.crearCuenta(cliente, banco, "0100001234").depositar(500);
        gestor.crearCuenta(cliente, banco, "0100005678").depositar(700);
        int total = gestor.saldoTotalCliente(cliente);
        assertEquals(1200, total);
    }

    @Test
    void cuentasDeCliente() {
        gestor.crearCuenta(cliente, banco, "0100001234");
        gestor.crearCuenta(cliente, banco, "0100005678");
        List<CuentaBancaria> cuentas = gestor.cuentasDeCliente(cliente);
        assertEquals(2, cuentas.size());
    }

    @Test
    void testValidarCuentaConNull() {
        assertFalse(gestor.validarCuenta(null));
    }

    @Test
    void testValidarCuentaInvalida() {
        Cliente cliente = new Cliente("C002", "Maria Lopez", "987654321");
        Banco banco = new Banco("03", "BBVA");
        CuentaBancaria cuentaInvalida = new CuentaBancaria("123", banco, cliente);
        assertFalse(gestor.validarCuenta(cuentaInvalida));
    }
}
