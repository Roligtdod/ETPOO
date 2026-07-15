package model;

public class Recurso implements Registrable {
    private String id;
    private String nombre;
    private String telefono;
    private String email;

    public Recurso(String id, String nombre, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    @Override
    public String registrar() {
        return "";
    }

    @Override
    public String MostrarDatos() {
        return "ID: " + id + " Nombre: " + nombre + " Telefono: " + telefono + " Email: " + email + " ";
    }

    public String toString() {
        return id + ";" + nombre + ";" + telefono + ";" + email+";";
    }
}
