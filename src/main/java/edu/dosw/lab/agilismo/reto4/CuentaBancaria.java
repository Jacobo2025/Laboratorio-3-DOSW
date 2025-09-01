package edu.dosw.lab.agilismo.reto4;

/**
 * Representa una cuenta bancaria en Bankify.
 */
public class CuentaBancaria {
    private final String numeroCuenta; // exactamente 10 dígitos
    private int saldo;
    private final Banco banco;
    private final Cliente cliente;

    public CuentaBancaria(String numeroCuenta, Banco banco, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
        this.banco = banco;
        this.cliente = cliente;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public int getSaldo() { return saldo; }
    public Banco getBanco() { return banco; }
    public Cliente getCliente() { return cliente; }

    /**
     * Valida que la cuenta cumpla con las reglas de negocio:
     * - exactamente 10 dígitos
     * - empieza con código del banco
     */
    public boolean validarCuenta() {
        return numeroCuenta != null &&
                numeroCuenta.matches("\\d{10}") &&
                numeroCuenta.startsWith(banco.getCodigoBanco());
    }

    /**
     * Deposita dinero si el monto es positivo.
     */
    public void depositar(int monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El depósito debe ser positivo");
        }
        saldo += monto;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", banco=" + banco.getNombreBanco() +
                ", cliente=" + cliente.getNombre() +
                '}';
    }
}
