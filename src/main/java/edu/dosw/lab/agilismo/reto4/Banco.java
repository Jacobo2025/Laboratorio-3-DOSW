package bankify;

public class Banco {
    private String codigoBanco;
    private String nombreBanco;

    public Banco(String codigoBanco, String nombreBanco) {
        this.codigoBanco = codigoBanco;
        this.nombreBanco = nombreBanco;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }
}