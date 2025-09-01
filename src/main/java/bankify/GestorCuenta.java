package bankify;


public class GestorCuenta {

    public CuentaBancaria crearCuenta(Cliente cliente, Banco banco, String numeroCuenta) {
        return new CuentaBancaria(numeroCuenta, banco, cliente);
    }

    public boolean validarCuenta(CuentaBancaria cuenta) {
        return cuenta.validarCuenta();
    }

    public int consultarSaldo(CuentaBancaria cuenta) {
        return cuenta.getSaldo();
    }

    public void realizarDeposito(CuentaBancaria cuenta, int monto) {
        cuenta.depositar(monto);
    }
}

