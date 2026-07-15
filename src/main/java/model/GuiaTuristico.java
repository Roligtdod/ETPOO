package model;

public class GuiaTuristico extends Recurso implements Registrable{
    private final String cargo;
    private final String especialidad;
    private final int sueldo;

    public GuiaTuristico(String id,String nombre, String telefono, String mail, String cargo, String especialidad, int sueldo) {
        super(id,nombre,telefono,mail);
        this.cargo = cargo;
        this.especialidad = especialidad;
        this.sueldo = sueldo;
    }


    @Override
    public String registrar() {
        return "Guia turistico registrado";
    }

    @Override
    public String MostrarDatos() {
        return super.MostrarDatos()+"Cargo: "+cargo+" Especialidad: "+especialidad+" Sueldo: "+sueldo;
    }

    @Override
    public String toString() {
        return "g"+";"+super.toString()+ cargo + ";" + especialidad + ";" + sueldo;
    }
}
