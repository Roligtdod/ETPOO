package model;

public class Proveedores extends Recurso implements Registrable{
    private final String tipo;
    private final String servicio;
    private final String ubicacion;

    public Proveedores(String id, String nombre, String telefono, String email, String tipo, String servicio, String ubicacion) {
        super(id,nombre,telefono,email);
        this.tipo = tipo;
        this.servicio = servicio;
        this.ubicacion = ubicacion;
    }


    @Override
    public String registrar() {
        return "Proveedor registrado";
    }

    @Override
    public String MostrarDatos() {
        return super.MostrarDatos()+"Tipo: "+tipo+" Servicio: "+servicio+" Ubicacion: "+ubicacion+" ";
    }
    @Override
    public String toString() {
        return "p"+";"+super.toString()+ tipo + ";" + servicio + ";" + ubicacion;
    }
}
