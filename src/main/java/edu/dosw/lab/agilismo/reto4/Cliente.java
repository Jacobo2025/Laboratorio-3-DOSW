package edu.dosw.lab.agilismo.reto4;

/**
 * Representa un cliente en Bankify.
 */
public class Cliente {
    private final String idCliente;
    private final String nombre;
    private final String documento;

    public Cliente(String idCliente, String nombre, String documento) {
        if (idCliente == null || nombre == null || documento == null) {
            throw new IllegalArgumentException("Datos del cliente no pueden ser nulos");
        }
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
}
