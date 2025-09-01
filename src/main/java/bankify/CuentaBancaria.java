package bankify;


public class CuentaBancaria {
    private String numeroCuenta; // exactamente 10 dígitos
    private int saldo;
    private Banco banco;
    private Cliente cliente;

    public CuentaBancaria(String numeroCuenta, Banco banco, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0; // saldo inicial
        this.banco = banco;
        this.cliente = cliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public Cliente getCliente() {
        return cliente;
    }


    public boolean validarCuenta() {
        return numeroCuenta != null &&
                numeroCuenta.matches("\\d{10}") &&
                numeroCuenta.startsWith(banco.getCodigoBanco());
    }

    public void depositar(int monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }
}

