package data;

import model.GuiaTuristico;
import model.OperadorTransporte;
import model.Proveedores;
import model.Registrable;
import java.util.*;
import java.io.*;


public class GestorDatos implements Registrable {


    private static ArrayList<Registrable> recursos = new ArrayList<>();
    public static String escribirArchivo(String nombreArchivo, String contenido) {
        try {
            File archivo = new File(nombreArchivo);

            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(archivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(contenido);
            bufferedWriter.newLine();
            bufferedWriter.close();

            return "Datos guardados correctamente.";

        } catch (IOException e) {
            return "Error al escribir en el archivo: " + e.getMessage();
        }catch(Exception e){
            return "Error al escribir en el archivo: " + e.getMessage();
        }
    }

    public static String leerArchivoGuia(String nombreArchivo) {
        recursos.clear(); //limpia la lista antes de leer el archivo, asi no se duplica
        StringBuilder contenido = new StringBuilder();
        try {
            File archivo = new File(nombreArchivo);

            if (!archivo.exists()) {
                return "El archivo no existe.";
            }

            FileReader fileReader = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                if(linea.isBlank()){
                    continue;
                }

                String[] datos = linea.split(";");
                String tipo = datos[0];
                switch (tipo) {
                    case "g":
                        int sueldo = Integer.parseInt(datos[7]);
                        recursos.add(new GuiaTuristico(datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], sueldo));
                        break;
                }
            }

            bufferedReader.close();

            for(Registrable r:recursos){
                if (r instanceof GuiaTuristico){
                    contenido.append(r.MostrarDatos()+"\n");
                }
            }

            if (contenido.isEmpty()) {
                return "El archivo está vacío.";
            }

            return contenido.toString();

        } catch (IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
        } catch (RuntimeException e) {
            return "INGRESE TODOS LOS VALORES: " + e.getMessage();
        }
    }
    public static String leerArchivoTransportista(String nombreArchivo) {
        recursos.clear(); //Limpia la lista antes de leer el archivo, asi no se duplica
        StringBuilder contenido = new StringBuilder();
        try {
            File archivo = new File(nombreArchivo);

            if (!archivo.exists()) {
                return "El archivo no existe.";
            }

            FileReader fileReader = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                if(linea.isBlank()){
                    continue;
                }

                String[] datos = linea.split(";");
                String tipo = datos[0];
                switch (tipo) {
                    case "t":
                        int sueldo = Integer.parseInt(datos[7]);
                        recursos.add(new OperadorTransporte(datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], sueldo));
                        break;
                }
            }
            bufferedReader.close();

            for(Registrable r:recursos){
                if (r instanceof OperadorTransporte){
                    contenido.append(r.MostrarDatos()+"\n");
                }
            }

            if (contenido.isEmpty()) {
                return "El archivo está vacío.";
            }

            return contenido.toString();

        } catch (IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
        }
    }  //FALTA LEER ARCHIVO PROVEEDORES
    public static String leerArchivoProveedores(String nombreArchivo) {
        recursos.clear(); //limpia la lista antes de leer el archivo, asi no se duplica
        StringBuilder contenido = new StringBuilder();
        try {
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                return "El archivo no existe.";
            }
            FileReader fileReader = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                if(linea.isBlank()){
                    continue;
                }

                String[] datos = linea.split(";");
                String tipo = datos[0];
                switch (tipo) {
                    case "p":
                        recursos.add(new Proveedores(datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7]));
                        break;
                }
            }
            bufferedReader.close();

            for(Registrable r:recursos){
                if (r instanceof Proveedores){
                    contenido.append(r.MostrarDatos()+"\n");
                }
            }

            if (contenido.isEmpty()) {
                return "El archivo está vacío.";
            }

            return contenido.toString();

        } catch (IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
        } catch (RuntimeException e) {
            return "INGRESE TODOS LOS VALORES: " + e.getMessage();
        }
    }


    @Override
    public String registrar() {
        return "";
    }

    @Override
    public String MostrarDatos() {
        return "";
    }
}
