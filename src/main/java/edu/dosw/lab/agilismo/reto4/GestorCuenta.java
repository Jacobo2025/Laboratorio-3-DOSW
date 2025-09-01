package edu.dosw.lab.agilismo.reto4;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Clase encargada de gestionar operaciones sobre cuentas bancarias.
 * Aplica el ciclo TDD, uso de Streams y validaciones.
 */
public class GestorCuenta {
    private final List<CuentaBancaria> cuentas = new ArrayList<>();

    /**
     * Crea una nueva cuenta bancaria validando que no exista previamente.
     * @param cliente Cliente dueño de la cuenta
     * @param banco Banco asociado
     * @param numeroCuenta Número de cuenta (10 dígitos)
     * @return La nueva cuenta creada
     * @throws IllegalArgumentException si ya existe la cuenta o no es válida
     */
    public CuentaBancaria crearCuenta(Cliente cliente, Banco banco, String numeroCuenta) {
        if (cuentas.stream().anyMatch(c -> c.getNumeroCuenta().equals(numeroCuenta))) {
            throw new IllegalArgumentException("La cuenta ya existe: " + numeroCuenta);
        }
        CuentaBancaria nueva = new CuentaBancaria(numeroCuenta, banco, cliente);
        if (!nueva.validarCuenta()) {
            throw new IllegalArgumentException("Número de cuenta inválido: " + numeroCuenta);
        }
        cuentas.add(nueva);
        return nueva;
    }

    /**
     * Valida que una cuenta cumpla con las reglas de negocio.
     */
    public boolean validarCuenta(CuentaBancaria cuenta) {
        return cuenta != null && cuenta.validarCuenta();
    }

    /**
     * Consulta el saldo de una cuenta.
     */
    public int consultarSaldo(CuentaBancaria cuenta) {
        return Optional.ofNullable(cuenta)
                .map(CuentaBancaria::getSaldo)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta inválida"));
    }

    /**
     * Realiza un depósito en una cuenta.
     */
    public void realizarDeposito(CuentaBancaria cuenta, int monto) {
        Optional.ofNullable(cuenta)
                .ifPresentOrElse(c -> c.depositar(monto),
                        () -> { throw new IllegalArgumentException("Cuenta inválida"); });
    }

    /**
     * Busca una cuenta por su número.
     */
    public Optional<CuentaBancaria> buscarCuenta(String numeroCuenta) {
        return cuentas.stream()
                .filter(c -> c.getNumeroCuenta().equals(numeroCuenta))
                .findFirst();
    }

    /**
     * Lista todas las cuentas de un cliente.
     */
    public List<CuentaBancaria> cuentasDeCliente(Cliente cliente) {
        return cuentas.stream()
                .filter(c -> c.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }

    /**
     * Calcula el saldo total de todas las cuentas de un cliente.
     */
    public int saldoTotalCliente(Cliente cliente) {
        return cuentas.stream()
                .filter(c -> c.getCliente().equals(cliente))
                .mapToInt(CuentaBancaria::getSaldo)
                .sum();
    }
}


