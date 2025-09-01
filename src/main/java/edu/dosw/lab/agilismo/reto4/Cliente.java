package bankify;


public class Cliente {
    private String idCliente;
    private String nombre;
    private String documento;

    public Cliente(String idCliente, String nombre, String documento) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }
}

