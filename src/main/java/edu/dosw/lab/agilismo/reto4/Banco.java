package edu.dosw.lab.agilismo.reto4;

/**
 * Representa un banco en Bankify.
 */
public class Banco {
    private final String codigoBanco; // Ejemplo: 01, 02
    private final String nombreBanco;

    public Banco(String codigoBanco, String nombreBanco) {
        if (codigoBanco == null || !codigoBanco.matches("\\d{2}")) {
            throw new IllegalArgumentException("Código de banco inválido");
        }
        this.codigoBanco = codigoBanco;
        this.nombreBanco = nombreBanco;
    }

    public String getCodigoBanco() { return codigoBanco; }
    public String getNombreBanco() { return nombreBanco; }
}
