package model;

public class OperadorTransporte extends Recurso implements Registrable{
    private final String tipoLicencia;
    private final String fechaVencimientoLicencia;
    private final int sueldo;

    public OperadorTransporte(String id, String nombre, String telefono, String email, String tipoLicencia, String fechaVencimientoLicencia, int sueldo) {
        super(id,nombre,telefono,email);
        this.tipoLicencia = tipoLicencia;
        this.fechaVencimientoLicencia = fechaVencimientoLicencia;
        this.sueldo = sueldo;
    }

    @Override
    public String registrar() {
        return "Transportista registrado";
    }
    @Override
    public String MostrarDatos() {
        return super.MostrarDatos()+"Tipo Licencia: "+tipoLicencia+" Fecha Vencimiento de licencia: "+fechaVencimientoLicencia+" Sueldo: "+sueldo;
    }
    @Override
    public String toString() {
        return "t"+";"+super.toString()+ tipoLicencia + ";" + fechaVencimientoLicencia + ";" + sueldo;
    }


}
